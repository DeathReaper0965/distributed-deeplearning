package com.distributedDL.streaming.models.consumer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@JsonDeserialize
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationsUsersConsumerModel extends AppConsumerModel{
	@JsonProperty("_id")
	public String id;
	@JsonProperty("created_at")
	public String createdAt;
	@JsonProperty("email")
	public String email;
	@JsonProperty("escalation_designation")
	public String escalationDesignation;
	@JsonProperty("inc_id")
	public Integer incId;
	@JsonProperty("is_lead")
	public Boolean isLead;
	@JsonProperty("name")
	public String name;
	@JsonProperty("organization_id")
	public String organizationId;
	@JsonProperty("phone_no")
	public String phoneNo;
	@JsonProperty("preferred_currency")
	public String preferredCurrency;
	@JsonProperty("status")
	public String status;
	@JsonProperty("type")
	public String type;
	@JsonProperty("updated_at")
	public String updatedAt;
}
