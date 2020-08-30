package com.distributedDL.streaming.batch;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.cache.mapping.ActivityLogsTagsBatchCacheMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;

public class ActivityLogsTagsBatchJob extends BatchJob{
	
	public ActivityLogsTagsBatchJob() {
		super(CommonConstants.ACTIVITY_LOGS_TAGS_TABLE, CommonConstants.MONGO_DUMP_DB, null);
	}

	public ExecutionEnvironment startbatch() {
		
		TypeInformation<?>[] fieldTypes = new TypeInformation<?>[] {
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
										        };
	        
		JDBCInputFormat activityLogsTagsInputFormat = this.getInputFormat(fieldTypes);
		
		RocksDbCache rocksDbCache = this.setCacheAndGetRocksDB(CommonConstants.ACTIVITY_LOGS_TAGS_CACHE);
		
		DataSet<Row> activityLogsTagssDataSet = this.getExecutionEnvironment().createInput(activityLogsTagsInputFormat).setParallelism(10);
		
		DataSet<Boolean> statusDataSet = activityLogsTagssDataSet.map(new ActivityLogsTagsBatchCacheMapping(rocksDbCache));
		
		long elemCount = 0;
		
		try {
			elemCount = statusDataSet.count();
			
			System.out.println(String.format("Successfully inserted %s values to RocksDB", elemCount));
			
			return this.getExecutionEnvironment();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
