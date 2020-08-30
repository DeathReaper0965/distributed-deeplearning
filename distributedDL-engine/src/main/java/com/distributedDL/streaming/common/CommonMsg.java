package com.distributedDL.streaming.common;

import javax.annotation.Nullable;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
@Nullable
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonMsg {
	public String activityTime;
	public String callOutput;
	public String callReason;
	public String alCreatedAt;
	public String description;
	public int incId;
	public String contactId;
	public String ownerId;
	public String callLogBucketId;
	public String callLogTagId;
	public String alType;
	public String adminId;
	public String adminName;
	public String alBucketid;
	public String alBucketName;
	public String alTagId;
	public String alTagName;
	public String orgBusinessName;
	public String orgId;
	public String orgUserId;
	public String orgUserName;
	public String orgUserEmail;
	public String orgUserPhoneNo;
	public String orgUserOrganizationId;
	public String createdAt;
}
