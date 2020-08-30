package com.distributedDL.streaming.models.producer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@JsonSerialize
@EqualsAndHashCode(callSuper = true)
public class TicketProducerModel extends AppProducerModel{
	String ticket_id;
	String reasons;
}
