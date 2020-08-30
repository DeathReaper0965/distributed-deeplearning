package com.distributedDL.streaming.mapping;

import java.sql.Connection;
import java.util.HashMap;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.common.DBConnection;
import com.distributedDL.streaming.models.consumer.ShipmentOrdersConsumerModel;
import com.distributedDL.streaming.models.producer.ShipmentOrderProducerModel;

@SuppressWarnings("serial")
public class ShipmentMapping extends AppMapping<ShipmentOrdersConsumerModel, ShipmentOrderProducerModel> {

	@Override
	public ShipmentOrderProducerModel mapping(ShipmentOrdersConsumerModel consumer,
			ShipmentOrderProducerModel producer) {
		System.out.print(consumer);
		
		producer.setShipmentId(consumer.getId());
		producer.setShipmentUid(consumer.getIncId());
		producer.setShipmentValue(consumer.getShipmentValue());
		producer.setActualSailingDate(consumer.getActualTimeOfDeparture());
		producer.setBlCount(consumer.getBlCount());
		producer.setExactCommodity((String) consumer.getCommodity());
		producer.setContainerSize(consumer.getContainerSize());
		producer.setContainerType(consumer.getContainerType());
		producer.setShipmentCreationDate(consumer.getCreatedAt().toString());
		producer.setDetentionDaysAtDestination(consumer.getDetentionDayDestination());
		producer.setDetentionDaysAtOrigin(consumer.getDetentionDayOrigin());
		producer.setEstimatedSailingDate(consumer.getExpectedShipmentDate().toString());
		producer.setQuantity(consumer.getQuantity());
		producer.setSource(consumer.getSource());
		producer.setStatus(consumer.getStatus());
		
		DBConnection dbConnection = new DBConnection();
		Connection conn = dbConnection.getMongoDumpDBConnection();
		
		if(conn == null){
			return null;
		}
		
		HashMap<String, String> engagementOwner = CommonUtils.getAdminFromAl(consumer.getEngagementOwnerId(), conn, "_id");
		
		if(engagementOwner == null)
			System.out.println("Enagagement Owner Not found..");
		
		HashMap<String, String> operationsOwner = CommonUtils.getAdminFromAl(consumer.getOperationsOwnerId(), conn, "_id");

		if(operationsOwner == null)
			System.out.println("Operations Owner Not found..");
		
		HashMap<String, String> shippingLine = CommonUtils.getOrgFromOrgUser(consumer.getShippingLineId(), conn, "_id");
		
		if(shippingLine == null)
			System.out.println("Shipping Line Not found..");
		
		HashMap<String, String> freightForwarder = CommonUtils.getOrgFromOrgUser(consumer.getFreightForwarderId(), conn, "_id");
		
		if(freightForwarder == null)
			System.out.println("Freight Forwarder Not found..");
		
		HashMap<String, String> originPort = CommonUtils.getLocFromPortId(consumer.getOriginPortId(), conn, "_id");
		
		if(originPort == null)
			System.out.println("Origin Port Not found..");
		
		HashMap<String, String> originMainPort = CommonUtils.getLocFromPortId(consumer.getOriginMainPortId(), conn, "_id");
		
		if(originMainPort == null)
			System.out.println("Origin Main Port Not found..");
		
		HashMap<String, String> destinationPort = CommonUtils.getLocFromPortId(consumer.getDestinationPortId(), conn, "_id");
		
		if(destinationPort == null)
			System.out.println("Destination Port Not found..");
		
		HashMap<String, String> destinationMainPort = CommonUtils.getLocFromPortId(consumer.getDestinationMainPortId(), conn, "_id");
		
		if(destinationMainPort == null)
			System.out.println("Destination Main Port Not found..");
		
		producer.setEngagementOwner(engagementOwner.get("name"));
		producer.setOperationsOwner(operationsOwner.get("name"));
		producer.setShippingLine(shippingLine.get("business_name"));
		producer.setEngagementOwner(freightForwarder.get("business_name"));
		producer.setOriginPort(originPort.get("display_name"));
		producer.setOriginMainPort(originMainPort.get("display_name"));
		producer.setDestinationPort(destinationPort.get("display_name"));
		producer.setDestinationMainPort(destinationMainPort.get("display_name"));

		return producer;
	}
}
