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
public class FinanceInvoiceLineItemsConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("invoice_id")
	private String invoiceId; 

	@JsonProperty("tax_id")
	private String taxId; 

	@JsonProperty("name")
	private String name; 

	@JsonProperty("tax_name")
	private String taxName; 

	@JsonProperty("tax_rate")
	private Double taxRate; 

	@JsonProperty("tax_amount")
	private Double taxAmount; 

	@JsonProperty("quantity")
	private Integer quantity; 

	@JsonProperty("rate")
	private Double rate; 

	@JsonProperty("amount")
	private Double amount; 

	@JsonProperty("currency")
	private String currency; 

	@JsonProperty("sac_code")
	private String sacCode; 

	@JsonProperty("unit")
	private String unit; 

	@JsonProperty("comments")
	private String comments; 

	@JsonProperty("discount")
	private Double discount; 

	@JsonProperty("discount_currency")
	private String discountCurrency; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 

	@JsonProperty("mongo_id")
	private String mongoId; 


}