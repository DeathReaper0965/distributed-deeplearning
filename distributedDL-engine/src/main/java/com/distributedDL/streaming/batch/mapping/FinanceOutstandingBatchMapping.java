package com.distributedDL.streaming.batch.mapping;

import org.apache.flink.types.Row;
import org.apache.kafka.clients.producer.KafkaProducer;

import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.producer.FinanceOutstandingProducerModel;

@SuppressWarnings("serial")
public class FinanceOutstandingBatchMapping extends AppBatchMapping{
	
	public FinanceOutstandingBatchMapping(String topic) {
		super(null);
		this.producerTopic = topic;
		kafkaProducer = new KafkaProducer<String, FinanceOutstandingProducerModel>(CommonUtils.getKafkaProducerProperties(FinanceOutstandingProducerModel.class.getName()));
	}

	@Override
	public Boolean map(Row value) throws Exception {
		
		System.out.println(value);
		FinanceOutstandingProducerModel financeOutstandingProducerModel = new FinanceOutstandingProducerModel();
		
		financeOutstandingProducerModel.setBusinessName(CommonUtils.checkNull(value.getField(0)));
		financeOutstandingProducerModel.setDueDate(CommonUtils.checkNullDate(value.getField(1)));
		financeOutstandingProducerModel.setInrTotalDueAmount(CommonUtils.checkNullAndDouble(value.getField(2)));
		financeOutstandingProducerModel.setInvoiceType(CommonUtils.checkNull(value.getField(3)));
		financeOutstandingProducerModel.setStatus(CommonUtils.checkNull(value.getField(4)));
		
		financeOutstandingProducerModel.setCreatedAt(CommonUtils.checkNullDate(value.getField(5)));
		
		return this.sendToKafka(financeOutstandingProducerModel);
	}

}
