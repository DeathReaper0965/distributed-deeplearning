package com.distributedDL.streaming.mapping;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;

import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.common.DBConnection;
import com.distributedDL.streaming.models.consumer.ActivityLogConsumerModel;
import com.distributedDL.streaming.models.producer.ActivityLogProducerModel;

@SuppressWarnings("serial")
public class ActivityLogMapping extends AppMapping<ActivityLogConsumerModel, ActivityLogProducerModel> {
	
	@Override
	public ActivityLogProducerModel mapping(ActivityLogConsumerModel activityLogConsumerModel, ActivityLogProducerModel activityLogProducerModel) {
		activityLogProducerModel.setActivityLogTime((new Date(Long.parseLong(activityLogConsumerModel.getActivityTime())).toString()));
		activityLogProducerModel.setCallLogOutput(activityLogConsumerModel.getCallOutput());
		activityLogProducerModel.setCallLogReason(activityLogConsumerModel.getCallReason());
		activityLogProducerModel.setActivityLogCreatedAt((new Date(Long.parseLong(activityLogConsumerModel.getCreatedAt())).toString()));
		activityLogProducerModel.setActivityLogDescription(activityLogConsumerModel.getDescription());
		activityLogProducerModel.setActivityLogIncId(activityLogConsumerModel.getIncId());
		
		DBConnection dbConnection = new DBConnection();
		Connection conn = dbConnection.getMongoDumpDBConnection();
		
		if(conn == null){
			return null;
		}
		
		HashMap<String, String> orgUserDict = CommonUtils.getOrgUserFromId(activityLogConsumerModel.getContactId(), conn, "_id");
		
		if(orgUserDict == null)
			return null;
		
		activityLogProducerModel.setOrganisationUserName(orgUserDict.get("name"));
		activityLogProducerModel.setOrganisationUserEmail(orgUserDict.get("email"));
		activityLogProducerModel.setOrganisationUserPhoneNo(orgUserDict.get("phone_no"));
		
		HashMap<String, String> orgDict = CommonUtils.getOrgFromOrgUser(orgUserDict.get("organization_id"), conn, "_id");
		
		if(orgDict == null)
			return null;
		
		activityLogProducerModel.setOrganisationBusinessName(orgDict.get("business_name"));
		
		HashMap<String, String> bucDict = CommonUtils.getBucFromAl(activityLogConsumerModel.getCallLogBucketId(), conn, "_id");
		
		if(bucDict == null)
			return null;
		
		activityLogProducerModel.setBucketName(bucDict.get("bucket_name"));
		
		HashMap<String, String> tagDict = CommonUtils.getTagFromAl(activityLogConsumerModel.getCallLogTagId(), conn, "_id");
		
		if(tagDict == null)
			return null;
		
		activityLogProducerModel.setTagName(tagDict.get("tag_name"));
		
		HashMap<String, String> adminDict = CommonUtils.getAdminFromAl(activityLogConsumerModel.getOwnerId(), conn, "_id");
		
		if(adminDict == null)
			return null;
		
		activityLogProducerModel.setAdminName(adminDict.get("admin_name"));
		
		return activityLogProducerModel;
	}
}
