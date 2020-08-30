package com.distributedDL.streaming.cachedb;

import java.util.HashMap;

import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;

public class CacheCollection {
	
	private static String dbPath = CommonUtils.getCacheDirectory();
	
	private static HashMap<String, RocksDbCache> cacheMap = new HashMap<String, RocksDbCache>();
	
	public static  HashMap<String, RocksDbCache> getAllCaches(){
		RocksDbCache orgRocksCache = new RocksDbCache(dbPath + CommonConstants.MONGO_DUMP_DB + "/" + CommonConstants.ORGANIZATIONS_CACHE, true);
		RocksDbCache orgUsersRocksCache = new RocksDbCache(dbPath + CommonConstants.MONGO_DUMP_DB + "/" + CommonConstants.ORGANIZATIONS_USERS_CACHE, true);
		RocksDbCache adminsRocksCache = new RocksDbCache(dbPath + CommonConstants.MONGO_DUMP_DB + "/" + CommonConstants.ADMINS_CACHE, true);
		RocksDbCache activityLogsRocksCache = new RocksDbCache(dbPath + CommonConstants.MONGO_DUMP_DB + "/" + CommonConstants.ACTIVITY_LOGS_CACHE, true);
		RocksDbCache activityLogsTagsRocksCache = new RocksDbCache(dbPath + CommonConstants.MONGO_DUMP_DB + "/" + CommonConstants.ACTIVITY_LOGS_TAGS_CACHE, true);
		RocksDbCache activityLogsBucketsRocksCache = new RocksDbCache(dbPath + CommonConstants.MONGO_DUMP_DB + "/" + CommonConstants.ACTIVITY_LOGS_BUCKETS_CACHE, true);
		RocksDbCache locationLocationsRocksCache = new RocksDbCache(dbPath + CommonConstants.LOCATION_DB + "/" + CommonConstants.LOCATION_LOCATIONS_CACHE, true);
		RocksDbCache organizationOrganizationsRocksCache = new RocksDbCache(dbPath + CommonConstants.ORGANIZATION_DB + "/" + CommonConstants.ORGANIZATION_ORGANIZATIONS_CACHE, true);
		RocksDbCache oouRocksCache = new RocksDbCache(dbPath + CommonConstants.ORGANIZATION_DB + "/" + CommonConstants.ORGANIZATION_ORGANIZATIONS_USERS_CACHE, true);

		cacheMap.put(CommonConstants.ORGANIZATIONS_CACHE, orgRocksCache);
		System.out.println("Got org cache instance");
		cacheMap.put(CommonConstants.ORGANIZATIONS_USERS_CACHE, orgUsersRocksCache);
		System.out.println("Got org users cache instance");
		cacheMap.put(CommonConstants.ADMINS_CACHE, adminsRocksCache);
		System.out.println("Got admins cache instance");
		cacheMap.put(CommonConstants.ACTIVITY_LOGS_CACHE, activityLogsRocksCache);
		System.out.println("Got activity logs cache instance");
		cacheMap.put(CommonConstants.ACTIVITY_LOGS_TAGS_CACHE, activityLogsTagsRocksCache);
		System.out.println("Got activity logs tags cache instance");
		cacheMap.put(CommonConstants.ACTIVITY_LOGS_BUCKETS_CACHE, activityLogsBucketsRocksCache);
		System.out.println("Got activity logs buckets cache instance");
		cacheMap.put(CommonConstants.LOCATION_LOCATIONS_CACHE, locationLocationsRocksCache);
		System.out.println("Got location locations cache instance");
		cacheMap.put(CommonConstants.ORGANIZATION_ORGANIZATIONS_CACHE, organizationOrganizationsRocksCache);
		System.out.println("Got organization organizations cache instance");
		cacheMap.put(CommonConstants.ORGANIZATION_ORGANIZATIONS_USERS_CACHE, oouRocksCache);
		System.out.println("Got organization organization users cache instance");
		
		return cacheMap;
	}
}
