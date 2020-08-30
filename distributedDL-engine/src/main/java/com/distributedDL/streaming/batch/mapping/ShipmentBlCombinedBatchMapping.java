package com.distributedDL.streaming.batch.mapping;

import org.apache.flink.types.Row;
import org.apache.kafka.clients.producer.KafkaProducer;

import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.producer.ShipmentBlProducerModel;

@SuppressWarnings({ "serial" })
public class ShipmentBlCombinedBatchMapping extends AppBatchMapping{
	
	public ShipmentBlCombinedBatchMapping(String topic) {
		super(null);
		this.producerTopic = topic;
		kafkaProducer = new KafkaProducer<String, ShipmentBlProducerModel>(CommonUtils.getKafkaProducerProperties(ShipmentBlProducerModel.class.getName()));
	}

	@Override
	public Boolean map(Row value) throws Exception {
		ShipmentBlProducerModel shipmentBlProducerModel = new ShipmentBlProducerModel();
		
		shipmentBlProducerModel.setBlId(CommonUtils.checkNull(value.getField(0)));
		shipmentBlProducerModel.setShipmentId(CommonUtils.checkNull(value.getField(1)));
		shipmentBlProducerModel.setDraftBlAcceptanceStatus(CommonUtils.checkNull(value.getField(2)));
		shipmentBlProducerModel.setBlHoldReason(CommonUtils.checkNull(value.getField(3)));
		shipmentBlProducerModel.setBlReleaseDelayReason(CommonUtils.checkNull(value.getField(4)));
		shipmentBlProducerModel.setContainersCount(CommonUtils.checkNullAndInteger(value.getField(5)));
		shipmentBlProducerModel.setBlNumber(CommonUtils.checkNull(value.getField(6)));
		shipmentBlProducerModel.setBlType(CommonUtils.checkNull(value.getField(7)));
		shipmentBlProducerModel.setBlStatus(CommonUtils.checkNull(value.getField(8)));
		shipmentBlProducerModel.setBlDelayResponsibleParty(CommonUtils.checkNull(value.getField(9)));
		shipmentBlProducerModel.setBlDelayReason(CommonUtils.checkNull(value.getField(10)));
		shipmentBlProducerModel.setBlReleaseStatus(CommonUtils.checkNull(value.getField(11)));
		shipmentBlProducerModel.setBlCreatedAt(CommonUtils.checkNullDate(value.getField(12)));
		shipmentBlProducerModel.setDraftBlRejectionReason(CommonUtils.checkNull(value.getField(13)));
		shipmentBlProducerModel.setFileType(CommonUtils.checkNull(value.getField(14)));
		shipmentBlProducerModel.setFileName(CommonUtils.checkNull(value.getField(15)));
		shipmentBlProducerModel.setAmount(CommonUtils.checkNull(value.getField(16)));
		shipmentBlProducerModel.setShipmentCreatedAt(CommonUtils.checkNullDate(value.getField(17)));
		shipmentBlProducerModel.setShipmentUpdatedAt(CommonUtils.checkNullDate(value.getField(18)));
		shipmentBlProducerModel.setShipmentVerifiedAt(CommonUtils.checkNullDate(value.getField(19)));
		shipmentBlProducerModel.setShipmentDocumentDate(CommonUtils.checkNullDate(value.getField(20)));
		shipmentBlProducerModel.setShipmentAdminId(CommonUtils.checkNull(value.getField(21)));
		shipmentBlProducerModel.setOrganizationUserName(CommonUtils.checkNull(value.getField(22)));
		shipmentBlProducerModel.setOrganizationUserEmail(CommonUtils.checkNull(value.getField(23)));
		shipmentBlProducerModel.setOrganizationUserPhoneNo(CommonUtils.checkNull(value.getField(24)));
		shipmentBlProducerModel.setOrganizationBusinessName(CommonUtils.checkNull(value.getField(25)));
		shipmentBlProducerModel.setAdminName(CommonUtils.checkNull(value.getField(26)));
		
		shipmentBlProducerModel.setCreatedAt(CommonUtils.checkNullDate(value.getField(12)));
		
		return this.sendToKafka(shipmentBlProducerModel);
	}

}
