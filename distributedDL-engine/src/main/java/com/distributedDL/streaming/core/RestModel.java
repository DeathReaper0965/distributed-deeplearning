package com.distributedDL.streaming.core;

import java.io.File;

import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONObject;

public interface RestModel {
	
	public JSONObject makeGetRequest(String url);
	
	public JSONObject makePostRequest(String url, File supervisorJson);
	
	public JSONObject makePostRequest(String url);
	
	public JSONObject executeRequest(HttpUriRequest httpRequest);
	
}
