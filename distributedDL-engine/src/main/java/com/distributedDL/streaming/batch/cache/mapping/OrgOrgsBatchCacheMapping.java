package com.distributedDL.streaming.batch.cache.mapping;

import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.OrganizationOrganizationsConsumerModel;

@SuppressWarnings("serial")
public class OrgOrgsBatchCacheMapping extends AppBatchMapping {

	public OrgOrgsBatchCacheMapping(RocksDbCache cache) {
		super(cache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		OrganizationOrganizationsConsumerModel organizationOrganizationsConsumerModel = new OrganizationOrganizationsConsumerModel();
		
		organizationOrganizationsConsumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		organizationOrganizationsConsumerModel.setSerialId(CommonUtils.checkNullAndInteger(value.getField(1)));
		organizationOrganizationsConsumerModel.setBusinessName(CommonUtils.checkNull(value.getField(2)));
		organizationOrganizationsConsumerModel.setShortName(CommonUtils.checkNull(value.getField(3)));
		organizationOrganizationsConsumerModel.setAbout(CommonUtils.checkNull(value.getField(4)));
		organizationOrganizationsConsumerModel.setAccountType(CommonUtils.checkNull(value.getField(5)));
		organizationOrganizationsConsumerModel.setWebsite(CommonUtils.checkNull(value.getField(6)));
		organizationOrganizationsConsumerModel.setLogo(CommonUtils.checkNull(value.getField(7)));
		organizationOrganizationsConsumerModel.setStatus(CommonUtils.checkNull(value.getField(8)));
		organizationOrganizationsConsumerModel.setMongoId(CommonUtils.checkNull(value.getField(9)));
		organizationOrganizationsConsumerModel.setCreatedAt(CommonUtils.checkNullDate(value.getField(10)));
		organizationOrganizationsConsumerModel.setUpdatedAt(CommonUtils.checkNullDate(value.getField(11)));
		
		return rocksDbCache.put(organizationOrganizationsConsumerModel.getId(), organizationOrganizationsConsumerModel);
	}

}
