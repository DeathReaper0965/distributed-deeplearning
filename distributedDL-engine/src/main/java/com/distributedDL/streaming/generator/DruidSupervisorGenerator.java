package com.distributedDL.streaming.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.BaseGenerator;
import com.distributedDL.streaming.core.DruidSupervisorGeneratorModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import freemarker.template.Template;

@SuppressWarnings({"unchecked", "rawtypes" })
public class DruidSupervisorGenerator extends BaseGenerator<DruidSupervisorGeneratorModel>{

	public DruidSupervisorGenerator() throws IOException {
		super(new DruidSupervisorGeneratorModel());
	}

	@Override
	public void generate() throws Exception {
		
		for (File file : new File(CommonUtils.getDruidSupervisorJsonDir()).listFiles()) {
			
			JsonObject druidObj = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
			
			this.setGeneratePath(CommonUtils.getDruidSupervisorsPath() + druidObj.get("supervisor_name").getAsString() +".json");
			
			Map root = new HashMap();
			
			this.getGeneratorModel().setDataSource(druidObj.get("dataSource").getAsString());
			this.getGeneratorModel().setTopic(druidObj.get("topic").getAsString());
			this.getGeneratorModel().setReplicas(druidObj.get("replicas").getAsString());
			this.getGeneratorModel().setBootStrapServers(druidObj.get("bootStrapServers").getAsString());
			
			if (this.getGeneratorModel().getDimensions().size() != 0) {
				this.getGeneratorModel().getDimensions().clear();
			}
			
			if (this.getGeneratorModel().getMetrics().size() != 0) {
				this.getGeneratorModel().getMetrics().clear();
			}
			
			JsonArray dimensionsArray = druidObj.get("dimensions").getAsJsonArray();
			
			if (dimensionsArray != null && dimensionsArray.size() != 0) {
				
				for(JsonElement dimensionObj : dimensionsArray) {
					HashMap<String, String> dimensionMap = new HashMap<String, String>();
					
					JsonObject tmpObj = dimensionObj.getAsJsonObject();
					
					dimensionMap.put("name", tmpObj.get("name").getAsString());
					dimensionMap.put("type", tmpObj.get("type").getAsString());
					
					this.getGeneratorModel().addDimension(dimensionMap);
					
				}
				
			}
			
			JsonArray metricsArray = druidObj.get("metrics").getAsJsonArray();
			
			if(metricsArray != null && metricsArray.size() != 0) {
				
				for(JsonElement metricsObj : metricsArray) {
					HashMap<String, String> metricMap = new HashMap<String, String>();
					
					JsonObject tmpObj = metricsObj.getAsJsonObject();
					
					metricMap.put("name", tmpObj.get("name").getAsString());
					metricMap.put("fieldName", tmpObj.get("fieldName").getAsString());
					metricMap.put("type", tmpObj.get("type").getAsString());
					
					this.getGeneratorModel().addMetric(metricMap);
					
				}
				
			}
			
			root.put("druidSupervisorModel", this.getGeneratorModel());
			
			Template template = cfg.getTemplate("DruidSupervisorModel.ftl");
			
			Writer out = new OutputStreamWriter(new FileOutputStream(this.getGeneratePath()));
			template.process(root, out);
			out.close();
			
			System.out.println("Druid Supervisor Json Generated: " + this.getGeneratorModel().getDataSource());
			
		}
		
	}
	
	
}
