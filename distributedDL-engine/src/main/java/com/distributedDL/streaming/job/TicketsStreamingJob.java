package com.distributedDL.streaming.job;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.mapping.TicketEscalationMapping;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TicketsStreamingJob extends AppStreamingJob {

	public TicketsStreamingJob() {
		super();
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.distributedDL_API_DB);
		template.setTableName(CommonConstants.TICKET_ESCALATION_REASONS_TABLE);
	}

	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Ticket Transformer...");
		return stream.map(new TicketEscalationMapping());
	}
	
}
