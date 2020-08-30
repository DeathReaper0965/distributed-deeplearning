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
public class FinanceInvoiceDocumentsConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("invoice_id")
	private String invoiceId; 

	@JsonProperty("admin_id")
	private String adminId; 

	@JsonProperty("file_name")
	private String fileName; 

	@JsonProperty("file_type")
	private String fileType; 

	@JsonProperty("url")
	private String url; 

	@JsonProperty("desc")
	private String desc; 

	@JsonProperty("invoice_no")
	private String invoiceNo; 

	@JsonProperty("vendor_invoice_amount")
	private Integer vendorInvoiceAmount; 

	@JsonProperty("uploaded_at")
	private Date uploadedAt; 

	@JsonProperty("active")
	private Boolean active; 

	@JsonProperty("verification_status")
	private String verificationStatus; 

	@JsonProperty("rejected_at")
	private Date rejectedAt; 

	@JsonProperty("verified_at")
	private Date verifiedAt; 

	@JsonProperty("is_proforma")
	private Boolean isProforma; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 

	@JsonProperty("mongo_id")
	private String mongoId; 


}