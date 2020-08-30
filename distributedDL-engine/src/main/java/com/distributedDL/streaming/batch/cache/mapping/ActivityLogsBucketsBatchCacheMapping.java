package com.distributedDL.streaming.batch.cache.mapping;

import java.util.Date;

import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.AlBucketConsumerModel;

@SuppressWarnings({"serial"})
public class ActivityLogsBucketsBatchCacheMapping extends AppBatchMapping{
	
	public ActivityLogsBucketsBatchCacheMapping(RocksDbCache rocksDbCache) {
		super(rocksDbCache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		AlBucketConsumerModel consumerModel = new AlBucketConsumerModel(); 
		
		consumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		consumerModel.setCreatedAt((Date) value.getField(1));
		consumerModel.setName(CommonUtils.checkNull(value.getField(2)));
		consumerModel.setUpdatedAt((Date) value.getField(3));
		
		return rocksDbCache.put(consumerModel.getId(), consumerModel);
	}

}
