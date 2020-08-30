package com.distributedDL.streaming.models.consumer;

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
public class FinanceInvoiceTransactionsConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("invoice_id")
	private String invoiceId; 

	@JsonProperty("master_transaction_id")
	private String masterTransactionId; 

	@JsonProperty("updated_by_id")
	private String updatedById; 

	@JsonProperty("amount")
	private Double amount; 

	@JsonProperty("bank")
	private String bank; 

	@JsonProperty("transaction_id")
	private String transactionId; 

	@JsonProperty("transaction_mode")
	private String transactionMode; 

	@JsonProperty("currency")
	private String currency; 

	@JsonProperty("status")
	private String status; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 

	@JsonProperty("mongo_id")
	private String mongoId; 

	@JsonProperty("tds_cert_url")
	private String tdsCertUrl; 

	@JsonProperty("filing_type")
	private String filingType; 

	@JsonProperty("assessment_year")
	private Integer assessmentYear; 

	@JsonProperty("organization_user_id")
	private String organizationUserId; 


}