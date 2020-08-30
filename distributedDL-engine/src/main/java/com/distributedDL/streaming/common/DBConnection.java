package com.distributedDL.streaming.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lombok.Data;

@Data
public class DBConnection {
	
	private String dbUrl = null;
	
	private String dbUsername = null;
	
	private String dbPassword = null;
	
	public DBConnection() {}
	
	public DBConnection(String dbUrl, String dbUsername, String dbPassword){
		this.setDbUrl(dbUrl);
		this.setDbUsername(dbUsername);
		this.setDbPassword(dbPassword);
	}
	
	public Connection getConnection() {
		
		try {
			Connection conn = DriverManager.getConnection(
		        this.getDbUrl(), this.getDbUsername(), this.getDbPassword());
		
		    if (conn == null) {
		        System.out.println("Failed to make connection!");
		        return null;
		    }
		
			return conn;
		
		} catch (SQLException e) {
		    System.err.format("Postgres State: %s\n%s", e.getSQLState(), e.getMessage());
		    
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
			
			return null;
	}
	
	public Connection getMongoDumpDBConnection() {
		
		try {
			Properties properties = CommonUtils.loadProperties();
			
			String pricingPassword = properties.getProperty("postgres.pricing-testingdb.db.password");
			String mongoDumpUrl = properties.getProperty("postgres.pricing-testingdb.db.url.tempmongo");
			String pricingUsername = properties.getProperty("postgres.pricing-testingdb.db.username");
			
			Connection conn = DriverManager.getConnection(
					mongoDumpUrl, pricingUsername, pricingPassword);
		
		    if (conn == null) {
		        System.out.println("Failed to make connection!");
		        return null;
		    }
		
			return conn;
		
		} catch (SQLException | IOException e) {
		    System.err.format("Postgres State: %s", e.getMessage());

		} catch (Exception e) {
	        e.printStackTrace();
	    }
			
		return null;
	}
}
