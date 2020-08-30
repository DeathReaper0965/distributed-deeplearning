package com.distributedDL.streaming.table.schema;

import lombok.Data;

@Data
public class TableSchema {
	
	private String schemaName;
	private String tableName;
	
	public TableSchema(String schemaName, String tableName){
		this.setSchemaName(schemaName);
		this.setTableName(tableName);
	}
	
}
