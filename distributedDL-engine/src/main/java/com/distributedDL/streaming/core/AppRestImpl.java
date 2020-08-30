package com.distributedDL.streaming.core;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AppRestImpl implements RestModel{

	protected CloseableHttpClient httpClient = null;
	
	public AppRestImpl() {
		httpClient = HttpClientBuilder.create().build();
	}
	
	@Override
	public JSONObject makeGetRequest(String url) {
		HttpGet getReq = new HttpGet(url);
		
		return executeRequest(getReq);
	}

	@Override
	public JSONObject makePostRequest(String url, File supervisorJson) {
		HttpPost postReq = new HttpPost(url);
		
		postReq.setHeader("Content-type", "application/json");
		
		FileEntity fileEntity = new FileEntity(supervisorJson);
		
		postReq.setEntity(fileEntity);
		
		return executeRequest(postReq);
		
	}

	@Override
	public JSONObject makePostRequest(String url) {
		HttpPost postReq = new HttpPost(url);
		
		postReq.setHeader("Content-type", "application/json");
		
		return executeRequest(postReq);

	}

	@Override
	public JSONObject executeRequest(HttpUriRequest httpRequest) {
		try {
			HttpResponse response = httpClient.execute(httpRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			
			if (statusCode != 200){
	            return null;
	        }
	         
			HttpEntity httpResponse = response.getEntity();
			
			if (httpResponse != null) {
				
				try {
					return new JSONObject(EntityUtils.toString(httpResponse));
					
				} catch (JSONException | ParseException | IOException e) {
					e.printStackTrace();
					return null;
				}
			}
			
			return null;
			
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
