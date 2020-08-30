package com.distributedDL.streaming.models.consumer.shipment;

import java.util.Date;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import com.distributedDL.streaming.models.consumer.AppConsumerModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentDocumentsConsumerModel extends AppConsumerModel{
	
	@JsonProperty("id")
	public String id;
	@JsonProperty("entity_id")
	public String entityId;
	@JsonProperty("entity_type")
	public String entityType;
	@JsonProperty("organization_user_id")
	public String organizationUserId;
	@JsonProperty("admin_id")
	public String adminId;
	@JsonProperty("file_name")
	public String fileName;
	@JsonProperty("file_type")
	public String fileType;
	@JsonProperty("url")
	public String url;
	@JsonProperty("desc")
	public String desc;
	@JsonProperty("unique_number")
	public String uniqueNumber;
	@JsonProperty("verification_status")
	public String verificationStatus;
	@JsonProperty("amount")
	public String amount;
	@JsonProperty("document_date")
	public Date documentDate;
	@JsonProperty("uploaded_at")
	public String uploadedAt;
	@JsonProperty("rejected_at")
	public Object rejectedAt;
	@JsonProperty("verified_at")
	public String verifiedAt;
	@JsonProperty("created_at")
	public String createdAt;
	@JsonProperty("updated_at")
	public String updatedAt;
	@JsonProperty("mongo_entity_id")
	public Object mongoEntityId;
	@JsonProperty("mongo_id")
	public Object mongoId;
	
}
