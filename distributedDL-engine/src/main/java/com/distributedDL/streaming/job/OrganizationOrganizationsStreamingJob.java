package com.distributedDL.streaming.job;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.assigners.StreamPunctuatedWatermarkAssigner;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class OrganizationOrganizationsStreamingJob extends AppStreamingJob {

	public OrganizationOrganizationsStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.FINANCE_DB);
		template.setTableName(CommonConstants.ORGANIZATION_ORGANIZATIONS_TABLE);
	}
	
	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Organization Organizations Streaming Job Transformer...");
		
		stream = stream.assignTimestampsAndWatermarks(new StreamPunctuatedWatermarkAssigner()).setParallelism(CommonConstants.DEFAULT_PARALLELISM);
		
		return stream;
	}

}
