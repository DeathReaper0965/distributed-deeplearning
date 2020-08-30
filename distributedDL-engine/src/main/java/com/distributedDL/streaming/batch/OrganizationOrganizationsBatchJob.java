package com.distributedDL.streaming.batch;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.cache.mapping.OrgOrgsBatchCacheMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;

public class OrganizationOrganizationsBatchJob extends BatchJob {

	public OrganizationOrganizationsBatchJob() {
		super(CommonConstants.ORGANIZATION_ORGANIZATIONS_TABLE, CommonConstants.ORGANIZATION_DB, null);
	}

	@Override
	public ExecutionEnvironment startbatch() {
		TypeInformation<?>[] fieldTypes = new TypeInformation<?>[] {
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.LONG_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.DATE_TYPE_INFO,
														BasicTypeInfo.DATE_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
											        };

		JDBCInputFormat organizationOrganizationsInputFormat = this.getInputFormat(fieldTypes);
		
		RocksDbCache rocksDbCache = this.setCacheAndGetRocksDB(CommonConstants.ORGANIZATION_ORGANIZATIONS_CACHE);
		
		DataSet<Row> organizationOrganizationsDataSet = this.getExecutionEnvironment().createInput(organizationOrganizationsInputFormat).setParallelism(10);
		
		DataSet<Boolean> statusDataSet = organizationOrganizationsDataSet.map(new OrgOrgsBatchCacheMapping(rocksDbCache));
		
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
