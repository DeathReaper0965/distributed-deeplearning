package com.distributedDL.streaming.models.consumer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.postgresql.jdbc4.Jdbc4Array;
import java.util.Date;

@Data
@JsonDeserialize
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class OrganizationOrganizationUsersConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("organization_id")
	private String organizationId; 

	@JsonProperty("user_id")
	private String userId; 

	@JsonProperty("status")
	private String status; 

	@JsonProperty("designation")
	private String designation; 

	@JsonProperty("mongo_ids")
	public static Jdbc4Array mongoIds; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 


}