package com.distributedDL.streaming.job.cache;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.cache.mapping.ShipmentOrderCacheMapping;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.job.AppStreamingJob;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ShipmentOrderCacheStreamingJob extends AppStreamingJob{
	
	public ShipmentOrderCacheStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.SHIPMENT_DB);
		template.setTableName(CommonConstants.SHIPMENT_ORDERS_TABLE);
	}

	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding ShipmentOrder Cache Transformer...");
		return stream.map(new ShipmentOrderCacheMapping());
	}
	
}
