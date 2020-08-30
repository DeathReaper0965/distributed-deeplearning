package com.distributedDL.streaming.batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat.JDBCInputFormatBuilder;
import org.apache.flink.api.java.typeutils.RowTypeInfo;
import org.apache.flink.configuration.Configuration;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;

import lombok.Data;

@Data
@SuppressWarnings({"rawtypes" })
public abstract class BatchJob{
	public String batchName;
	
	private String tableName;
	
	private String schemaName;
	
	public TypeInformation<?>[] fieldTypes;
	
	private String batchCacheDir = null;
	
	public List<TypeInformation> types = new ArrayList<TypeInformation>();
	
	private String dbDriverName = null;
	
	private String dbUrl = null;
	
	private String dbUsername = null;
	
	private String dbPassword = null;
	
	private String query = null;
	
	private String producerHost = null;

	private String producerPort = null;
	
	private JDBCInputFormatBuilder inputFormatBuilder = JDBCInputFormat.buildJDBCInputFormat();
	
	public ExecutionEnvironment executionEnvironment;
	
	private RocksDbCache rocksDbCache = null;
	
	private Configuration conf;
	
	public BatchJob(String tableName, String schemaName, String query) {
		this.tableName = tableName;
		this.schemaName = schemaName;
		
		conf = CommonUtils.getExecutionConf();
		
		this.executionEnvironment =  ExecutionEnvironment.createLocalEnvironment(conf);
		
		if (query == null) {
			this.setQuery("SELECT * from " + this.getSchemaName() + "." + this.getTableName());
		}else {
			this.setQuery(query);
		}
		
		System.out.println(String.format("Started %s Batch Job", this.getTableName()));
		
		try {
			Properties properties = CommonUtils.loadProperties();
			dbDriverName = properties.getProperty("postgres.driver.name");
			dbUrl = properties.getProperty("postgres.staging.db.url.fdw");
			dbUsername = properties.getProperty("postgres.staging.db.username");
			dbPassword = properties.getProperty("postgres.staging.db.password");
			producerHost = properties.getProperty("kafka.producer.host");
			producerPort = properties.getProperty("kafka.producer.port");
			
			this.setInputFormatBuilder(this.getInputFormatBuilder()
										   .setDrivername(dbDriverName)
										   .setDBUrl(dbUrl)
										   .setUsername(dbUsername)
										   .setPassword(dbPassword)
										   .setQuery(this.getQuery()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		this.setExecutionEnvironment(this.startbatch());
		
	}
	
	public RocksDbCache setCacheAndGetRocksDB(String cacheDirName) {
		this.setBatchCacheDir(CommonUtils.getCacheDirectory() + this.getSchemaName() + "/" + cacheDirName);
		this.setRocksDbCache(new RocksDbCache(this.getBatchCacheDir(), false));
		return this.getRocksDbCache();
	}
	
	public RowTypeInfo getRowTypeInfoWithTypes(TypeInformation<?>[] fieldTypes) {
		return new RowTypeInfo(fieldTypes);
	}
	
	public abstract ExecutionEnvironment startbatch();
	
	public JDBCInputFormat getInputFormat(TypeInformation<?>[] fieldTypes) {
		
		return this.getInputFormatBuilder()
				   .setRowTypeInfo(this.getRowTypeInfoWithTypes(fieldTypes))
				   .finish();
	}
	
}
