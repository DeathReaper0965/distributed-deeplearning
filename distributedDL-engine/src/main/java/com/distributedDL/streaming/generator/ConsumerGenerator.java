package com.distributedDL.streaming.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.BaseGenerator;
import com.distributedDL.streaming.core.ConsumerGeneratorModel;
import com.google.common.base.CaseFormat;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import freemarker.template.Template;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ConsumerGenerator extends BaseGenerator<ConsumerGeneratorModel>{

	public ConsumerGenerator() throws IOException {
		super(new ConsumerGeneratorModel());
	}

	public void generate() throws Exception {
		/* ------------------------------------------------------------------------ */
		/* You usually do these for MULTIPLE TIMES in the application life-cycle: */

		/* Create a data-model */
		for (File file : new File(CommonUtils.getConsumerJsonDir()).listFiles()) {
			
			JsonObject consumerObject = JsonParser.parseReader(new JsonReader(new FileReader(file))).getAsJsonObject();
			
			Map root = new HashMap();
	
			this.getGeneratorModel().setPackageName(consumerObject.get("packageName").getAsString());
			this.getGeneratorModel().setClassName(consumerObject.get("className").getAsString());
			this.getGeneratorModel().setParentClassName(consumerObject.get("parentClassName").getAsString());
			
			if (this.getGeneratorModel().getPackageName().contains("producer")) {
				this.setGeneratePath(CommonUtils.getProducerDir() + this.getGeneratorModel().getClassName() + ".java");
			}else {
				this.setGeneratePath(CommonUtils.getConsumerDir() + this.getGeneratorModel().getClassName() + ".java");
			}
			
			JsonArray fieldsArray = consumerObject.get("fields").getAsJsonArray();
			
			if (this.getGeneratorModel().getFields().size() != 0) {
				this.getGeneratorModel().getFields().clear();
			}
			
			for(JsonElement fieldObj : fieldsArray) {
				HashMap<String, String> field = new HashMap<String, String>();
				
				JsonObject tmpObj = fieldObj.getAsJsonObject();
				
				field.put("field_name", tmpObj.get("field_name").getAsString());
				
				String fieldName = tmpObj.get("field_name").getAsString();
				long fieldNameUnderscoreCount = fieldName.chars().filter(num -> num == '_').count();
				long fieldNameNumCount = fieldName.chars().filter(Character::isDigit).count();
				
				if (fieldNameUnderscoreCount > 1 && fieldNameNumCount >1) {
					field.put("java_field_name", fieldName);
				}else {
					field.put("java_field_name", CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tmpObj.get("field_name").getAsString()));
				}
				
				
				field.put("field_type", tmpObj.get("field_type").getAsString());
				field.put("is_static", tmpObj.get("is_static") != null ? tmpObj.get("is_static").getAsString() : null);
				field.put("data_type", tmpObj.get("data_type") != null ? tmpObj.get("data_type").getAsString() : null);
				
				this.getGeneratorModel().addField(field);
			}
			
			root.put("consumerGeneratorModel", this.getGeneratorModel());
	
			/* Get the template (uses cache internally) */
			Template temp = cfg.getTemplate("ConsumerGeneratorModel.ftl");
	
			/* Merge data-model with template */
			Writer out = new OutputStreamWriter(new FileOutputStream(this.getGeneratePath()));
			temp.process(root, out);
			out.close();
			
			System.out.println("Consumer Model Generated: " + this.getGeneratorModel().getClassName());
		
		}

	}

}
