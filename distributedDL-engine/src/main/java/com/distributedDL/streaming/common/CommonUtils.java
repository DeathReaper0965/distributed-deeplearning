package com.distributedDL.streaming.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.flink.configuration.CheckpointingOptions;
import org.apache.flink.configuration.ConfigConstants;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.JobManagerOptions;
import org.apache.flink.configuration.RestOptions;
import org.apache.flink.configuration.TaskManagerOptions;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.postgresql.jdbc4.Jdbc4Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.distributedDL.streaming.core.distributedDLTemplate;

public class CommonUtils {
	
	private static Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
	
	public static HashMap<String, String> getOrgUserFromId(String id, Connection conn, String colName) {
		String orgUserStmt = "SELECT * from pg_organizations_users where " + colName + " = \'" + id + "\'";

		HashMap<String, String> dict = new HashMap<String, String>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(orgUserStmt);
			ResultSet resultSet = pStmt.executeQuery();
			
			while (resultSet.next()) {
				dict.put("_id", resultSet.getString("organization_id"));
				dict.put("name", resultSet.getString("name"));
				dict.put("email", resultSet.getString("email"));
				dict.put("phone_no", resultSet.getString("phone_no"));
			}
			
		} catch (SQLException e) {
			LOG.info("pg_organizations_users error");
			LOG.error("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
        } catch (Exception e) {
        	LOG.info("pg_organizations_users error");
            e.printStackTrace();
        }
		return dict;
	}
	
	public static HashMap<String, String> getOrgFromOrgUser(String organization_id, Connection conn, String colName) {
		String orgStmt = "SELECT * from pg_organizations where " + colName + " like \'" + organization_id + "\'";
		HashMap<String, String> dict = new HashMap<String, String>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(orgStmt);
			ResultSet resultSet = pStmt.executeQuery();
			
			while (resultSet.next()) {
				dict.put("business_name", resultSet.getString("business_name"));
				dict.put("iec", resultSet.getString("iec"));
				dict.put("gst", resultSet.getString("gst"));
				dict.put("converted_at", resultSet.getString("converted_at"));
				dict.put("account_type", resultSet.getString("account_type"));
				dict.put("inc_id", String.valueOf(resultSet.getLong("inc_id")));
				dict.put("is_shipping_line", String.valueOf(resultSet.getBoolean("is_shipping_line")));
				dict.put("registration_type", resultSet.getString("registration_type"));
				dict.put("signup_city", resultSet.getString("signup_city"));
				dict.put("is_ssp", String.valueOf(resultSet.getBoolean("is_ssp")));
				dict.put("type", resultSet.getString("type"));
				dict.put("owner_id", resultSet.getString("owner_id"));
			}
			
		} catch (SQLException e) {
			LOG.info("pg_organizations error");
			LOG.error("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
        } catch (Exception e) {
        	LOG.info("pg_organizations error");
            e.printStackTrace();
        }
		return dict;
	}
	
	public static HashMap<String, String> getAdminFromAl(String ownerId, Connection conn, String colName) {
		String adminStmt = "SELECT * from pg_admins where " + colName +" like \'" + ownerId + "\'";
		HashMap<String, String> dict = new HashMap<String, String>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(adminStmt);
			ResultSet resultSet = pStmt.executeQuery();
			
			while (resultSet.next()) {
				dict.put("admin_name", resultSet.getString("name"));
			}
			
		} catch (SQLException e) {
			LOG.info("pg_admins error");
			LOG.error("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
        } catch (Exception e) {
        	LOG.info("pg_admins error");
            e.printStackTrace();
        }
		return dict;
	}

	public static HashMap<String, String> getTagFromAl(String callLogTagId, Connection conn, String colName) {
		String tagStmt = "SELECT * from pg_acitivity_logs_tags where " + colName +" like \'" + callLogTagId + "\'";
		HashMap<String, String> dict = new HashMap<String, String>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(tagStmt);
			ResultSet resultSet = pStmt.executeQuery();
			
			while (resultSet.next()) {
				dict.put("tag_name", resultSet.getString("name"));
			}
			
		} catch (SQLException e) {
			LOG.info("pg_acitivity_logs_tags error");
			LOG.error("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
        } catch (Exception e) {
        	LOG.info("pg_acitivity_logs_tags error");
            e.printStackTrace();
        }
		return dict;
	}

