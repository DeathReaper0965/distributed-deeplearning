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
public class OrganizationServiceProviderServiceProfilesConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("organization_id")
	private String organizationId; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 


}