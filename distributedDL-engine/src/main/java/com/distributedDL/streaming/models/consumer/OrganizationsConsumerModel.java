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
public class OrganizationsConsumerModel extends AppConsumerModel{
	@JsonProperty("_id")
	public String id;
	@JsonProperty("account_type")
	public Object accountType;
	@JsonProperty("adress")
	public String adress;
	@JsonProperty("branch_city")
	public String branchCity;
	@JsonProperty("business_name")
	public String businessName;
	@JsonProperty("converted_at")
	public Object convertedAt;
	@JsonProperty("created_at")
	public String createdAt;
	@JsonProperty("gst")
	public Object gst;
	@JsonProperty("iec")
	public Object iec;
	@JsonProperty("inc_id")
	public Integer incId;
	@JsonProperty("is_fieo_member")
	public Boolean isFieoMember;
	@JsonProperty("is_lead")
	public Boolean isLead;
	@JsonProperty("is_shipping_line")
	public Boolean isShippingLine;
	@JsonProperty("is_ssp")
	public Boolean isSsp;
	@JsonProperty("last_search_date")
	public Object lastSearchDate;
	@JsonProperty("operations_owner_id")
	public String operationsOwnerId;
	@JsonProperty("owner_id")
	public String ownerId;
	@JsonProperty("registration_type")
	public String registrationType;
	@JsonProperty("short_name")
	public String shortName;
	@JsonProperty("signup_city")
	public Object signupCity;
	@JsonProperty("status")
	public String status;
	@JsonProperty("tier")
	public Double tier;
	@JsonProperty("total_searches_count")
	public Double totalSearchesCount;
	@JsonProperty("type")
	public String type;
	@JsonProperty("updated_at")
	public String updatedAt;
}
