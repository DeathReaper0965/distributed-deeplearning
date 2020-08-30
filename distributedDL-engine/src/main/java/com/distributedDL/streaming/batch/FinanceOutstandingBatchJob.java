package com.distributedDL.streaming.batch;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.FinanceOutstandingBatchMapping;
import com.distributedDL.streaming.common.CommonConstants;

public class FinanceOutstandingBatchJob extends BatchJob{
	
	private static String combinedQuery = 
				"select org.business_name, fi.due_date, " + 
				"fi.inr_total_due_amount, fi.invoice_type, " + 
				"fi.status, fi.created_at " + 
				"from finance.finance_invoices as fi " + 
				"inner join organization.organization_organizations as org " + 
				"on org.id::TEXT = fi.buyer_id";

	public FinanceOutstandingBatchJob() {
		super(CommonConstants.COMBINED_STREAM, CommonConstants.COMBINED_CACHE_DIR, combinedQuery);
	}

	@Override
	public ExecutionEnvironment startbatch() {
		
		TypeInformation<?>[] fieldTypes = new TypeInformation<?>[] {
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.DATE_TYPE_INFO,
												BasicTypeInfo.DOUBLE_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.DATE_TYPE_INFO
											};

		JDBCInputFormat financeOutstandingInputFormat = this.getInputFormat(fieldTypes);
		
		DataSet<Row> financeOutstandingDataSet = this.getExecutionEnvironment().createInput(financeOutstandingInputFormat).setParallelism(10);
		
		DataSet<Boolean> statusDataSet = financeOutstandingDataSet.map(new FinanceOutstandingBatchMapping("STREAM_COMBINED_SERVER.public.outstanding.out"));
		
		long elemCount = 0;
		
		try {
			elemCount = statusDataSet.count();
			
			System.out.println(String.format("Successfully inserted %s values", elemCount));
			
			return this.getExecutionEnvironment();
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
