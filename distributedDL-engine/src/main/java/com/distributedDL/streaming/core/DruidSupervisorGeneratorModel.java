package com.distributedDL.streaming.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class DruidSupervisorGeneratorModel {

	private String dataSource = null;
	private String topic = null;
	private String replicas = null;
	private String bootStrapServers = null;
	
	List<Map<String, String>> dimensions = new ArrayList<Map<String, String>>();
	List<Map<String, String>> metrics = new ArrayList<Map<String, String>>();
	
	public void addDimension(Map<String, String> dimension) {
		this.getDimensions().add(dimension);
	}
	
	public void addMetric(Map<String, String> metric) {
		this.getMetrics().add(metric);
	}
	
}
