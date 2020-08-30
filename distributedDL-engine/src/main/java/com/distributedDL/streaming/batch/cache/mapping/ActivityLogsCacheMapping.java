package com.distributedDL.streaming.batch.cache.mapping;

import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.ActivityLogConsumerModel;

@SuppressWarnings({ "serial" })
public class ActivityLogsCacheMapping extends AppBatchMapping{
	
	
	public ActivityLogsCacheMapping(RocksDbCache rocksDbCache) {
		super(rocksDbCache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		ActivityLogConsumerModel organizationsConsumerModel = new ActivityLogConsumerModel(); 
		
		organizationsConsumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		organizationsConsumerModel.setActivityTime(CommonUtils.checkNull(value.getField(1)));
		organizationsConsumerModel.setCallDuration(CommonUtils.checkNullAndDouble(value.getField(2)));
		organizationsConsumerModel.setCallLogBucketId(CommonUtils.checkNull(value.getField(3)));
		organizationsConsumerModel.setCallLogTagId(CommonUtils.checkNull(value.getField(4)));
		organizationsConsumerModel.setCallOutput(CommonUtils.checkNull(value.getField(5)));
		organizationsConsumerModel.setCallReason(CommonUtils.checkNull(value.getField(6)));
		organizationsConsumerModel.setContactId(CommonUtils.checkNull(value.getField(7)));
		organizationsConsumerModel.setCreatedAt(CommonUtils.checkNull(value.getField(8)));
		organizationsConsumerModel.setDescription(CommonUtils.checkNull(value.getField(9)));
		organizationsConsumerModel.setIncId(Integer.valueOf(CommonUtils.checkNull(value.getField(10))));
		organizationsConsumerModel.setNotResponded(Boolean.valueOf(CommonUtils.checkNull(value.getField(11))));
		organizationsConsumerModel.setOwnerId(CommonUtils.checkNull(value.getField(12)));
		organizationsConsumerModel.setType(CommonUtils.checkNull(value.getField(13)));
		organizationsConsumerModel.setUpdatedAt(CommonUtils.checkNullDate(value.getField(14)));
		
		return rocksDbCache.put(organizationsConsumerModel.getId(), organizationsConsumerModel);
	}

}
