package com.distributedDL.streaming.models.consumer;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@JsonDeserialize
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class FtlBasedFinanceInvoicesConsumerModel extends AppConsumerModel {
	
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
	private String dueDate;

	@JsonProperty("invoice_date")
	private String invoiceDate;

	@JsonProperty("invoice_no")
	private List<Object> invoiceNo;

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
	private String statusChanges;

	@JsonProperty("currency_conversion_rate")
	private String currencyConversionRate;

	@JsonProperty("invoice_file")
	private String invoiceFile;

	@JsonProperty("due_amount")
	private Double dueAmount;

	@JsonProperty("tds")
	private Object tds;

	@JsonProperty("tds_value")
	private Double tdsValue;

	@JsonProperty("tds_amount")
	private Double tdsAmount;

	@JsonProperty("master_transactions")
	private List<Object> masterTransactions;

	@JsonProperty("incomes")
	private List<Object> incomes;

	@JsonProperty("expenses")
	private List<Object> expenses;

	@JsonProperty("invoice_message")
	private String invoiceMessage;

	@JsonProperty("gst")
	private String gst;

	@JsonProperty("terms")
	private Object terms;

	@JsonProperty("url")
	private Object url;

	@JsonProperty("bl_number")
	private Object blNumber;

	@JsonProperty("container_no")
	private Object containerNo;

	@JsonProperty("mail_sent")
	private Boolean mailSent;

	@JsonProperty("alert")
	private Boolean alert;

	@JsonProperty("expense_pending")
	private Boolean expensePending;

	@JsonProperty("combined_invoice")
	private Boolean combinedInvoice;

	@JsonProperty("vendor_invoice_date")
	private Object vendorInvoiceDate;

	@JsonProperty("vendor_invoice_amount")
	private Integer vendorInvoiceAmount;

	@JsonProperty("quickbook_migration")
	private Object quickbookMigration;

	@JsonProperty("branch_id")
	private Object branchId;

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
	private Object sailingDate;

	@JsonProperty("unregistered")
	private Boolean unregistered;

	@JsonProperty("office_country_code")
	private String officeCountryCode;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("mongo_id")
	private String mongoId;

	@JsonProperty("promocodes")
	private String promocodes;

	@JsonProperty("credit_note_redemption")
	private String creditNoteRedemption;

	@JsonProperty("credit_note_reconciliation")
	private String creditNoteReconciliation;

	@JsonProperty("tds_type")
	private Object tdsType;

	@JsonProperty("negative_freight_allowed")
	private Boolean negativeFreightAllowed;


}