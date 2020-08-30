package com.distributedDL.streaming.batch.cache.mapping;

import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.OrganizationOrganizationUsersConsumerModel;

@SuppressWarnings({"serial", "static-access"})
public class OrgOrgUsersBatchCacheMapping extends AppBatchMapping {

	public OrgOrgUsersBatchCacheMapping(RocksDbCache cache) {
		super(cache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		OrganizationOrganizationUsersConsumerModel oouConsumerModel = new OrganizationOrganizationUsersConsumerModel();
		
		oouConsumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		oouConsumerModel.setOrganizationId(CommonUtils.checkNull(value.getField(1)));
		oouConsumerModel.setUserId(CommonUtils.checkNull(value.getField(2)));
		oouConsumerModel.setStatus(CommonUtils.checkNull(value.getField(3)));
		oouConsumerModel.setDesignation(CommonUtils.checkNull(value.getField(4)));
		oouConsumerModel.mongoIds = CommonUtils.checkNullJdbc4Array(value.getField(5));
		oouConsumerModel.setCreatedAt(CommonUtils.checkNullDate(value.getField(6)));
		oouConsumerModel.setUpdatedAt(CommonUtils.checkNullDate(value.getField(7)));
		
		return rocksDbCache.put(oouConsumerModel.getId(), oouConsumerModel);
	}

}
