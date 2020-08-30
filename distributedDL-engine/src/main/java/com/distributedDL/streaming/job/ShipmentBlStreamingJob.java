package com.distributedDL.streaming.job;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.assigners.StreamPunctuatedWatermarkAssigner;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ShipmentBlStreamingJob extends AppStreamingJob{
	
	public ShipmentBlStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.SHIPMENT_DB);
		template.setTableName(CommonConstants.SHIPMENT_BL_DETAILS_TABLE);
	}

	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Shipment BL Details Transformer...");
		
		stream = stream.assignTimestampsAndWatermarks(new StreamPunctuatedWatermarkAssigner()).setParallelism(CommonConstants.DEFAULT_PARALLELISM);
		
		return stream;
	}
	
}
