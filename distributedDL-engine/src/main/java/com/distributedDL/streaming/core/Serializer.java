package com.distributedDL.streaming.core;

import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class Serializer<T> implements SerializationSchema<T> {

	static ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

	public byte[] serialize(T element) {
		try {
			return objectMapper.writeValueAsBytes(element);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

}