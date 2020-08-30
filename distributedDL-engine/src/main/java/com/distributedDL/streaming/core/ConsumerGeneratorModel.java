package com.distributedDL.streaming.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ConsumerGeneratorModel {

	private String packageName = null;
	private String className = null;
    private String parentClassName = null;
    
    List<Map<String, String>> fields = new ArrayList<Map<String, String>>();
    
    public void addField(Map<String, String> field) {
    	this.getFields().add(field);
    }
    
}
