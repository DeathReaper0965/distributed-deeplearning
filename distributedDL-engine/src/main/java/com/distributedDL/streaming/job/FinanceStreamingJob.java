package com.distributedDL.streaming.job;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.mapping.FinanceInvoicesMapping;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class FinanceStreamingJob extends AppStreamingJob {
	
	public FinanceStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.FINANCE_DB);
		template.setTableName(CommonConstants.FINANCE_INVOICES_TABLE);
	}
	
	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Finance Transformer...");
		return stream.map(new FinanceInvoicesMapping());
	}

}
