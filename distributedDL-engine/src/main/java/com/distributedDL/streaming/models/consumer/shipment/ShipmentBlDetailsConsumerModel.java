package com.distributedDL.streaming.models.consumer.shipment;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import com.distributedDL.streaming.models.consumer.AppConsumerModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentBlDetailsConsumerModel extends AppConsumerModel{
	
	@JsonProperty("id")
	public String id;
	@JsonProperty("shipment_id")
	public String shipmentId;
	@JsonProperty("digital_si_id")
	public Object digitalSiId;
	@JsonProperty("is_digital_si")
	public Boolean isDigitalSi;
	@JsonProperty("draft_bl_acceptance_status")
	public String draftBlAcceptanceStatus;
	@JsonProperty("draft_bl_rejection_reason")
	public String draftBlRejectionReason;
	@JsonProperty("bl_hold_reason")
	public String blHoldReason;
	@JsonProperty("bl_release_delay_reason")
	public String blReleaseDelayReason;
	@JsonProperty("containers_count")
	public Integer containersCount;
	@JsonProperty("consignee_address")
	public String consigneeAddress;
	@JsonProperty("bl_number")
	public String blNumber;
	@JsonProperty("bl_type")
	public String blType;
	@JsonProperty("bl_delivery_mode")
	public Object blDeliveryMode;
	@JsonProperty("bl_status")
	public String blStatus;
	@JsonProperty("bl_delay_responsible_party")
	public String blDelayResponsibleParty;
	@JsonProperty("bl_delay_reason")
	public String blDelayReason;
	@JsonProperty("bl_notification_sent")
	public Boolean blNotificationSent;
	@JsonProperty("bl_release_status")
	public String blReleaseStatus;
	@JsonProperty("mongo_id")
	public Object mongoId;
	@JsonProperty("created_at")
	public String createdAt;
	@JsonProperty("updated_at")
	public String updatedAt;
	
}
