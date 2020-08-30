package com.distributedDL.streaming.job;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.distributedDLStreamingJob;
import com.distributedDL.streaming.deserializer.AppDeserializer;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;
import com.distributedDL.streaming.serializer.AppSerializer;

@SuppressWarnings({ "unchecked" })
public abstract class AppStreamingJob extends distributedDLStreamingJob {

	private String schema_name = "public";
	
	public AppStreamingJob() {
		super();
		try {
			Properties properties = CommonUtils.loadProperties();
			
			template.setConsumerHostName(properties.getProperty("kafka.consumer.host"));
			template.setConsumerPort(properties.getProperty("kafka.consumer.port"));
			template.setProducerHostName(properties.getProperty("kafka.producer.host"));
			template.setProducerPort(properties.getProperty("kafka.producer.port"));
			template.setZookeeperHostName(properties.getProperty("zookeeper.host"));
			template.setZookeeperPort(properties.getProperty("zookeeper.port"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		template.setSchemaName(this.schema_name);

		this.setDeserializationSchema(new AppDeserializer());
		this.setSerializationSchema(new AppSerializer());
	}

	@Override
	public SourceFunction<ChangeDataConsumerModel> addExtractor() {
		
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", template.getConsumerHostAddress());
		props.setProperty("group.id", template.getConsumerGroup());
		props.setProperty("zookeeper.connect", template.getZookeeperAddress());
		
		System.out.println("Adding Extractor...");
		FlinkKafkaConsumer011<ChangeDataConsumerModel> consumer = new FlinkKafkaConsumer011<ChangeDataConsumerModel>(
				template.getInTopic(),
				this.getDeserializationSchema(), 
				props
		);
		
		return consumer;
	}

	@Override
	public SinkFunction<LinkedHashMap<String, Object>> addLoader() {
		
		System.out.println("Adding Loader...");
		FlinkKafkaProducer011<LinkedHashMap<String, Object>> producer = new FlinkKafkaProducer011<LinkedHashMap<String, Object>>(
				template.getProducerHostAddress(),
				template.getOutTopic(),
				this.getSerializationSchema()
		);
		
		return producer;
	}

}
