package com.distributedDL.streaming.job;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.assigners.StreamPunctuatedWatermarkAssigner;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ShipmentOrdersStreamingJob extends AppStreamingJob {

	public ShipmentOrdersStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.SHIPMENT_DB);
		template.setTableName(CommonConstants.SHIPMENT_ORDERS_TABLE);
	}

	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Shipment Transformer...");
		
		stream = stream.assignTimestampsAndWatermarks(new StreamPunctuatedWatermarkAssigner()).setParallelism(CommonConstants.DEFAULT_PARALLELISM);
		
		return stream;
	}

}
