package com.distributedDL.streaming.job;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.assigners.StreamPunctuatedWatermarkAssigner;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class FinanceInvoicesStreamingJob extends AppStreamingJob {
	
	public FinanceInvoicesStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.FINANCE_DB);
		template.setTableName(CommonConstants.FINANCE_INVOICES_TABLE);
	}

	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Finance Invoices Streaming Job Transformer...");
		
		stream = stream.assignTimestampsAndWatermarks(new StreamPunctuatedWatermarkAssigner()).setParallelism(CommonConstants.DEFAULT_PARALLELISM);
		
		return stream;
	}

}
