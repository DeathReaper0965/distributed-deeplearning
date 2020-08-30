package com.distributedDL.streaming.models.consumer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.postgresql.jdbc4.Jdbc4Array;
import org.postgresql.util.PGobject;
import java.util.Date;

@Data
@JsonDeserialize
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class FtlBasedLocationLocationsConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("inc_id")
	private Integer incId;

	@JsonProperty("parent_location_id")
	private String parentLocationId;

	@JsonProperty("parent_location_mongo_id")
	private String parentLocationMongoId;

	@JsonProperty("region_id")
	private String regionId;

	@JsonProperty("region_mongo_id")
	private String regionMongoId;

	@JsonProperty("cluster_id")
	private String clusterId;

	@JsonProperty("cluster_mongo_id")
	private String clusterMongoId;

	@JsonProperty("type")
	private String type;

	@JsonProperty("name")
	private String name;

	@JsonProperty("is_icd")
	private Boolean isIcd;

	@JsonProperty("is_airport")
	private Boolean isAirport;

	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("longitude")
	private String longitude;

	@JsonProperty("display_name")
	private String displayName;

	@JsonProperty("google_place_id")
	private String googlePlaceId;

	@JsonProperty("status")
	private String status;

	@JsonProperty("postal_code")
	private String postalCode;

	@JsonProperty("port_code")
	private String portCode;

	@JsonProperty("inttra_code")
	private String inttraCode;

	@JsonProperty("io_code")
	private String ioCode;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("icd_ports")
	private static Jdbc4Array icdPorts;

	@JsonProperty("icd_port_mongo_ids")
	private static Jdbc4Array icdPortMongoIds;

	@JsonProperty("aliases")
	private static Jdbc4Array aliases;

	@JsonProperty("search_names")
	private static Jdbc4Array searchNames;

	@JsonProperty("loc")
	private PGobject loc;

	@JsonProperty("bigschedule_id")
	private String bigscheduleId;

	@JsonProperty("city")
	private String city;

	@JsonProperty("country")
	private String country;

	@JsonProperty("flag_icon_url")
	private String flagIconUrl;

	@JsonProperty("flag_image_url")
	private String flagImageUrl;

	@JsonProperty("prepaid_charge_codes")
	private Jdbc4Array prepaidChargeCodes;

	@JsonProperty("bigschedule_hash")
	private Object bigscheduleHash;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

	@JsonProperty("mongo_id")
	private String mongoId;


}