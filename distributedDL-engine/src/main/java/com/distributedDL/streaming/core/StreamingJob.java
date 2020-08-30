package com.distributedDL.streaming.core;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import lombok.Data;

@Data
@SuppressWarnings("rawtypes")
public abstract class StreamingJob {
	
	public DataStream stream = null;
	
	public SourceFunction sourceFunction = null;
	
	public SinkFunction sinkFunction = null;
	
	public Template template = null;

	public abstract SourceFunction addExtractor();

	public abstract DataStream addTransformer(DataStream stream);

	public abstract SinkFunction addLoader();
	
	public Boolean isMultiStream = false;
	
	public final ObjectMapper mapper = new ObjectMapper();
	
	public StreamExecutionEnvironment environment;
	
	@SuppressWarnings("unchecked")
	public StreamExecutionEnvironment initiate(StreamExecutionEnvironment environment) {
		
		if (!this.getIsMultiStream()) {
			this.setSourceFunction(this.addExtractor());
			this.setStream(environment.addSource(this.getSourceFunction()));
			this.setStream(this.addTransformer(this.getStream()));
		}else {
			System.out.println("Multi-Streaming found! Not adding Extractor!");
//			environment = this.getEnvironment();
			this.setStream(this.addTransformer(stream));
		}
		
		
		this.setSinkFunction(this.addLoader());
		this.getStream().addSink(this.getSinkFunction());
		
		return environment;
	}

}
