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
public class FclRateFreightChargesConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("file_id")
	private String fileId; 

	@JsonProperty("origin_port_id")
	private String originPortId; 

	@JsonProperty("origin_main_port_id")
	private String originMainPortId; 

	@JsonProperty("destination_port_id")
	private String destinationPortId; 

	@JsonProperty("destination_main_port_id")
	private String destinationMainPortId; 

	@JsonProperty("shipping_line_id")
	private String shippingLineId; 

	@JsonProperty("supplier_id")
	private String supplierId; 

	@JsonProperty("added_by_id")
	private String addedById; 

	@JsonProperty("container_size")
	private String containerSize; 

	@JsonProperty("container_type")
	private String containerType; 

	@JsonProperty("commodity_type")
	private String commodityType; 

	@JsonProperty("total_price")
	private Double totalPrice; 

	@JsonProperty("currency")
	private String currency; 

	@JsonProperty("start_date")
	private Object startDate; 

	@JsonProperty("end_date")
	private Object endDate; 

	@JsonProperty("is_gri")
	private Boolean isGri; 

	@JsonProperty("gri_remarks")
	private Object griRemarks; 

	@JsonProperty("sheet_type")
	private String sheetType; 

	@JsonProperty("source")
	private String source; 

	@JsonProperty("is_deleted")
	private Boolean isDeleted; 

	@JsonProperty("deleted_by_source")
	private String deletedBySource; 

	@JsonProperty("deleted_by_id")
	private String deletedById; 

	@JsonProperty("deleted_at")
	private Date deletedAt; 

	@JsonProperty("payment_term")
	private String paymentTerm; 

	@JsonProperty("shipper_id")
	private String shipperId; 

	@JsonProperty("has_local_charges")
	private Boolean hasLocalCharges; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 


}