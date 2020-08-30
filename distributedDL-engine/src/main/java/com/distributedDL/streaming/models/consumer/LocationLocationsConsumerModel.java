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
public class LocationLocationsConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("mongo_id")
	private String mongoId; 

	@JsonProperty("name")
	private String name; 

	@JsonProperty("display_name")
	private String displayName; 

	@JsonProperty("type")
	private String type; 

	@JsonProperty("status")
	private String status; 

	@JsonProperty("continent_id")
	private String continentId; 

	@JsonProperty("trade_id")
	private String tradeId; 

	@JsonProperty("country_id")
	private String countryId; 

	@JsonProperty("region_id")
	private String regionId; 

	@JsonProperty("city_id")
	private String cityId; 

	@JsonProperty("cluster_id")
	private String clusterId; 

	@JsonProperty("port_id")
	private String portId; 

	@JsonProperty("pincode_id")
	private String pincodeId; 

	@JsonProperty("latitude")
	private String latitude; 

	@JsonProperty("longitude")
	private String longitude; 

	@JsonProperty("loc")
	private Object loc; 

	@JsonProperty("postal_code")
	private String postalCode; 

	@JsonProperty("is_icd")
	private Boolean isIcd; 

	@JsonProperty("is_airport")
	private Boolean isAirport; 

	@JsonProperty("port_code")
	private String portCode; 

	@JsonProperty("inttra_code")
	private String inttraCode; 

	@JsonProperty("icd_ports")
	public static Jdbc4Array icdPorts; 

	@JsonProperty("currency_code")
	private String currencyCode; 

	@JsonProperty("country_code")
	private String countryCode; 

	@JsonProperty("mobile_country_code")
	private String mobileCountryCode; 

	@JsonProperty("flag_icon_url")
	private String flagIconUrl; 

	@JsonProperty("flag_image_url")
	private String flagImageUrl; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 


}