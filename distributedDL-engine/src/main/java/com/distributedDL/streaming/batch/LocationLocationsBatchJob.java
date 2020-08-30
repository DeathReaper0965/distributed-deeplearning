package com.distributedDL.streaming.batch;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.typeutils.GenericTypeInfo;
import org.apache.flink.types.Row;
import org.postgresql.jdbc4.Jdbc4Array;
import org.postgresql.util.PGobject;

import com.distributedDL.streaming.batch.cache.mapping.LocationLocationsBatchCacheMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;

@SuppressWarnings({"rawtypes", "unchecked"})
public class LocationLocationsBatchJob extends BatchJob{
	public LocationLocationsBatchJob() {
		super(CommonConstants.LOCATION_LOCATIONS_TABLE, CommonConstants.LOCATION_DB, null);
	}
	
	@Override
	public ExecutionEnvironment startbatch() {
		
		TypeInformation<?>[] fieldTypes = new TypeInformation<?>[] {
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													new GenericTypeInfo(PGobject.class),
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.BOOLEAN_TYPE_INFO,
													BasicTypeInfo.BOOLEAN_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													new GenericTypeInfo(Jdbc4Array.class),
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.STRING_TYPE_INFO,
													BasicTypeInfo.DATE_TYPE_INFO,
													BasicTypeInfo.DATE_TYPE_INFO,
										        };
	        
		JDBCInputFormat locationLocationsInputFormat = this.getInputFormat(fieldTypes);
		
		RocksDbCache rocksDbCache = this.setCacheAndGetRocksDB(CommonConstants.LOCATION_LOCATIONS_CACHE);
		
		DataSet<Row> locationLocationsDataSet = this.getExecutionEnvironment().createInput(locationLocationsInputFormat).setParallelism(10);
		
		DataSet<Boolean> statusDataSet = locationLocationsDataSet.map(new LocationLocationsBatchCacheMapping(rocksDbCache));
		
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
