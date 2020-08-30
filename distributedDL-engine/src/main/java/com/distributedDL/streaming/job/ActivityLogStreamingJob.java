package com.distributedDL.streaming.job;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.mapping.ActivityLogMapping;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ActivityLogStreamingJob extends AppStreamingJob{

	public ActivityLogStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.MONGO_DUMP_DB);
		template.setTableName(CommonConstants.ACTIVITY_LOGS_TABLE);
	}
	
	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding MongoDump Transformer...");
		return stream.map(new ActivityLogMapping());
	}

}
