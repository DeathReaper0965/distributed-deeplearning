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
public class FinanceInvoicesConsumerModel extends AppConsumerModel {
	
	@JsonProperty("id")
	private String id; 

	@JsonProperty("inc_id")
	private Integer incId; 

	@JsonProperty("seller_id")
	private String sellerId; 

	@JsonProperty("buyer_id")
	private String buyerId; 

	@JsonProperty("shipment_id")
	private String shipmentId; 

	@JsonProperty("place_of_supply_id")
	private String placeOfSupplyId; 

	@JsonProperty("updated_by_id")
	private String updatedById; 

	@JsonProperty("origin_id")
	private String originId; 

	@JsonProperty("destination_id")
	private String destinationId; 

	@JsonProperty("organization_id")
	private String organizationId; 

	@JsonProperty("invoice_type")
	private String invoiceType; 

	@JsonProperty("sub_type")
	private String subType; 

	@JsonProperty("seller_type")
	private String sellerType; 

	@JsonProperty("due_date")
	private Date dueDate; 

	@JsonProperty("invoice_date")
	private Date invoiceDate; 

	@JsonProperty("invoice_no")
	public static Jdbc4Array invoiceNo; 

	@JsonProperty("ref_invoice_no")
	private String refInvoiceNo; 

	@JsonProperty("status")
	private String status; 

	@JsonProperty("sub_total")
	private Double subTotal; 

	@JsonProperty("net_total")
	private Double netTotal; 

	@JsonProperty("total_tax")
	private Double totalTax; 

	@JsonProperty("comments")
	private String comments; 

	@JsonProperty("currency")
	private String currency; 

	@JsonProperty("status_changes")
	private Object statusChanges; 

	@JsonProperty("currency_conversion_rate")
	private Object currencyConversionRate; 

	@JsonProperty("invoice_file")
	private Object invoiceFile; 

	@JsonProperty("due_amount")
	private Double dueAmount; 

	@JsonProperty("tds")
	private Double tds; 

	@JsonProperty("tds_value")
	private Double tdsValue; 

	@JsonProperty("tds_amount")
	private Double tdsAmount; 

	@JsonProperty("master_transactions")
	public static Jdbc4Array masterTransactions; 

	@JsonProperty("incomes")
	public static Jdbc4Array incomes; 

	@JsonProperty("expenses")
	public static Jdbc4Array expenses; 

	@JsonProperty("invoice_message")
	private String invoiceMessage; 

	@JsonProperty("gst")
	private String gst; 

	@JsonProperty("terms")
	private Integer terms; 

	@JsonProperty("url")
	private String url; 

	@JsonProperty("bl_number")
	private String blNumber; 

	@JsonProperty("container_no")
	private String containerNo; 

	@JsonProperty("mail_sent")
	private Boolean mailSent; 

	@JsonProperty("alert")
	private Boolean alert; 

	@JsonProperty("expense_pending")
	private Boolean expensePending; 

	@JsonProperty("combined_invoice")
	private Boolean combinedInvoice; 

	@JsonProperty("vendor_invoice_date")
	private Date vendorInvoiceDate; 

	@JsonProperty("vendor_invoice_amount")
	private Integer vendorInvoiceAmount; 

	@JsonProperty("quickbook_migration")
	private Boolean quickbookMigration; 

	@JsonProperty("branch_id")
	private String branchId; 

	@JsonProperty("inr_net_total")
	private Double inrNetTotal; 

	@JsonProperty("inr_sub_total")
	private Double inrSubTotal; 

	@JsonProperty("inr_total_tax")
	private Double inrTotalTax; 

	@JsonProperty("inr_total_discount")
	private Double inrTotalDiscount; 

	@JsonProperty("inr_total_due_amount")
	private Double inrTotalDueAmount; 

	@JsonProperty("tds_mark")
	private Boolean tdsMark; 

	@JsonProperty("sailing_date")
	private Date sailingDate; 

	@JsonProperty("unregistered")
	private Boolean unregistered; 

	@JsonProperty("office_country_code")
	private String officeCountryCode; 

	@JsonProperty("created_at")
	private Date createdAt; 

	@JsonProperty("updated_at")
	private Date updatedAt; 

	@JsonProperty("mongo_id")
	private String mongoId; 

	@JsonProperty("promocodes")
	private Object promocodes; 

	@JsonProperty("credit_note_redemption")
	private Object creditNoteRedemption; 

	@JsonProperty("credit_note_reconciliation")
	private Object creditNoteReconciliation; 

	@JsonProperty("tds_type")
	private String tdsType; 

	@JsonProperty("negative_freight_allowed")
	private Boolean negativeFreightAllowed; 

	@JsonProperty("is_digio_signed")
	private Boolean isDigioSigned; 

	@JsonProperty("commission_rate")
	private Double commissionRate; 

	@JsonProperty("commission_invoice_id")
	private String commissionInvoiceId; 

	@JsonProperty("organization_user_id")
	private String organizationUserId; 

	@JsonProperty("nbfc_id")
	private String nbfcId; 


}