package com.distributedDL.streaming.mapping;

import com.distributedDL.streaming.models.consumer.TicketConsumerModel;
import com.distributedDL.streaming.models.producer.TicketProducerModel;

@SuppressWarnings("serial")
public class TicketEscalationMapping extends AppMapping<TicketConsumerModel, TicketProducerModel> {

	public TicketProducerModel mapping(TicketConsumerModel ticketConsumerModel, TicketProducerModel ticketProducerModel) {
		
		ticketProducerModel.setReasons(ticketConsumerModel.getReason());
		ticketProducerModel.setTicket_id(ticketConsumerModel.getId());
		
		return ticketProducerModel;
	}
}
