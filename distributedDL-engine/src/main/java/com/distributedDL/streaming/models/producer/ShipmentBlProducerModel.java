package com.distributedDL.streaming.models.producer;

import java.util.Date;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
public class ShipmentBlProducerModel extends AppProducerModel {
	@JsonProperty("bl_id")
	private String blId;
	
	@JsonProperty("shipment_id")
	private String shipmentId;
	
	@JsonProperty("draft_bl_acceptance_status")
	private String draftBlAcceptanceStatus;
	
	@JsonProperty("bl_hold_reason")
	private String blHoldReason;
	
	@JsonProperty("bl_release_delay_reason")
	private String blReleaseDelayReason;
	
	@JsonProperty("containers_count")
	private Integer containersCount;
	
	@JsonProperty("bl_number")
	private String blNumber;
	
	@JsonProperty("bl_type")
	private String blType;
	
	@JsonProperty("bl_status")
	private String blStatus;
	
	@JsonProperty("bl_delay_responsible_party")
	private String blDelayResponsibleParty;
	
	@JsonProperty("bl_delay_reason")
	private String blDelayReason;
	
	@JsonProperty("bl_release_status")
	private String blReleaseStatus;
	
	@JsonProperty("bl_created_at")
	private Date blCreatedAt;
	
	@JsonProperty("draft_bl_rejection_reason")
	private String draftBlRejectionReason;
	
	@JsonProperty("file_type")
	private String fileType;
	
	@JsonProperty("file_name")
	private String fileName;
	
	@JsonProperty("amount")
	private String amount;
	
	@JsonProperty("shipment_created_at")
	private Date shipmentCreatedAt;
	
	@JsonProperty("shipment_updated_at")
	private Date shipmentUpdatedAt;
	
	@JsonProperty("shipment_verified_at")
	private Date shipmentVerifiedAt;
	
	@JsonProperty("shipment_document_date")
	private Date shipmentDocumentDate;
	
	@JsonProperty("shipment_admin_id")
	private String shipmentAdminId;
	
	@JsonProperty("organization_user_name")
	private String organizationUserName;
	
	@JsonProperty("organization_user_email")
	private String organizationUserEmail;
	
	@JsonProperty("organization_user_phone_no")
	private String organizationUserPhoneNo;
	
	@JsonProperty("organization_business_name")
	private String organizationBusinessName;
	
	@JsonProperty("admin_name")
	private String adminName;
	
}
