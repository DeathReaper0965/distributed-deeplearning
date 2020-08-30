package com.distributedDL.streaming.core;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class distributedDLTemplate extends Template {

	private String consumerHostName = null;

	private String consumerPort;

	private String producerHostName = null;

	private String producerPort = null;

	private String zookeeperHostName = null;

	private String zookeeperPort = null;

	private String debeziumServerName = null;

	private String schemaName = null;

	private String tableName = null;
	
	private String consumerGroup = null;
	
	public String getZookeeperAddress() {
		return this.getZookeeperHostName() + ":" + this.getZookeeperPort();
	}

	public String getConsumerHostAddress() {
		return this.getConsumerHostName() + ":" + this.getConsumerPort();
	}

	public String getProducerHostAddress() {
		return this.getProducerHostName() + ":" + this.getProducerPort();
	}

	public String getInTopic() {
		return this.getDebeziumServerName() + "." + this.getSchemaName() + "." + this.getTableName();
	}

	public String getOutTopic() {
		return getInTopic() + ".out";
	}

}
