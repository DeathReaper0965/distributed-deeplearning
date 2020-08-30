package com.distributedDL.streaming.models.producer;

import java.util.Date;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import com.distributedDL.streaming.core.ProducerModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings({ "serial", "rawtypes" })
@Data
@EqualsAndHashCode(callSuper = true)
public class AppProducerModel extends ProducerModel {
	
	@JsonProperty("created_at")
	public Date createdAt;
	
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writerWithDefaultPrettyPrinter()
									 .writeValueAsString(this);
		} catch (org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
