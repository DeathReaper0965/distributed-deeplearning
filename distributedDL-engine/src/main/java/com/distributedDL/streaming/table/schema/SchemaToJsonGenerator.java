package com.distributedDL.streaming.table.schema;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.BaseGenerator;
import com.distributedDL.streaming.core.ConsumerGeneratorModel;
import freemarker.template.Template;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SchemaToJsonGenerator extends BaseGenerator<ConsumerGeneratorModel> {
	
	private List<HashMap<String, String>> dictList = new ArrayList<>();
	private String classPrefix;

	public SchemaToJsonGenerator() throws IOException {
		super(new ConsumerGeneratorModel());
	}
	
	public void setValues(String classPrefix, List<HashMap<String, String>> dictList) {
		this.setDictList(dictList);
		this.setClassPrefix(StringUtils.capitalize(classPrefix));
	}

	@Override
	public void generate() throws Exception {
		Map root = new HashMap();
		
		this.getGeneratorModel().setPackageName(CommonConstants.CONSUMER_PACKAGE_NAME);
		this.getGeneratorModel().setClassName(this.getClassPrefix() + "ConsumerModel");
		this.getGeneratorModel().setParentClassName("AppConsumerModel");
		
		this.setGeneratePath(CommonUtils.getConsumerJsonConfigDir() + StringUtils.capitalize(this.getGeneratorModel().getClassName().replace("Model", "Config")) + ".json");
		
		if (this.getGeneratorModel().getFields().size() != 0) {
			this.getGeneratorModel().getFields().clear();
		}
		
		for(HashMap<String, String> dictMap: this.getDictList()) {
			HashMap<String, String> field = new HashMap<String, String>();
			
			field.put("name", dictMap.get("column_name"));
			
			String dataType = this.getDataType(dictMap.get("data_type").toLowerCase());
			field.put("type", dataType);
			
			this.getGeneratorModel().addField(field);
		}
		
		root.put("tsGeneratorModel", this.getGeneratorModel());
		
		Template template = cfg.getTemplate("TableSchemaGeneratorModel.ftl");
		
		Writer out = new OutputStreamWriter(new FileOutputStream(this.getGeneratePath()));
		template.process(root, out);
		out.close();
		
		System.out.println("Consumer Model Configuration Json Generated: " + this.getGeneratePath());
		
	}

	private String getDataType(String dataType) {
		if (dataType.contains("uuid") || dataType.contains("char")) {
			return "String";
		}
		else if(dataType.contains("arr")) {
			return "Jdbc4Array";
		}
		else if(dataType.contains("int")) {
			return "Integer";
		}
		else if(dataType.contains("numer") || dataType.contains("doub")) {
			return "Double";
		}
		else if(dataType.contains("bool")) {
			return "Boolean";
		}
		else if (dataType.contains("time")) {
			return "Date";
		}
		else if (dataType.contains("json") || dataType.contains("user")) {
			return "Object";
		}
		
		return "Object";
	}

}
