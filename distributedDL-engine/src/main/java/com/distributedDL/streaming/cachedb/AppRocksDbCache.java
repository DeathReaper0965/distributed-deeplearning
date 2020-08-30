package com.distributedDL.streaming.cachedb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface AppRocksDbCache extends Serializable{
    void init(Boolean toClean, String cacheDir, Boolean isReadOnly) throws Exception;

    void cleanup();

    Object get(String key);

    Map<String, Object> getBatch(List<String> keysList);

    void remove(String key);

    void removeBatch(List<String> keys);

    Boolean put(String key, Object value);

    Boolean putBatch(Map<String, Object> map);

    byte[] serialize(Object data);
    
    Object deserialize(byte[] data);
}
