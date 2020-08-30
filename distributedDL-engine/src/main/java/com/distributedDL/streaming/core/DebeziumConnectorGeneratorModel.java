package com.distributedDL.streaming.core;

import lombok.Data;

@Data
public class DebeziumConnectorGeneratorModel {
	
	private String connectorName = null;
	private String tasksMax = null;
	private String dbHost = null;
	private String dbPort = null;
	private String dbUsername = null;
	private String dbPassword = null;
	private String dbName = null;
	private String dbServerName = null;
	private String slotName = null;
	
}
