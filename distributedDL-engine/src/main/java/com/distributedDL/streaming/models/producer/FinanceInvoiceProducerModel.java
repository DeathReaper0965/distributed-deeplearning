package com.distributedDL.streaming.models.producer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@JsonSerialize
@EqualsAndHashCode(callSuper = true)
public class FinanceInvoiceProducerModel extends AppProducerModel{
	@JsonProperty("org_business_name")
	String orgBusinessName;
	@JsonProperty("org_iec")
	String orgIec;
	@JsonProperty("org_gst")
	String orgGst;
	@JsonProperty("org_converted_at")
	String orgConvertedAt;
	@JsonProperty("org_account_type")
	String orgAccountType;
	@JsonProperty("org_inc_id")
	long orgIncId;
	@JsonProperty("org_is_shipping_line")
	String orgIsShippingLine;
	@JsonProperty("org_registration_type")
	String orgRegistrationType;
	@JsonProperty("org_signup_city")
	String orgSignupCity;
	@JsonProperty("org_is_ssp")
	String orgIsSsp;
	@JsonProperty("org_type")
	String orgType;
	@JsonProperty("org_user_email")
	String orgUserEmail;
	@JsonProperty("org_user_name")
	String orgUserName;
	@JsonProperty("org_user_phone_no")
	String orgUserPhoneNo;
	@JsonProperty("finance_invoice_due")
	double financeInvoiceDue;
	
}
