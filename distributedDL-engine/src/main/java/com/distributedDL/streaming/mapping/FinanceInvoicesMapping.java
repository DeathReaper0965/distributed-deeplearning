package com.distributedDL.streaming.mapping;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;

import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.common.DBConnection;
import com.distributedDL.streaming.models.consumer.FinanceInvoicesConsumerModel;
import com.distributedDL.streaming.models.producer.FinanceInvoiceProducerModel;

@SuppressWarnings("serial")
public class FinanceInvoicesMapping extends AppMapping<FinanceInvoicesConsumerModel, FinanceInvoiceProducerModel>{

	public FinanceInvoiceProducerModel mapping(FinanceInvoicesConsumerModel financeInvoicesConsumerModel, FinanceInvoiceProducerModel financeInvoiceProducerModel) {
		System.out.println("id: " + financeInvoicesConsumerModel.getId());
		System.out.println("inr_total_due_amount: " + financeInvoicesConsumerModel.getInrTotalDueAmount());
		financeInvoiceProducerModel.setFinanceInvoiceDue(Double.valueOf(financeInvoicesConsumerModel.getInrTotalDueAmount()));
		
		DBConnection dbConnection = new DBConnection();
		Connection conn = dbConnection.getMongoDumpDBConnection();
		
		if(conn == null){
			return null;
		}
		
		HashMap<String, String> orgDict = CommonUtils.getOrgFromOrgUser(financeInvoicesConsumerModel.getSellerId(), conn, "_id");
		
		financeInvoiceProducerModel.setOrgBusinessName(orgDict.get("business_name"));
		financeInvoiceProducerModel.setOrgIec(orgDict.get("iec"));
		financeInvoiceProducerModel.setOrgGst(orgDict.get("gst"));
		
		String convertedAt = orgDict.get("converted_at");
		if (convertedAt != null)
			financeInvoiceProducerModel.setOrgConvertedAt((new Date(Long.parseLong(convertedAt)).toString()));
		else 
			financeInvoiceProducerModel.setOrgConvertedAt(null);
		
		financeInvoiceProducerModel.setOrgAccountType(orgDict.get("account_type"));
		financeInvoiceProducerModel.setOrgIncId(Long.valueOf(orgDict.get("inc_id")));
		financeInvoiceProducerModel.setOrgIsShippingLine(orgDict.get("is_shipping_line"));
		financeInvoiceProducerModel.setOrgRegistrationType(orgDict.get("registration_type"));
		financeInvoiceProducerModel.setOrgSignupCity(orgDict.get("signup_city"));
		financeInvoiceProducerModel.setOrgIsSsp(orgDict.get("is_ssp"));
		financeInvoiceProducerModel.setOrgType(orgDict.get("type"));
		
		HashMap<String, String> orgUserDict = CommonUtils.getOrgUserFromId(financeInvoicesConsumerModel.getSellerId(), conn, "organization_id");
		financeInvoiceProducerModel.setOrgUserEmail(orgUserDict.get("email"));
		financeInvoiceProducerModel.setOrgUserName(orgUserDict.get("name"));
		financeInvoiceProducerModel.setOrgUserPhoneNo(orgUserDict.get("phone_no"));
		
		return financeInvoiceProducerModel;
	}

}
