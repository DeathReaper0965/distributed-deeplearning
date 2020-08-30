package com.distributedDL.streaming.batch;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.cache.mapping.ActivityLogsBucketsBatchCacheMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;

public class ActivityLogsBucketsBatchJob extends BatchJob{
	
	public ActivityLogsBucketsBatchJob() {
		super(CommonConstants.ACTIVITY_LOGS_BUCKETS_TABLE, CommonConstants.MONGO_DUMP_DB, null);
	}
	
	public ExecutionEnvironment startbatch() {
		
		TypeInformation<?>[] fieldTypes = new TypeInformation<?>[] {
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.DATE_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.DATE_TYPE_INFO
										        };
	        
		JDBCInputFormat activityLogsBucketsInputFormat = this.getInputFormat(fieldTypes);
		
		RocksDbCache rocksDbCache = this.setCacheAndGetRocksDB(CommonConstants.ACTIVITY_LOGS_BUCKETS_CACHE);
		
		DataSet<Row> activityLogsBucketsDataSet = getExecutionEnvironment().createInput(activityLogsBucketsInputFormat).setParallelism(10);
		
		DataSet<Boolean> statusDataSet = activityLogsBucketsDataSet.map(new ActivityLogsBucketsBatchCacheMapping(rocksDbCache));
		
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
