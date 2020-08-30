package com.distributedDL.streaming.core;

import java.util.Map;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import com.distributedDL.streaming.common.CommonUtils;

@SuppressWarnings("serial")
public class ProducerModel<T> extends Model implements Serializer<T>{

	static ObjectMapper objectMapper = CommonUtils.getObjectMapper();
	
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		
	}

	@Override
	public byte[] serialize(String topic, T data) {
		try {
			return objectMapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void close() {
	}

}
