package com.distributedDL.streaming.core;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("rawtypes")
public abstract class distributedDLStreamingJob extends StreamingJob {

	public DeserializationSchema deserializationSchema = null;

	public SerializationSchema serializationSchema = null;

	public distributedDLTemplate template = null;
	
	public Streamer streamer;

	public distributedDLStreamingJob() {
		this.setTemplate(new distributedDLTemplate());
	}

}
