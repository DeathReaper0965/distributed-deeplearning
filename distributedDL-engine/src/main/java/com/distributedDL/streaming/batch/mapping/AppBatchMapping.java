package com.distributedDL.streaming.batch.mapping;

import java.io.Serializable;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.types.Row;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.distributedDL.streaming.cachedb.RocksDbCache;

import lombok.Data;

@Data
@SuppressWarnings({ "serial", "unchecked", "rawtypes"})
public abstract class AppBatchMapping implements MapFunction<Row, Boolean>, Serializable{
	
	protected static RocksDbCache rocksDbCache;
	
	protected String producerTopic;
	
	protected static KafkaProducer kafkaProducer;
	
	public AppBatchMapping(RocksDbCache cache) {
		
		if (cache != null){
			rocksDbCache = cache;
		}
		
	}

	@Override
	public abstract Boolean map(Row value) throws Exception;
	
	public <T> Boolean sendToKafka(T value) {
		ProducerRecord<String, T> record = new ProducerRecord<String, T>(this.producerTopic, value);
		
		return kafkaProducer.send(record, new Callback() {
			
					@Override
					public void onCompletion(RecordMetadata metadata, Exception exception) {
						if (exception != null) {
							exception.printStackTrace();
						}else {
							System.out.println("The offset of record is: " + metadata.offset());
						}
					}
				}).isCancelled();
	}
	
}
