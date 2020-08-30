package com.distributedDL.streaming.batch;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.cache.mapping.OrgUsersBatchCacheMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;

public class OrganizationsUsersBatchJob extends BatchJob{
	
	public OrganizationsUsersBatchJob() {
		super(CommonConstants.ORGANIZATIONS_USERS_TABLE, CommonConstants.MONGO_DUMP_DB, null);
	}
	
	public ExecutionEnvironment startbatch() {
		
		TypeInformation<?>[] fieldTypes = new TypeInformation<?>[] {
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.DATE_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.LONG_TYPE_INFO,
													BasicTypeInfo.BOOLEAN_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.DATE_TYPE_INFO
										        };
	    
		JDBCInputFormat orgUserInputFormat = this.getInputFormat(fieldTypes);
		
		RocksDbCache rocksDbCache = this.setCacheAndGetRocksDB(CommonConstants.ORGANIZATIONS_USERS_CACHE);
		
		DataSet<Row> orgUserDataSet = this.getExecutionEnvironment().createInput(orgUserInputFormat).setParallelism(10);
		
		DataSet<Boolean> statusDataSet = orgUserDataSet.map(new OrgUsersBatchCacheMapping(rocksDbCache));
		
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
