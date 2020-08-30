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
public class OrganizationServiceProviderFtlTransportServicesConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("service_profile_id")
	private String serviceProfileId; 

	@JsonProperty("status")
	private String status; 

	@JsonProperty("rejection_reason")
	private String rejectionReason; 

	@JsonProperty("proof_document_url")
	private String proofDocumentUrl; 

	@JsonProperty("transporter_id")
	private String transporterId; 

	@JsonProperty("haz_cargo")
	private Boolean hazCargo; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 


}