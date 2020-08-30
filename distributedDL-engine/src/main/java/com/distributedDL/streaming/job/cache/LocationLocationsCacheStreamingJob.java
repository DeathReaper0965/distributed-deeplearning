package com.distributedDL.streaming.job.cache;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.cache.mapping.LocationLocationsCacheMapping;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.job.AppStreamingJob;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LocationLocationsCacheStreamingJob extends AppStreamingJob{
	
	public LocationLocationsCacheStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.LOCATION_DB);
		template.setTableName(CommonConstants.LOCATION_LOCATIONS_TABLE);
	}

	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Location Locations Transformer...");
		return stream.map(new LocationLocationsCacheMapping());
	}
	
}
