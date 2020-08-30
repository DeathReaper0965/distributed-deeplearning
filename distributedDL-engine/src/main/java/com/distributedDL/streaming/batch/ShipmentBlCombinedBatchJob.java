package com.distributedDL.streaming.batch;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.ShipmentBlCombinedBatchMapping;
import com.distributedDL.streaming.common.CommonConstants;


public class ShipmentBlCombinedBatchJob extends BatchJob{

	private static String combinedQuery = 
				"select bl.id as bl_id, " + 
				"bl.shipment_id as shipment_id, " + 
				" bl.draft_bl_acceptance_status as draft_bl_acceptance_status, " + 
				" bl.bl_hold_reason as bl_hold_reason, " + 
				"bl.bl_release_delay_reason as bl_release_delay_reason, " + 
				" bl.containers_count as containers_count, " + 
				"bl.bl_number as bl_number, " + 
				"bl.bl_type as bl_type, " + 
				" bl.bl_status as bl_status, " + 
				"bl.bl_delay_responsible_party as bl_delay_responsible_party, " + 
				" bl.bl_delay_reason as bl_delay_reason, " + 
				"bl.bl_release_status as bl_release_status, " + 
				" bl.created_at as bl_created_at, " + 
				"bl.draft_bl_rejection_reason as draft_bl_rejection_reason, " + 
				" sd.file_type as file_type, " + 
				"sd.file_name as file_name, " + 
				"sd.amount as amount, " + 
				" sd.created_at as shipment_created_at, " + 
				"sd.updated_at as shipment_updated_at, " + 
				" sd.verified_at as shipment_verified_at, " + 
				"sd.document_date as shipment_document_date, " + 
				" sd.admin_id as shipment_admin_id, " + 
				"use.name as organization_user_name, " + 
				" use.email as organization_user_email, " + 
				"use.phone_no as organization_user_phone_no, " + 
				" org.business_name as organization_business_name, " + 
				"adm.name as admin_name " + 
				" from shipment.shipment_bl_details as bl " + 
				" left join shipment.shipment_documents as sd on bl.shipment_id::text=sd.entity_id " + 
				" inner join mongo_dump.pg_organizations_users as use on sd.organization_user_id=use._id " + 
				" inner join mongo_dump.pg_organizations as org on use.organization_id=org._id " + 
				" inner join mongo_dump.pg_admins as adm on org.owner_id= adm._id";
	
	public ShipmentBlCombinedBatchJob() {
		super(CommonConstants.COMBINED_SHIPMENT_BL, CommonConstants.SHIPMENT_DB, combinedQuery);
	}

	@Override
	public ExecutionEnvironment startbatch() {

		TypeInformation<?>[] fieldTypes = new TypeInformation<?>[] {
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.LONG_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.DATE_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.DATE_TYPE_INFO,
												BasicTypeInfo.DATE_TYPE_INFO,
												BasicTypeInfo.DATE_TYPE_INFO,
												BasicTypeInfo.DATE_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
												BasicTypeInfo.STRING_TYPE_INFO,
											};

		JDBCInputFormat shipmentBlCombInputFormat = this.getInputFormat(fieldTypes);
		
		DataSet<Row> orgUserDataSet = this.getExecutionEnvironment().createInput(shipmentBlCombInputFormat).setParallelism(10);
		
		DataSet<Boolean> statusDataSet = orgUserDataSet.map(new ShipmentBlCombinedBatchMapping("SHIPMENT_SERVER.public.combined_stream_bl.out"));
		
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
