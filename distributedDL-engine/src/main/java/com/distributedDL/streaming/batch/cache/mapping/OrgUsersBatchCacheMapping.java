package com.distributedDL.streaming.batch.cache.mapping;

import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.OrganizationsUsersConsumerModel;


@SuppressWarnings({"serial" })
public class OrgUsersBatchCacheMapping extends AppBatchMapping{
	
	public OrgUsersBatchCacheMapping(RocksDbCache rocksDbCache) {
		super(rocksDbCache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		OrganizationsUsersConsumerModel consumerModel = new OrganizationsUsersConsumerModel(); 
		
		consumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		consumerModel.setCreatedAt(CommonUtils.checkNull(value.getField(1)));
		consumerModel.setEmail(CommonUtils.checkNull(value.getField(2)));
		consumerModel.setEscalationDesignation(CommonUtils.checkNull(value.getField(3)));
		consumerModel.setIncId(Integer.valueOf(CommonUtils.checkNull(value.getField(4))));
		consumerModel.setIsLead(Boolean.valueOf(CommonUtils.checkNull(value.getField(5))));
		consumerModel.setName(CommonUtils.checkNull(value.getField(6)));
		consumerModel.setOrganizationId(CommonUtils.checkNull(value.getField(7)));
		consumerModel.setPhoneNo(CommonUtils.checkNull(value.getField(8)));
		consumerModel.setPreferredCurrency(CommonUtils.checkNull(value.getField(9)));
		consumerModel.setStatus(CommonUtils.checkNull(value.getField(10)));
		consumerModel.setType(CommonUtils.checkNull(value.getField(11)));
		consumerModel.setUpdatedAt(CommonUtils.checkNull(value.getField(12)));
		
		return rocksDbCache.put(consumerModel.getId(), consumerModel);
	}
	
}
