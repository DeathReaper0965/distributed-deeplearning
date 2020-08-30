package com.distributedDL.streaming.cache.mapping;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.mapping.AppCacheMapping;
import com.distributedDL.streaming.models.consumer.LocationLocationsConsumerModel;

@SuppressWarnings("serial")
public class LocationLocationsCacheMapping extends AppCacheMapping<LocationLocationsConsumerModel>{
	
	public LocationLocationsCacheMapping() {
		this.setCacheDir(CommonUtils.getCacheDirectory() + CommonConstants.LOCATION_DB + "/location_locations_cache");
		rocksDbCache = new RocksDbCache(this.getCacheDir(), false);
	}
	
	@Override
	public Boolean mapping(LocationLocationsConsumerModel locationLocationsConsumerModel) {
		Boolean insertionStatus = rocksDbCache.put(locationLocationsConsumerModel.getId(), locationLocationsConsumerModel);
		
		return insertionStatus;
	}
	
}
