package com.distributedDL.streaming.models.consumer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import org.postgresql.jdbc4.Jdbc4Array;

@Data
@JsonDeserialize
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class FinancePaymentTransactionsConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("organization_id")
	private String organizationId; 

	@JsonProperty("updated_by_id")
	private String updatedById; 

	@JsonProperty("inc_id")
	private Integer incId; 

	@JsonProperty("amount")
	private Double amount; 

	@JsonProperty("bank")
	private String bank; 

	@JsonProperty("transaction_id")
	private String transactionId; 

	@JsonProperty("transaction_mode")
	private String transactionMode; 

	@JsonProperty("currency")
	private String currency; 

	@JsonProperty("transaction_type")
	private String transactionType; 

	@JsonProperty("transaction_date")
	private Date transactionDate; 

	@JsonProperty("cheque_no")
	private String chequeNo; 

	@JsonProperty("status")
	private String status; 

	@JsonProperty("status_changes")
	private Object statusChanges; 

	@JsonProperty("bank_initiated")
	private Boolean bankInitiated; 

	@JsonProperty("response_body")
	public static Jdbc4Array responseBody; 

	@JsonProperty("conflicts")
	public static Jdbc4Array conflicts; 

	@JsonProperty("quickbook_migration")
	private Boolean quickbookMigration; 

	@JsonProperty("currency_conversion_rate")
	public static Jdbc4Array currencyConversionRate; 

	@JsonProperty("office_country_code")
	private String officeCountryCode; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 

	@JsonProperty("mongo_id")
	private String mongoId; 

	@JsonProperty("bank_details_id")
	private String bankDetailsId; 

	@JsonProperty("tds_cert_url")
	private String tdsCertUrl; 

	@JsonProperty("filing_type")
	private String filingType; 

	@JsonProperty("assessment_year")
	private Integer assessmentYear; 

	@JsonProperty("branch_id")
	private String branchId; 

	@JsonProperty("bank_id")
	private String bankId; 

	@JsonProperty("organization_user_id")
	private String organizationUserId; 

	@JsonProperty("commission_id")
	private String commissionId; 


}