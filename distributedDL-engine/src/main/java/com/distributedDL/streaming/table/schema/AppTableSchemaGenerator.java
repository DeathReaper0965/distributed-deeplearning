package com.distributedDL.streaming.table.schema;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.common.DBConnection;
import com.google.common.base.CaseFormat;

import lombok.Data;

@Data
public class AppTableSchemaGenerator {
	
	private static Logger LOG = LoggerFactory.getLogger(AppTableSchemaGenerator.class);
	
	private static String dbUrl = null;
	
	private static String dbUsername = null;
	
	private static String dbPassword = null;
	
	private List<TableSchema> jobs = new ArrayList<TableSchema>();

	private String query = 
					"select * " + 
					"from information_schema.columns " + 
					"where table_name like \'%s\' and " + 
					"table_schema like \'%s\'";

	public AppTableSchemaGenerator() {
		
		try {
			Properties properties = CommonUtils.loadProperties();
			dbUrl = properties.getProperty("postgres.staging.db.url.fdw");
			dbUsername = properties.getProperty("postgres.staging.db.username");
			dbPassword = properties.getProperty("postgres.staging.db.password");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public void addJob(TableSchema tableSchemaJob) {
		this.getJobs().add(tableSchemaJob);
	}
	
	public void executeJobs() {
		
		DBConnection dbConnection = new DBConnection(dbUrl, dbUsername, dbPassword);
		Connection conn = dbConnection.getConnection();
		
		for (TableSchema job: this.getJobs()) {
			List<HashMap<String, String>> dictList = new ArrayList<HashMap<String, String>>();
			
			try {
				PreparedStatement pStmt = conn.prepareStatement(String.format(query, job.getTableName(), job.getSchemaName()));
				ResultSet resultSet = pStmt.executeQuery();
				
				while(resultSet.next()) {
					HashMap<String, String> dict = new HashMap<String, String>();
					dict.put("column_name", resultSet.getString("column_name"));
					dict.put("data_type", resultSet.getString("data_type"));
					
					dictList.add(dict);
				}
				
			}catch (SQLException e) {
				LOG.info("Error in Generating Jsons");
				LOG.error("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
	        	LOG.info("Error in Generating Jsons");
	            e.printStackTrace();
	        }

			generateJson(dictList, job.getTableName());
			
		}
		
	}

	private void generateJson(List<HashMap<String, String>> dictList, String tableName) {
		String classPrefix = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName);
		
		try {
			SchemaToJsonGenerator generator = new SchemaToJsonGenerator();
			generator.setValues(classPrefix, dictList);
			generator.generate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