	public static HashMap<String, String> getBucFromAl(String callLogBucketId, Connection conn, String colName) {
		String bucStmt = "SELECT * from pg_acitivity_logs_buckets where " + colName + " like \'" + callLogBucketId + "\'";
		HashMap<String, String> dict = new HashMap<String, String>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(bucStmt);
			
			ResultSet resultSet = pStmt.executeQuery();
			while (resultSet.next()) {
				dict.put("bucket_name", resultSet.getString("name"));
			}
			
		} catch (SQLException e) {
			LOG.info("pg_acitivity_logs_buckets error");
			LOG.error("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
        } catch (Exception e) {
        	LOG.info("pg_acitivity_logs_buckets error");
            e.printStackTrace();
        }
		return dict;
	}
	
	public static HashMap<String, String> getLocFromPortId(String port_id, Connection conn, String colName) {
		String orgStmt = "SELECT * from pg_locations where " + colName + " like \'" + port_id + "\'";
		HashMap<String, String> dict = new HashMap<String, String>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(orgStmt);
			ResultSet resultSet = pStmt.executeQuery();
			
			while (resultSet.next()) {
				dict.put("display_name", resultSet.getString("display_name"));
			}
			
		} catch (SQLException e) {
			LOG.info("pg_locations error");
			LOG.error("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
        } catch (Exception e) {
        	LOG.info("pg_locations error");
            e.printStackTrace();
        }
		
		return dict;
	}
	
	public static distributedDLTemplate setKafkaTopicProperties(distributedDLTemplate template, String db) {
		String debeziumServerName = null;
		String consumerGroup = null;
		
		switch(db) {
			case CommonConstants.SHIPMENT_DB:
				debeziumServerName = CommonConstants.SHIPMENT_DEBEZIUM_SERVER;
				consumerGroup = CommonConstants.SHIPMENT_CONSUMER_GROUP;
				break;
			case CommonConstants.MONGO_DUMP_DB:
				debeziumServerName = CommonConstants.MONGO_DUMP_DEBEZIUM_SERVER;
				consumerGroup = CommonConstants.MONGO_DUMP_CONSUMER_GROUP;
				break;
			case CommonConstants.FINANCE_DB:
				debeziumServerName = CommonConstants.FINANCE_DEBEZIUM_SERVER;
				consumerGroup = CommonConstants.FINANCE_CONSUMER_GROUP;
				break;
			case CommonConstants.distributedDL_API_DB:
				debeziumServerName = CommonConstants.distributedDL_API_DEBEZIUM_SERVER;
				consumerGroup = CommonConstants.distributedDL_API_CONSUMER_GROUP;
				break;
			case CommonConstants.LOCATION_DB:
				debeziumServerName = CommonConstants.LOCATION_DEBEZIUM_SERVER;
				consumerGroup = CommonConstants.LOCATION_CONSUMER_GROUP;
				break;
			case CommonConstants.COMBINED_STREAM:
				debeziumServerName = CommonConstants.COMBINED_STREAM_SERVER;
				consumerGroup = CommonConstants.COMBINED_STREAM_GROUP;
				break;
		}
		
		template.setDebeziumServerName(debeziumServerName);
		template.setConsumerGroup(consumerGroup);
		return template;
		
	}
	
	public static Date convertStringToDate(String date) {
		long longDate = Long.valueOf(date);
		return new Date(longDate);
	}
	
	public static Date convertUnixTimeStampToDate(Long ts_ms) {

		if (ts_ms == null) {
			return null;
		}

		return new Date(ts_ms);
	}
	
	public static String checkNull(Object obj) {
		if (obj != null)
			return obj.toString();
		return null;
	}
	
	public static Jdbc4Array checkNullJdbc4Array(Object obj){
		if (obj != null)
			return (Jdbc4Array) obj;
		return null;
	}
	
	public static Date checkNullDate(Object obj){
		if (obj != null)
			return (Date) obj;
		return null;
	}
	
	public static Double checkNullAndDouble(Object obj) {
		String doub = checkNull(obj);
		return doub == null ? null: Double.valueOf(doub);
	}
	
