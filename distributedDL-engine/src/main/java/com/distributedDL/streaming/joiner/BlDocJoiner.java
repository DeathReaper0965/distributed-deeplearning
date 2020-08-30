package com.distributedDL.streaming.joiner;

import java.util.HashMap;

import org.apache.flink.util.Collector;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.AdminsConsumerModel;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;
import com.distributedDL.streaming.models.consumer.OrganizationsConsumerModel;
import com.distributedDL.streaming.models.consumer.OrganizationsUsersConsumerModel;
import com.distributedDL.streaming.models.consumer.shipment.ShipmentBlDetailsConsumerModel;
import com.distributedDL.streaming.models.consumer.shipment.ShipmentDocumentsConsumerModel;
import com.distributedDL.streaming.models.producer.ShipmentBlProducerModel;

@SuppressWarnings({"serial"})
public class BlDocJoiner extends AppJoiner<ChangeDataConsumerModel, ChangeDataConsumerModel, ShipmentBlProducerModel>{

	public BlDocJoiner(HashMap<String, RocksDbCache> cacheMap) {
		super(cacheMap);
	}

	@Override
	public void flatMap1(ChangeDataConsumerModel xModel, Collector<ShipmentBlProducerModel> out) throws Exception {
		System.out.println("flatmap1");
		ChangeDataConsumerModel docStateValue = this.getYState().value();
		ShipmentBlProducerModel shipmentProducerValue = this.getZState().value();
		
		if (shipmentProducerValue == null) {
			shipmentProducerValue = new ShipmentBlProducerModel();
		}
		
		ShipmentBlDetailsConsumerModel blDetails = 
				(ShipmentBlDetailsConsumerModel) CommonUtils.getObjectMapper().convertValue(xModel.getAfter(), ShipmentBlDetailsConsumerModel.class);
				
		shipmentProducerValue.setBlId(blDetails.getId());
		shipmentProducerValue.setShipmentId(blDetails.getShipmentId());
		shipmentProducerValue.setDraftBlAcceptanceStatus(blDetails.getDraftBlAcceptanceStatus());
		shipmentProducerValue.setBlHoldReason(blDetails.getBlHoldReason());
		shipmentProducerValue.setBlReleaseDelayReason(blDetails.getBlReleaseDelayReason());
		shipmentProducerValue.setContainersCount(blDetails.getContainersCount());
		shipmentProducerValue.setBlNumber(blDetails.getBlNumber());
		shipmentProducerValue.setBlType(blDetails.getBlType());
		shipmentProducerValue.setBlStatus(blDetails.getBlStatus());
		shipmentProducerValue.setBlDelayResponsibleParty(blDetails.getBlDelayResponsibleParty());
		shipmentProducerValue.setBlDelayReason(blDetails.getBlDelayReason());
		shipmentProducerValue.setBlReleaseStatus(blDetails.getBlReleaseStatus());
		shipmentProducerValue.setBlCreatedAt(CommonUtils.getDateFromString(blDetails.getCreatedAt()));
		shipmentProducerValue.setDraftBlRejectionReason(blDetails.getDraftBlRejectionReason());
		
		shipmentProducerValue.setCreatedAt(CommonUtils.convertUnixTimeStampToDate(xModel.getTsMs()));
		
		if (docStateValue != null) {
			this.cleanAllStates();
			out.collect(shipmentProducerValue);
		}
		else {
			this.getXState().update(xModel);
			this.getZState().update(shipmentProducerValue);
		}
	}

	@Override
	public void flatMap2(ChangeDataConsumerModel yModel, Collector<ShipmentBlProducerModel> out) throws Exception {
		ChangeDataConsumerModel blStateValue = this.getXState().value();
		ShipmentBlProducerModel shipmentProducerValue = this.getZState().value();
		
		if (shipmentProducerValue == null) {
			shipmentProducerValue = new ShipmentBlProducerModel();
		}
		
		ShipmentDocumentsConsumerModel documents = 
				(ShipmentDocumentsConsumerModel) CommonUtils.getObjectMapper().convertValue(yModel.getAfter(), ShipmentDocumentsConsumerModel.class);
				
		shipmentProducerValue.setFileName(documents.getFileName());
		shipmentProducerValue.setFileType(documents.getFileType());
		shipmentProducerValue.setAmount(documents.getAmount());
		shipmentProducerValue.setShipmentCreatedAt(CommonUtils.getDateFromString(documents.getCreatedAt()));
		shipmentProducerValue.setShipmentUpdatedAt(CommonUtils.getDateFromString(documents.getUpdatedAt()));
		shipmentProducerValue.setShipmentVerifiedAt(CommonUtils.getDateFromString(documents.getVerifiedAt()));
		shipmentProducerValue.setShipmentDocumentDate(documents.getDocumentDate());
		shipmentProducerValue.setShipmentAdminId(documents.getAdminId());
		
		if (documents.getOrganizationUserId() != null) {
			OrganizationsUsersConsumerModel organizationsUsersConsumerModel = (OrganizationsUsersConsumerModel) cacheMap.get(CommonConstants.ORGANIZATIONS_USERS_CACHE).get(documents.getOrganizationUserId());
			
			if (organizationsUsersConsumerModel.getOrganizationId() != null) {
				
				OrganizationsConsumerModel organizationsConsumerModel = (OrganizationsConsumerModel) cacheMap.get(CommonConstants.ORGANIZATIONS_CACHE).get(organizationsUsersConsumerModel.getOrganizationId());
				shipmentProducerValue.setOrganizationBusinessName(organizationsConsumerModel.getBusinessName());
				
				if (organizationsConsumerModel.getOwnerId() != null) {
					AdminsConsumerModel adminsConsumerModel = (AdminsConsumerModel) cacheMap.get(CommonConstants.ADMINS_CACHE).get(organizationsConsumerModel.getOwnerId());
					shipmentProducerValue.setAdminName(adminsConsumerModel.getName());
				}
				
			}
			
			shipmentProducerValue.setOrganizationUserName(organizationsUsersConsumerModel.getName());
			shipmentProducerValue.setOrganizationUserEmail(organizationsUsersConsumerModel.getEmail());
			shipmentProducerValue.setOrganizationUserPhoneNo(organizationsUsersConsumerModel.getPhoneNo());
		}
		
		if (blStateValue != null) {
			this.cleanAllStates();
			out.collect(shipmentProducerValue);
			
		}else {
			this.getYState().update(yModel);
			this.getZState().update(shipmentProducerValue);
		}
	}
}
