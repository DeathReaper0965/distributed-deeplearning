package com.distributedDL.streaming.models.producer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
public class ShipmentOrderProducerModel extends AppProducerModel {
	
	@JsonProperty("shipment_uid")
	private Integer shipmentUid;
	@JsonProperty("shipment_id")
	private String shipmentId;
	@JsonProperty("shipment_value")
	private Double shipmentValue;
	@JsonProperty("actual_sailing_date")
	private Object actualSailingDate;
	@JsonProperty("bl_count")
	private Integer blCount;
	@JsonProperty("exact_commodity")
	private String exactCommodity;
	@JsonProperty("container_size")
	private String containerSize;
	@JsonProperty("container_type")
	private String containerType;
	@JsonProperty("shipment_creation_date")
	private String shipmentCreationDate;
	@JsonProperty("detention_days_at_destination")
	private Integer detentionDaysAtDestination;
	@JsonProperty("detention_days_at_origin")
	private Integer detentionDaysAtOrigin;
	@JsonProperty("estimated_sailing_date")
	private String estimatedSailingDate;
	@JsonProperty("hs_code")
	private Integer hsCode;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("source")
	private String source;
	@JsonProperty("status")
	private String status;
	@JsonProperty("origin_port")
	private String  originPort;
	@JsonProperty("origin_main_port")
	private String  originMainPort;
	@JsonProperty("destination_port")
	private String  destinationPort;
	@JsonProperty("destintion_main_port")
	private String  destinationMainPort;
	@JsonProperty("shipping_line")
	private String shippingLine;
	@JsonProperty("freight_forwarder")
	private String freightForwarder;
	@JsonProperty("enagagement_owner")
	private String  engagementOwner;
	@JsonProperty("operations_owner")
	private String operationsOwner;
	
}
