package com.distributedDL.streaming.cache.mapping;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.mapping.AppCacheMapping;
import com.distributedDL.streaming.models.consumer.ShipmentOrdersConsumerModel;

@SuppressWarnings("serial")
public class ShipmentOrderCacheMapping extends AppCacheMapping<ShipmentOrdersConsumerModel>{
    
    public ShipmentOrderCacheMapping() {
		this.setCacheDir(CommonUtils.getCacheDirectory() + CommonConstants.SHIPMENT_DB + "/shipment_order_cache");
		rocksDbCache = new RocksDbCache(this.getCacheDir(), false);
	}
    
	@Override
	public Boolean mapping(ShipmentOrdersConsumerModel shipmentOrderConsumerModel) {
		Boolean insertionStatus = rocksDbCache.put(shipmentOrderConsumerModel.getId(), shipmentOrderConsumerModel);
		
		return insertionStatus;
	}

}
