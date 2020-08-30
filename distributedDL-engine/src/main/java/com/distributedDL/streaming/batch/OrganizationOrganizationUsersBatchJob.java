package com.distributedDL.streaming.batch;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.typeutils.GenericTypeInfo;
import org.apache.flink.types.Row;
import org.postgresql.jdbc4.Jdbc4Array;

import com.distributedDL.streaming.batch.cache.mapping.OrgOrgUsersBatchCacheMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class OrganizationOrganizationUsersBatchJob extends BatchJob {

	public OrganizationOrganizationUsersBatchJob() {
		super(CommonConstants.ORGANIZATION_ORGANIZATION_USERS_TABLE, CommonConstants.ORGANIZATION_DB, null);
	}

	@Override
	public ExecutionEnvironment startbatch() {
		TypeInformation<?>[] fieldTypes = new TypeInformation<?>[] {
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														BasicTypeInfo.STRING_TYPE_INFO,
														new GenericTypeInfo(Jdbc4Array.class),
														BasicTypeInfo.DATE_TYPE_INFO,
														BasicTypeInfo.DATE_TYPE_INFO,
											        };

	JDBCInputFormat oouInputFormat = this.getInputFormat(fieldTypes);
	
	RocksDbCache rocksDbCache = this.setCacheAndGetRocksDB(CommonConstants.ORGANIZATION_ORGANIZATIONS_USERS_CACHE);
	
	DataSet<Row> oouDataSet = this.getExecutionEnvironment().createInput(oouInputFormat).setParallelism(10);
	
	DataSet<Boolean> statusDataSet = oouDataSet.map(new OrgOrgUsersBatchCacheMapping(rocksDbCache));
	
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
