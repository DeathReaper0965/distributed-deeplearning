package com.distributedDL.streaming.batch.cache.mapping;

import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.AlTagConsumerModel;

@SuppressWarnings({"serial" })
public class ActivityLogsTagsBatchCacheMapping extends AppBatchMapping{
	
	public ActivityLogsTagsBatchCacheMapping(RocksDbCache rocksDbCache) {
		super(rocksDbCache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		AlTagConsumerModel consumerModel = new AlTagConsumerModel(); 
		
		consumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		consumerModel.setName(CommonUtils.checkNull(value.getField(1)));
		
		return rocksDbCache.put(consumerModel.getId(), consumerModel);
	}

}
