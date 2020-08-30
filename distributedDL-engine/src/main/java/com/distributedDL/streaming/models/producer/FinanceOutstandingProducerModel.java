package com.distributedDL.streaming.models.producer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@JsonDeserialize
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class FinanceOutstandingProducerModel extends AppProducerModel {
	
	@JsonProperty("business_name")
	private String businessName; 

	@JsonProperty("due_date")
	private Date dueDate; 

	@JsonProperty("inr_total_due_amount")
	private Double inrTotalDueAmount; 

	@JsonProperty("invoice_type")
	private String invoiceType; 

	@JsonProperty("status")
	private String status; 


}