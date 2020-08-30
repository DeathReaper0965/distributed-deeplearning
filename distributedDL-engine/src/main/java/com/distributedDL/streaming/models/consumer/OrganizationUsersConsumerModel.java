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
public class OrganizationUsersConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("name")
	private String name; 

	@JsonProperty("email")
	private String email; 

	@JsonProperty("mobile_number")
	private String mobileNumber; 

	@JsonProperty("mobile_country_code")
	private String mobileCountryCode; 

	@JsonProperty("mobile_verified")
	private Boolean mobileVerified; 

	@JsonProperty("preferred_language")
	private String preferredLanguage; 

	@JsonProperty("preferred_currency")
	private String preferredCurrency; 

	@JsonProperty("birth_day")
	private String birthDay; 

	@JsonProperty("birth_month")
	private String birthMonth; 

	@JsonProperty("birth_year")
	private String birthYear; 

	@JsonProperty("alert_preferences")
	public static Jdbc4Array alertPreferences; 

	@JsonProperty("password_digest")
	private String passwordDigest; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 


}