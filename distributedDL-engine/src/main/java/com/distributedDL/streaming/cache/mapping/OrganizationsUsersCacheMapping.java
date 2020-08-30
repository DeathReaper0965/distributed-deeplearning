package com.distributedDL.streaming.cache.mapping;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.mapping.AppCacheMapping;
import com.distributedDL.streaming.models.consumer.OrganizationsUsersConsumerModel;

@SuppressWarnings("serial")
public class OrganizationsUsersCacheMapping extends AppCacheMapping<OrganizationsUsersConsumerModel>{
	
	public OrganizationsUsersCacheMapping() {
		this.setCacheDir(CommonUtils.getCacheDirectory() + CommonConstants.MONGO_DUMP_DB + "/organizations_users_cache");
		rocksDbCache = new RocksDbCache(this.getCacheDir(), false);
	}

	@Override
	public Boolean mapping(OrganizationsUsersConsumerModel organizationsUsersConsumerModel) {
		Boolean insertionStatus = rocksDbCache.put(organizationsUsersConsumerModel.getId(), organizationsUsersConsumerModel);
		
		return insertionStatus;
	}

}
