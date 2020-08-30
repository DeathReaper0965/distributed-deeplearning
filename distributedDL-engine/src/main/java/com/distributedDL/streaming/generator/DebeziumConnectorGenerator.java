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
import com.distributedDL.streaming.core.DebeziumConnectorGeneratorModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import freemarker.template.Template;

@SuppressWarnings({"unchecked", "rawtypes" })
public class DebeziumConnectorGenerator extends BaseGenerator<DebeziumConnectorGeneratorModel>{

	public DebeziumConnectorGenerator() throws IOException {
		super(new DebeziumConnectorGeneratorModel());
	}

	@Override
	public void generate() throws Exception {
		
		for (File file : new File(CommonUtils.getDebeziumConnectorJsonDir()).listFiles()) {
			
			JsonObject debObj = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
			
			this.setGeneratePath(CommonUtils.getDebeziumConnectorsPath() + debObj.get("connectorName").getAsString() + ".json.example");
			
			Map root = new HashMap();
			
			this.getGeneratorModel().setConnectorName(debObj.get("connectorName").getAsString());
			this.getGeneratorModel().setTasksMax(debObj.get("tasksMax").getAsString());
			this.getGeneratorModel().setDbHost(debObj.get("dbHost").getAsString());
			this.getGeneratorModel().setDbPort(debObj.get("dbPort").getAsString());
			this.getGeneratorModel().setDbUsername(debObj.get("dbUsername").getAsString());
			this.getGeneratorModel().setDbPassword(debObj.get("dbPassword").getAsString());
			this.getGeneratorModel().setDbName(debObj.get("dbName").getAsString());
			this.getGeneratorModel().setDbServerName(debObj.get("dbServerName").getAsString());
			this.getGeneratorModel().setSlotName(debObj.get("slotName").getAsString());
			
			root.put("debezuimConModel", this.getGeneratorModel());
			
			Template template = cfg.getTemplate("DebeziumConnectorGeneratorModel.ftl");
			
			Writer out = new OutputStreamWriter(new FileOutputStream(this.getGeneratePath()));
			template.process(root, out);
			out.close();
			
			System.out.println("Debezium Connector Json Generated: " + this.getGeneratorModel().getConnectorName());
			
		}
	}

}
