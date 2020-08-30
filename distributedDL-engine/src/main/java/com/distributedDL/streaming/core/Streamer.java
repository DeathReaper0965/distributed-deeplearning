package com.distributedDL.streaming.core;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Properties;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.contrib.streaming.state.PredefinedOptions;
import org.apache.flink.contrib.streaming.state.RocksDBStateBackend;
import org.apache.flink.runtime.state.StateBackend;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.environment.RemoteStreamEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import com.distributedDL.streaming.batch.BatchJob;
import com.distributedDL.streaming.cachedb.RocksDbOptionsFactory;
import com.distributedDL.streaming.common.CommonUtils;

@SuppressWarnings({ "rawtypes" })
public abstract class Streamer<T> {
	
	public StreamExecutionEnvironment streamEnvironment = null;
	
	public ExecutionEnvironment executionEnvironment = null;
	
	public LinkedHashSet<T> jobs = new LinkedHashSet<T>();
	
	protected static Streamer streamer;
	
	protected static String jobName;
	
	private Configuration conf;
	
	private Properties props;
	
	private String flinkUiHost;
	
	private int flinkUiPort; 
	
	private String rocksStateBackendPath;
	
	private StateBackend stateBackend = null;
	
	private RocksDBStateBackend rocksDBStateBackend = null;
	
	public Streamer() {
		
		conf = CommonUtils.getExecutionConf();
		
		try {
			props = CommonUtils.loadProperties();
			
			flinkUiHost = props.getProperty("flink.webui.host");
			flinkUiPort = Integer.parseInt(props.getProperty("flink.webui.port"));
			rocksStateBackendPath = props.getProperty("rocksdb.state.backend.path");
			
			File file = new File(rocksStateBackendPath);
			
			if(!file.exists()) {
				
				try {
					CommonUtils.makeLocalDir(rocksStateBackendPath);
				} catch (IOException e) {
	                throw new RuntimeException("Failed to make directory for rocksDB state backend" + rocksStateBackendPath);
	            }
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.streamEnvironment = new RemoteStreamEnvironment(flinkUiHost, flinkUiPort, conf);
		
		try {
			rocksDBStateBackend = new RocksDBStateBackend("file://" + this.rocksStateBackendPath, true);
			rocksDBStateBackend.setPredefinedOptions(PredefinedOptions.SPINNING_DISK_OPTIMIZED);
			rocksDBStateBackend.setOptions(new RocksDbOptionsFactory());
			
			stateBackend = (StateBackend) rocksDBStateBackend;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addJob(T job) {
		this.jobs.add(job);
	}
	
	public void start() throws Exception {
		
		for (T job : this.jobs) {
			if (job instanceof StreamingJob) {
				this.streamEnvironment = ((StreamingJob) job).initiate(this.streamEnvironment);
			}
			else if (job instanceof BatchJob) {
				this.executionEnvironment = ((BatchJob) job).getExecutionEnvironment();
				try {
					this.executionEnvironment.execute();
					((BatchJob) job).getRocksDbCache().cleanup();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		    
		}
		
		this.streamEnvironment.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
		this.streamEnvironment.setParallelism(5);
		this.streamEnvironment.setStateBackend(this.stateBackend);
		this.streamEnvironment.getCheckpointConfig().setMinPauseBetweenCheckpoints(100);
		this.streamEnvironment.execute(jobName != null ? jobName : "Flink Streaming Job");
	}
	
}
