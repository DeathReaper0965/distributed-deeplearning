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
public class OrganizationOrganizationsConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("serial_id")
	private Integer serialId; 

	@JsonProperty("business_name")
	private String businessName; 

	@JsonProperty("short_name")
	private String shortName; 

	@JsonProperty("about")
	private String about; 

	@JsonProperty("account_type")
	private String accountType; 

	@JsonProperty("website")
	private String website; 

	@JsonProperty("logo")
	private String logo; 

	@JsonProperty("status")
	private String status; 

	@JsonProperty("mongo_id")
	private String mongoId; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 


}