	public static Long checkNullAndLong(Object obj) {
		String lon = checkNull(obj);
		SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		try {
			return s1.parse(lon).getTime();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Integer checkNullAndInteger(Object obj) {
		String integer = checkNull(obj);
		return integer == null ? null: Integer.valueOf(integer);
	}

	public static String getBaseDir() {
		final String[] CURR_DIR = System.getProperty("user.dir").split("/");
		return String.join("/", CURR_DIR) + "/";
	}
	
	public static String getCacheDirectory() {
		try {
			Properties properties = loadProperties();
			return properties.getProperty("rocksdb.data.path");
		}catch(IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	}
	
	public static String getAbsoluteBaseDir() {
		String[] baseDirArray = getBaseDir().split("/");
		return String.join("/", Arrays.copyOf(baseDirArray, baseDirArray.length-1)) + "/";
	}
	
	public static String mainDirsEntryPoint() {
		return getBaseDir() + "src/main/java/com/distributedDL/streaming/";
	}
	
	public static String getConsumerJsonDir() {
		return getConsumerDir() + "json/config/";
	}
	
	public static String getDruidSupervisorJsonDir() {
		return mainDirsEntryPoint() + "models/druidsupervisor/json/config/";
	}
	
	public static String getDebeziumConnectorJsonDir() {
		return mainDirsEntryPoint() + "models/debeziumcon/json/config/";
	}
	
	public static String getResourceDir() {
		return getBaseDir() + "src/main/resources/application.properties";
	}
	
	public static String getConsumerDir() {
		return mainDirsEntryPoint() + "models/consumer/";
	}
	
	public static String getConsumerJsonConfigDir() {
		return getConsumerDir() + "json/config/";
	}
	
	public static String getProducerDir() {
		return mainDirsEntryPoint() + "models/producer/";
	}
	
	public static String getTemplatepath() {
		return mainDirsEntryPoint() + "generator/template";
	}
	
	public static String getDruidSupervisorsPath() {
		return getAbsoluteBaseDir() + "druid_supervisors/";
	}
	
	public static String getDebeziumConnectorsPath() {
		return getAbsoluteBaseDir() + "debezium_connectors/";
	}
	
	public static ObjectMapper getObjectMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}
	
	public static Date getDateFromString(String date) {
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		try {
			Date reqDate = formatter.parse(date);
			return reqDate;
		} catch (Exception e) {
			LOG.error("Not a valid Date");
			return null;
		}
	}
	
	public static Properties loadProperties() throws IOException {
		String resourceFilePath = CommonUtils.getResourceDir();
        Properties configuration = new Properties();
        InputStream inputStream = new FileInputStream(resourceFilePath);
        configuration.load(inputStream);
        inputStream.close();
        return configuration;
    }
	
	public static boolean existsFile(String path) {
        return (new File(path)).exists();
    }
	
	public static void removeDir(String path) throws IOException {
        LOG.info("Rmr path " + path);
        if (existsFile(path)) {
            FileUtils.forceDelete(new File(path));
        }
    }
	
	public static void makeLocalDir(String path) throws IOException {
        LOG.info("Making dir at" + path);
        FileUtils.forceMkdir(new File(path));
    }
	
	public static long getNormalDelayMsecs(Random rand, int maxDelayMsecs) {
		long delay = -1;
		long x = maxDelayMsecs / 2;
		while(delay < 0 || delay > maxDelayMsecs) {
			delay = (long)(rand.nextGaussian() * x) + x;
		}
		return delay;
	}
	
	public static long toServingTime(long servingStartTime, long dataStartTime, long eventTime, int servingSpeed) {
		long dataDiff = eventTime - dataStartTime;
		return servingStartTime + (dataDiff / servingSpeed);
	}
	
	public static Properties getKafkaProducerProperties(String valueSerializerName) {
		try {
			Properties properties = loadProperties();
			Properties kafkaProperties = new Properties();
			
			kafkaProperties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getProperty("kafka.producer.host") + ":" + properties.getProperty("kafka.producer.port"));
			kafkaProperties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
			kafkaProperties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializerName);
			
			kafkaProperties.setProperty(ProducerConfig.SEND_BUFFER_CONFIG, "131072");
			kafkaProperties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "131072");
			
			kafkaProperties.setProperty("auto.offset.reset", "earliest");
			kafkaProperties.setProperty("enable.auto.commit", "false");
			
			return kafkaProperties;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getDruidSupervisorUrl() {
		try {
			Properties properties = loadProperties();
			
			return properties.getProperty("druid.supervisor.host.name");
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static Configuration getExecutionConf() {
		Configuration conf = new Configuration();
		conf.setBoolean(ConfigConstants.LOCAL_START_WEBSERVER, true);
		conf.setString(RestOptions.BIND_PORT, "8081-8100");
		conf.setInteger(TaskManagerOptions.NUM_TASK_SLOTS, 10);
		conf.setString(JobManagerOptions.JOB_MANAGER_HEAP_MEMORY, "2048");
		conf.setBoolean(CheckpointingOptions.LOCAL_RECOVERY, true);
		
		return conf;
	}
	
}
