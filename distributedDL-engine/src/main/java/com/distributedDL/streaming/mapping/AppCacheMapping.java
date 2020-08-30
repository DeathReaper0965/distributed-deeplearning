package com.distributedDL.streaming.mapping;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.core.Mapper;
import com.distributedDL.streaming.models.consumer.AppConsumerModel;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings({"serial", "unchecked"})
public abstract class AppCacheMapping<X> extends Mapper<ChangeDataConsumerModel, Boolean> {
	ChangeDataConsumerModel changeDataConsumerModel = null;
	AppConsumerModel appConsumerModel = null;
	
	protected String cacheDir;
    protected static RocksDbCache rocksDbCache = null;
    private HashMap<String, Object> streamMap = new HashMap<String, Object>();
	
	@Override
	public Boolean map(ChangeDataConsumerModel changeDataConsumerModel) throws Exception {
		
		this.setChangeDataConsumerModel(changeDataConsumerModel);
		LinkedHashMap<String, Object> consumerMap = changeDataConsumerModel.getAfter();
		
		if (consumerMap == null)
			return null;
		
		this.setAppConsumerModel((AppConsumerModel) this.getInstanceOfX());
		this.setAppConsumerModel(
				(AppConsumerModel) this.getMapper().convertValue(consumerMap, this.getAppConsumerModel().getClass()));
		
		return this.mapping((X) this.getAppConsumerModel());
	}
	
	public abstract Boolean mapping(X consumer);
	
	public X getInstanceOfX() {
		ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
		Class<X> type = (Class<X>) superClass.getActualTypeArguments()[0];
		try {
			return type.newInstance();
		} catch (Exception e) {
			// Oops, no default constructor
			throw new RuntimeException(e);
		}
	}
	
}
