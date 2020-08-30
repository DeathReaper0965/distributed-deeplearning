package com.distributedDL.streaming.cache.mapping;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.mapping.AppCacheMapping;
import com.distributedDL.streaming.models.consumer.OrganizationsConsumerModel;

@SuppressWarnings("serial")
public class OrganizationsCacheMapping extends AppCacheMapping<OrganizationsConsumerModel>{

	public OrganizationsCacheMapping() {
		this.setCacheDir(CommonUtils.getCacheDirectory() + CommonConstants.MONGO_DUMP_DB + "/organizations_cache");
		rocksDbCache = new RocksDbCache(this.getCacheDir(), false);
	}
	
	@Override
	public Boolean mapping(OrganizationsConsumerModel organizationsConsumerModel) {
		Boolean insertionStatus = rocksDbCache.put(organizationsConsumerModel.getId(), organizationsConsumerModel);
		
		return insertionStatus;
	}

}
