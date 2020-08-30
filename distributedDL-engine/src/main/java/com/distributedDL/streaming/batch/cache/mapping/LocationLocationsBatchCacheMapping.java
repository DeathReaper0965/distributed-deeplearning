package com.distributedDL.streaming.batch.cache.mapping;

import org.apache.flink.types.Row;
import org.postgresql.util.PGobject;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.LocationLocationsConsumerModel;

@SuppressWarnings({"serial", "static-access" })
public class LocationLocationsBatchCacheMapping extends AppBatchMapping{
	
	public LocationLocationsBatchCacheMapping(RocksDbCache rocksDbCache) {
		super(rocksDbCache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		LocationLocationsConsumerModel consumerModel = new LocationLocationsConsumerModel();
		
		consumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		consumerModel.setMongoId(CommonUtils.checkNull(value.getField(1)));
		consumerModel.setName(CommonUtils.checkNull(value.getField(2)));
		consumerModel.setDisplayName(CommonUtils.checkNull(value.getField(3)));
		consumerModel.setType(CommonUtils.checkNull(value.getField(4)));
		consumerModel.setStatus(CommonUtils.checkNull(value.getField(5)));
		consumerModel.setContinentId(CommonUtils.checkNull(value.getField(6)));
		consumerModel.setTradeId(CommonUtils.checkNull(value.getField(7)));
		consumerModel.setCountryId(CommonUtils.checkNull(value.getField(8)));
		consumerModel.setRegionId(CommonUtils.checkNull(value.getField(9)));
		consumerModel.setCityId(CommonUtils.checkNull(value.getField(10)));
		consumerModel.setClusterId(CommonUtils.checkNull(value.getField(11)));
		consumerModel.setPortId(CommonUtils.checkNull(value.getField(12)));
		consumerModel.setPincodeId(CommonUtils.checkNull(value.getField(13)));
		consumerModel.setLatitude(CommonUtils.checkNull(value.getField(14)));
		consumerModel.setLongitude(CommonUtils.checkNull(value.getField(15)));
		consumerModel.setLoc(value.getField(16) != null ? (PGobject) value.getField(16): null);
		consumerModel.setPostalCode(CommonUtils.checkNull(value.getField(17)));
		consumerModel.setIsIcd(Boolean.valueOf(CommonUtils.checkNull(value.getField(18))));
		consumerModel.setIsAirport(Boolean.valueOf(CommonUtils.checkNull(value.getField(19))));
		consumerModel.setPortCode(CommonUtils.checkNull(value.getField(20)));
		consumerModel.setInttraCode(CommonUtils.checkNull(value.getField(21)));
		consumerModel.icdPorts = CommonUtils.checkNullJdbc4Array(value.getField(22));
		consumerModel.setCurrencyCode(CommonUtils.checkNull(value.getField(23)));
		consumerModel.setCountryCode(CommonUtils.checkNull(value.getField(24)));
		consumerModel.setMobileCountryCode(CommonUtils.checkNull(value.getField(25)));
		consumerModel.setFlagIconUrl(CommonUtils.checkNull(value.getField(26)));
		consumerModel.setFlagImageUrl(CommonUtils.checkNull(value.getField(27)));
		consumerModel.setCreatedAt(CommonUtils.checkNullDate(value.getField(28)));
		consumerModel.setUpdatedAt(CommonUtils.checkNullDate(value.getField(29)));
		
		return rocksDbCache.put(consumerModel.getId(), consumerModel);
	}
}
