package com.distributedDL.streaming.cachedb;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.rocksdb.CompressionType;
import org.rocksdb.FlushOptions;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.WriteBatch;
import org.rocksdb.WriteOptions;
import org.rocksdb.util.SizeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.distributedDL.streaming.common.CommonUtils;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class RocksDbCache implements AppRocksDbCache{
	
	private static Logger LOG = LoggerFactory.getLogger(RocksDbCache.class);
	
	static {
		RocksDB.loadLibrary();
	}
	
	final Options options = new Options();
	
	protected String rootDir;
	
	public static RocksDB rocksDb = null;
	
	private Boolean isReadOnly = false;
	
	public RocksDbCache(String dbPath, Boolean isReadOnly) {
		
		this.setIsReadOnly(isReadOnly);
		
		String dirPath = String.join("/", Arrays.copyOf(dbPath.split("/"), dbPath.split("/").length-1));
		
		if(!CommonUtils.existsFile(dirPath)) {
			try {
				CommonUtils.makeLocalDir(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		this.cleanup();
		
		try {
			options.setCreateIfMissing(true)
				   .setCreateMissingColumnFamilies(true)
				   .setWriteBufferSize(128 * SizeUnit.MB)
				   .setMaxWriteBufferNumber(20)
				   .setMaxBackgroundCompactions(10)
				   .setCompressionType(CompressionType.SNAPPY_COMPRESSION)
				   .setMaxManifestFileSize(128 * SizeUnit.MB);
		}catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		
		try {
			this.initDb(options, dbPath, isReadOnly);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void initDir(Boolean toClean) {
        LOG.info("RocksDB reset is " + toClean);
        
        String rocksDir = CommonUtils.getCacheDirectory();
        if (toClean) {
            try {
                CommonUtils.removeDir(rocksDir);
            } catch (IOException e) {
                throw new RuntimeException("Failed to cleanup Root Dir of rocksDB " + rocksDir);
            }
        }

        File file = new File(rocksDir);
        if (!file.exists()) {
            try {
                CommonUtils.makeLocalDir(rocksDir);
                file = new File(rocksDir);
            } catch (IOException e) {
                throw new RuntimeException("Failed to make directory for rocksDB " + rocksDir);
            }
        }

        rootDir = file.getAbsolutePath();
    }
	
	public void initDb(Options dbOptions, String cacheDir, Boolean isReadOnly) throws Exception {
		
		if (dbOptions == null) {
			dbOptions = new Options().setCreateMissingColumnFamilies(true).setCreateIfMissing(true);
		}
		
        try {
        	if(isReadOnly) {
        		rocksDb = RocksDB.openReadOnly(cacheDir);
        	}else {
        		rocksDb = RocksDB.open(dbOptions, cacheDir);
        	}
            LOG.info("Successfully initialized rocksDB at {}", rootDir);
        } finally {
            if (dbOptions != null) {
                dbOptions.close();
            }
        }
    }

	@Override
	public void init(Boolean toClean, String cacheDir, Boolean isReadOnly) throws Exception {
		this.initDir(toClean);
		
		boolean isSuccess = false;
        for (int i = 0; i < 3; i++) {
            try {
                initDb(null, cacheDir, isReadOnly);
                isSuccess = true;
                break;
            } catch (Exception e) {
                LOG.error("Failed to init rocksDB " + rootDir, e);
                try {
                    CommonUtils.removeDir(rootDir);
                } catch (IOException ioe) {
                	LOG.error("Failed to remove rocksDB Directory" + rootDir, ioe);
                }
            }
        }

        if (!isSuccess) {
            throw new RuntimeException("Failed to init rocksDB " + rootDir);
        }
		
	}

	@Override
	public void cleanup() {
		if (rocksDb != null) {
			try {
				if(!this.getIsReadOnly()) {
					rocksDb.flush(new FlushOptions());
				}
			} catch (RocksDBException e) {
				e.printStackTrace();
			}
			rocksDb.close();
			LOG.info("Successfully closed RocksDB");
		}
	}

	@Override
	public Object get(String key) {
		try {
            byte[] data = rocksDb.get(key.getBytes());
            
            if (data != null) {
                try {
                    return deserialize(data);
                } catch (Exception e) {
                    LOG.error("Failed to deserialize obj of " + key, e);
                    return null;
                }
            }

        } catch (Exception e) {
        	LOG.error("Some error Occured: ", e);
        }

        return null;
	}

	@Override
	public Map<String, Object> getBatch(List<String> keysList) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<byte[]> keys = new ArrayList<>();
		
        for (String key : keysList) {
            keys.add(key.getBytes());
        }

        try {
            List<byte[]> values = rocksDb.multiGetAsList(keys);
            if (values == null || values.size() == 0) {
                return null;
            }
            
            for (int i=0; i<keys.size(); i++) {
                byte[] keyByte = keys.get(i);
                byte[] valueByte = values.get(i);

                if (keyByte == null || valueByte == null) {
                    continue;
                }

                Object value;
                try {
                    value = deserialize(valueByte);
                } catch (Exception e) {
                    LOG.error("Failed to deserialize object of " + new String(keyByte));
                    continue;
                }

                map.put(new String(keyByte), value);
            }
            
            return map;
        } catch (Exception e) {
            LOG.error("Failed to query " + map.keySet() + ", in window: " + map.values());
            return null;
        }
	}

	@Override
	public void remove(String key) {
		try {
            rocksDb.delete(key.getBytes());

        } catch (Exception e) {
            LOG.error("Failed to remove " + key);
        }
	}

	@Override
	public void removeBatch(List<String> keys) {
		for (String key: keys) {
			remove(key);
		}
	}

	@Override
	public Boolean put(String key, Object value) {
		byte[] data = serialize(value);
		
        try {
            rocksDb.put(key.getBytes(), data);
            return true;
        } catch (Exception e) {
            LOG.error("Failed to put key into cache, " + key, e);
        }
        return false;
	}

	@Override
	public Boolean putBatch(Map<String, Object> map) {
		WriteOptions writeOpts = null;
        WriteBatch writeBatch = null;

        try {
            writeOpts = new WriteOptions();
            writeBatch = new WriteBatch();

            for (Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                byte[] data = serialize(value);

                if (StringUtils.isBlank(key) || data == null || data.length == 0) {
                    continue;
                }

                writeBatch.put(key.getBytes(), data);
            }

            rocksDb.write(writeOpts, writeBatch);
            return true;
        } catch (Exception e) {
            LOG.error("Failed to put Batch into DB, " + map.keySet(), e);
        } finally {
            if (writeOpts != null) {
                writeOpts.close();
            }

            if (writeBatch != null) {
                writeBatch.close();
            }
        }
        
        return false;
	}

	@Override
	public byte[] serialize(Object data) {
		return SerializationUtils.serialize((Serializable) data);
	}

	@Override
	public Object deserialize(byte[] data) {
		return SerializationUtils.deserialize(data);
	}
	
	
	
}
