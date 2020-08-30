package com.distributedDL.streaming.apis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.AppRestImpl;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class DruidSupervisorSubmitter {
	
	private final static Logger LOG = LoggerFactory.getLogger(DruidSupervisorSubmitter.class);
	
	private static String dataSource = null;
	
	private static File supervisorFile = null;
	
	private static JSONObject statusReponse = null;
	
	private static JSONObject terminationResponse = null;
	
	private static JSONObject payload = null;
	
	private AppRestImpl appRestImpl = new AppRestImpl();
	
	public DruidSupervisorSubmitter(){
		
	}
	
	public String submitSupervisor(String supervisorFileName) {
		String supervisorFilePath = CommonUtils.getDruidSupervisorsPath() + supervisorFileName;
		
		if (!CommonUtils.existsFile(supervisorFilePath)) {
			LOG.error("Supervisor File Doesn't exist");
			return CommonConstants.FILE_MISSING;
		}
		
		supervisorFile = new File(supervisorFilePath);
		
		try {
			JsonObject druidObj = JsonParser.parseReader(new FileReader(supervisorFile)).getAsJsonObject();
			JsonObject dataSchema = druidObj.getAsJsonObject(CommonConstants.DATA_SCHEMA);
			dataSource = dataSchema.get(CommonConstants.DATA_SOURCE).getAsString();
			
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		statusReponse = this.getSupervisorStatus(dataSource);
		
		if (statusReponse == null) {
			LOG.info(String.format("Supervisor %s not found, submitting as new", dataSource));
			return this.submitFile(supervisorFile);
		}
		
		payload = statusReponse.getJSONObject("payload");
		
		LOG.info(String.format("Supervisor %s found with suspension status: %s \nnumber of active tasks: %s \nstate: %s", 
												dataSource, 
												payload.getBoolean(CommonConstants.SUSPENDED), 
												payload.getJSONArray(CommonConstants.ACTIVE_TASKS).length(), 
												payload.getString(CommonConstants.SUPERVISOR_STATE)));
		
		terminationResponse = this.terminateSupervisor(dataSource);
		
		if (terminationResponse == null) {
			LOG.error(String.format("Supervisor %s unable to terminate", dataSource));
			return CommonConstants.UNABLE_TO_TERMINATE;
		}
		
		LOG.info(String.format("Supervisor %s terminated successfully, submitting new one", dataSource));
		
		return this.submitFile(supervisorFile);
		
	}
	
	public JSONObject getSupervisorStatus(String supervisorId) {
		String statusUrl = CommonUtils.getDruidSupervisorUrl() + supervisorId + CommonConstants.STATUS_ENDPOINT;
		JSONObject getResp = appRestImpl.makeGetRequest(statusUrl);
		
		return getResp;
		
	}
	
	public JSONObject terminateSupervisor(String supervisorId) {
		String terminateUrl = CommonUtils.getDruidSupervisorUrl() + supervisorId + CommonConstants.SHUTDOWN_ENDPOINT;
		
		JSONObject postResp = appRestImpl.makePostRequest(terminateUrl);
		
		return postResp;
		
	}
	
	public String submitFile(File supervisorJson) {
		JSONObject postResp = appRestImpl.makePostRequest(CommonUtils.getDruidSupervisorUrl(), supervisorJson);
		
		if (postResp == null) {
			LOG.error(String.format("Supervisor %s unable to submit", dataSource));
			return CommonConstants.UNABLE_TO_SUBMIT;
		}
		
		LOG.info(String.format("Supervisor %s submitted successfully", dataSource));
		
		return CommonConstants.SUBMIT_SUCCESS;
	}
	
}
