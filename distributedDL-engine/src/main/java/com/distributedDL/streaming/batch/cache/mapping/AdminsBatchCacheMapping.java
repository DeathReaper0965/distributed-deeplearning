package com.distributedDL.streaming.batch.cache.mapping;

import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.AdminsConsumerModel;

@SuppressWarnings({"serial" })
public class AdminsBatchCacheMapping extends AppBatchMapping{
	
	public AdminsBatchCacheMapping(RocksDbCache rocksDbCache) {
		super(rocksDbCache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		AdminsConsumerModel consumerModel = new AdminsConsumerModel(); 
		
		consumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		consumerModel.setEmail(CommonUtils.checkNull(value.getField(1)));
		consumerModel.setIncId(Long.valueOf(CommonUtils.checkNull(value.getField(2))));
		consumerModel.setName(CommonUtils.checkNull(value.getField(3)));
		consumerModel.setPhoneNo(CommonUtils.checkNull(value.getField(4)));
		consumerModel.setStatus(CommonUtils.checkNull(value.getField(5)));
		
		return rocksDbCache.put(consumerModel.getId(), consumerModel);
	}

}
