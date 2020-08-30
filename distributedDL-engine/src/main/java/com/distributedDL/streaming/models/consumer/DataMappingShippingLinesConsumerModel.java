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
public class DataMappingShippingLinesConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("business_name")
	private String businessName; 

	@JsonProperty("short_name")
	private String shortName; 

	@JsonProperty("masked_name")
	private String maskedName; 

	@JsonProperty("line_code")
	private String lineCode; 

	@JsonProperty("logo_url")
	private String logoUrl; 

	@JsonProperty("web_url")
	private String webUrl; 

	@JsonProperty("status")
	private String status; 

	@JsonProperty("mongo_id")
	private String mongoId; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 


}