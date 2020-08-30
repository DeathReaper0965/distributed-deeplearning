package com.distributedDL.streaming.core;

import java.io.IOException;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings({ "serial" })
public class Deserializer<T> implements DeserializationSchema<T> {

	static ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
	Class<T> classInstance = null;

	@Override
	public TypeInformation<T> getProducedType() {
		return TypeInformation.of(this.getClassInstance());
	}

	@Override
	public T deserialize(byte[] message) throws IOException {

		T objectNode = null;
		try {
			objectNode = objectMapper.readValue(message, this.getClassInstance());
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}

		return objectNode;
	}

	@Override
	public boolean isEndOfStream(T nextElement) {
		return false;
	}

}
