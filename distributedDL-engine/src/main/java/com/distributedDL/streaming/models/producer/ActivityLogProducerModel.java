package com.distributedDL.streaming.models.producer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@JsonSerialize
@EqualsAndHashCode(callSuper = true)
public class ActivityLogProducerModel extends AppProducerModel{
	@JsonProperty("activity_log_time")
	String  activityLogTime;
	@JsonProperty("call_log_output")
	String callLogOutput;
	@JsonProperty("call_log_reason")
	String callLogReason;
	@JsonProperty("activity_log_created_at")
	String activityLogCreatedAt;
	@JsonProperty("activity_log_description")
	String activityLogDescription;
	@JsonProperty("activity_log_inc_id")
	int activityLogIncId;
	@JsonProperty("organisation_user_name")
	String organisationUserName;
	@JsonProperty("organisation_user_email")
	String organisationUserEmail;
	@JsonProperty("organisation_user_phone_no")
	String organisationUserPhoneNo;
	@JsonProperty("organisation_business_name")
	String organisationBusinessName;
	@JsonProperty("bucket_name")
	String bucketName;
	@JsonProperty("tag_name")
	String tagName;
	@JsonProperty("admin_name")
	String adminName;
}
