package com.distributedDL.streaming.job.cache;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.cache.mapping.OrganizationsCacheMapping;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.job.AppStreamingJob;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class OrganizationsCacheStreamingJob extends AppStreamingJob{
	
	public OrganizationsCacheStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.MONGO_DUMP_DB);
		template.setTableName(CommonConstants.ORGANIZATIONS_TABLE);
	}

	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Organizations Cache Transformer...");
		return stream.map(new OrganizationsCacheMapping());
	}

}
