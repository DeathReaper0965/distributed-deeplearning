package com.distributedDL.streaming.models.producer;

import java.util.Date;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonDeserialize
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class FinSoProducerModel extends AppProducerModel {
	
//	Finance Invoices
	
	@JsonProperty("fin_id")
	private String finId;

	@JsonProperty("fin_inc_id")
	private Integer finIncId;

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
	private Object invoiceNo;

	@JsonProperty("ref_invoice_no")
	private String refInvoiceNo;

	@JsonProperty("fin_status")
	private String finStatus;

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
	private Object masterTransactions;

	@JsonProperty("incomes")
	private Object incomes;

	@JsonProperty("expenses")
	private Object expenses;

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

	@JsonProperty("fin_created_at")
	private Date finCreatedAt;

	@JsonProperty("fin_updated_at")
	private Date finUpdatedAt;

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
	
//	Shipment Orders
	
	@JsonProperty("shi_ord_id")
	private String shiOrdId;

	@JsonProperty("shi_ord_inc_id")
	private Integer shiOrdIncId;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("grouped_commodity")
	private String groupedCommodity;

	@JsonProperty("hazardous_type")
	private String hazardousType;

	@JsonProperty("commodity")
	private Object commodity;

	@JsonProperty("container_size")
	private String containerSize;

	@JsonProperty("container_type")
	private String containerType;

	@JsonProperty("trade_type")
	private String tradeType;

	@JsonProperty("bl_count")
	private Integer blCount;

	@JsonProperty("bl_type")
	private String blType;

	@JsonProperty("bl_delivery_mode")
	private String blDeliveryMode;

	@JsonProperty("shipping_line_id")
	private String shippingLineId;

	@JsonProperty("origin_main_port_id")
	private String originMainPortId;

	@JsonProperty("destination_main_port_id")
	private String destinationMainPortId;

	@JsonProperty("origin_port_id")
	private String originPortId;

	@JsonProperty("destination_port_id")
	private String destinationPortId;

	@JsonProperty("shi_ord_organization_user_id")
	private String shiOrdOrganizationUserId;

	@JsonProperty("freight_forwarder_id")
	private String freightForwarderId;

	@JsonProperty("initial_freight_forwarder_id")
	private String initialFreightForwarderId;

	@JsonProperty("prev_current_bd_id")
	private String prevCurrentBdId;

	@JsonProperty("current_booking_detail_id")
	private String currentBookingDetailId;

	@JsonProperty("prev_current_dod_id")
	private String prevCurrentDodId;

	@JsonProperty("current_do_detail_id")
	private String currentDoDetailId;

	@JsonProperty("shi_ord_status_changes")
	private Object shiOrdStatusChanges;

	@JsonProperty("mode")
	private String mode;

	@JsonProperty("is_lcl")
	private Boolean isLcl;

	@JsonProperty("source")
	private String source;

	@JsonProperty("customer_ref_number")
	private String customerRefNumber;

	@JsonProperty("seller_ref_number")
	private String sellerRefNumber;

	@JsonProperty("is_advance_shipment")
	private Boolean isAdvanceShipment;

	@JsonProperty("inco_term")
	private String incoTerm;

	@JsonProperty("shi_ord_status")
	private String shiOrdStatus;

	@JsonProperty("pre_status")
	private String preStatus;

	@JsonProperty("booking_detail_status")
	private String bookingDetailStatus;

	@JsonProperty("do_status")
	private String doStatus;

	@JsonProperty("last_activity_for_seller")
	private String lastActivityForSeller;

	@JsonProperty("status_milestones")
	private Object statusMilestones;

	@JsonProperty("status_milestones_hash")
	private Object statusMilestonesHash;

	@JsonProperty("booking_no")
	private Object bookingNo;

	@JsonProperty("bl_no")
	private Object blNo;

	@JsonProperty("delivery_order_no")
	private Object deliveryOrderNo;

	@JsonProperty("assisted_by_id")
	private String assistedById;

	@JsonProperty("quotation_verified_by_id")
	private String quotationVerifiedById;

	@JsonProperty("quotation_confirmed_by_id")
	private String quotationConfirmedById;

	@JsonProperty("duplicated_from_id")
	private String duplicatedFromId;

	@JsonProperty("duplicated_at")
	private Date duplicatedAt;

	@JsonProperty("duplicated_till_stage")
	private String duplicatedTillStage;

	@JsonProperty("duplicated_shipment_inc_ids")
	private Object duplicatedShipmentIncIds;

	@JsonProperty("is_freightos")
	private Boolean isFreightos;

	@JsonProperty("is_booked_during_flash_sale")
	private Boolean isBookedDuringFlashSale;

	@JsonProperty("booked_through_exim")
	private Boolean bookedThroughExim;

	@JsonProperty("third_party_shipper_id")
	private String thirdPartyShipperId;

	@JsonProperty("search_id")
	private String searchId;

	@JsonProperty("fcl_freight_charge_id")
	private String fclFreightChargeId;

	@JsonProperty("cfs_charge_id")
	private String cfsChargeId;

	@JsonProperty("haulage_charge_id")
	private String haulageChargeId;

	@JsonProperty("icd_charge_id")
	private String icdChargeId;

	@JsonProperty("request_quote_quotation_id")
	private String requestQuoteQuotationId;

	@JsonProperty("contracted_rate_quote_quotation_id")
	private String contractedRateQuoteQuotationId;

	@JsonProperty("offer_id")
	private String offerId;

	@JsonProperty("booking_party_rate_id")
	private String bookingPartyRateId;

	@JsonProperty("origin_country_id")
	private String originCountryId;

	@JsonProperty("origin_trade_lane_id")
	private String originTradeLaneId;

	@JsonProperty("origin_continent_id")
	private String originContinentId;

	@JsonProperty("destination_country_id")
	private String destinationCountryId;

	@JsonProperty("destination_trade_lane_id")
	private String destinationTradeLaneId;

	@JsonProperty("destination_continent_id")
	private String destinationContinentId;

	@JsonProperty("cfs_address")
	private Object cfsAddress;

	@JsonProperty("shipper_address")
	private Object shipperAddress;

	@JsonProperty("stuffing_address")
	private Object stuffingAddress;

	@JsonProperty("consignee_address")
	private Object consigneeAddress;

	@JsonProperty("cfs_location_id")
	private String cfsLocationId;

	@JsonProperty("shipper_location_id")
	private String shipperLocationId;

	@JsonProperty("stuffing_location_id")
	private String stuffingLocationId;

	@JsonProperty("consignee_location_id")
	private String consigneeLocationId;

	@JsonProperty("provider")
	private String provider;

	@JsonProperty("haulage_weight_slab")
	private String haulageWeightSlab;

	@JsonProperty("stuffing_type")
	private String stuffingType;

	@JsonProperty("sales_owner_id")
	private String salesOwnerId;

	@JsonProperty("engagement_owner_id")
	private String engagementOwnerId;

	@JsonProperty("operations_owner_id")
	private String operationsOwnerId;

	@JsonProperty("booking_desk_owner_id")
	private String bookingDeskOwnerId;

	@JsonProperty("freight_discount_id")
	private String freightDiscountId;

	@JsonProperty("delivery_feedback_received")
	private Boolean deliveryFeedbackReceived;

	@JsonProperty("freight_result")
	private Object freightResult;

	@JsonProperty("shipping_line_change_requested")
	private Boolean shippingLineChangeRequested;

	@JsonProperty("shipping_line_change_request_id")
	private String shippingLineChangeRequestId;

	@JsonProperty("shipper_address_details")
	private Object shipperAddressDetails;

	@JsonProperty("consignee_details")
	private Object consigneeDetails;

	@JsonProperty("imports_consignee_address")
	private Object importsConsigneeAddress;

	@JsonProperty("sail_schedule_details")
	private Object sailScheduleDetails;

	@JsonProperty("transit_time")
	private Integer transitTime;

	@JsonProperty("from_email")
	private Boolean fromEmail;

	@JsonProperty("shipment_value")
	private Double shipmentValue;

	@JsonProperty("shipment_currency")
	private String shipmentCurrency;

	@JsonProperty("invoicing_currency")
	private String invoicingCurrency;

	@JsonProperty("expected_booking_note_issue_date")
	private Date expectedBookingNoteIssueDate;

	@JsonProperty("sku_number")
	private String skuNumber;

	@JsonProperty("is_open_examination_marked")
	private Boolean isOpenExaminationMarked;

	@JsonProperty("booking_internal_process_start_date")
	private Date bookingInternalProcessStartDate;

	@JsonProperty("booking_received_at")
	private Date bookingReceivedAt;

	@JsonProperty("confirmed_by_shipper_at")
	private Date confirmedByShipperAt;

	@JsonProperty("booking_accepted_at")
	private Date bookingAcceptedAt;

	@JsonProperty("share_request")
	private Object shareRequest;

	@JsonProperty("is_bl_couriered")
	private Boolean isBlCouriered;

	@JsonProperty("bl_courier_company_name")
	private String blCourierCompanyName;

	@JsonProperty("bl_courier_tracking_id")
	private String blCourierTrackingId;

	@JsonProperty("europe_inter_modal_mode")
	private String europeInterModalMode;

	@JsonProperty("origin_detention")
	private Integer originDetention;

	@JsonProperty("destination_detention")
	private Integer destinationDetention;

	@JsonProperty("destination_demmurage")
	private Integer destinationDemmurage;

	@JsonProperty("plugin_day_origin")
	private Integer pluginDayOrigin;

	@JsonProperty("plugin_day_destination")
	private Integer pluginDayDestination;

	@JsonProperty("detention_day_origin")
	private Integer detentionDayOrigin;

	@JsonProperty("detention_day_destination")
	private Integer detentionDayDestination;

	@JsonProperty("demurage_day_destination")
	private Integer demurageDayDestination;

	@JsonProperty("containers_pickup_date")
	private Date containersPickupDate;

	@JsonProperty("container_weight_limit")
	private Integer containerWeightLimit;

	@JsonProperty("weight_slab")
	private String weightSlab;

	@JsonProperty("weight_slab_unit")
	private String weightSlabUnit;

	@JsonProperty("temperature_slab")
	private String temperatureSlab;

	@JsonProperty("temperature_slab_unit")
	private String temperatureSlabUnit;

	@JsonProperty("temperature")
	private Double temperature;

	@JsonProperty("vent_setting")
	private String ventSetting;

	@JsonProperty("ventilation")
	private Integer ventilation;

	@JsonProperty("ventilation_unit")
	private String ventilationUnit;

	@JsonProperty("humidity")
	private Integer humidity;

	@JsonProperty("humidity_unit")
	private String humidityUnit;

	@JsonProperty("length")
	private Integer length;

	@JsonProperty("width")
	private Integer width;

	@JsonProperty("height")
	private Integer height;

	@JsonProperty("dimension_unit")
	private String dimensionUnit;

	@JsonProperty("container_pickup_activity")
	private Object containerPickupActivity;

	@JsonProperty("container_gate_in_activity")
	private Object containerGateInActivity;

	@JsonProperty("container_linking_activity")
	private Object containerLinkingActivity;

	@JsonProperty("bl_activity")
	private Object blActivity;

	@JsonProperty("ingauge")
	private Boolean ingauge;

	@JsonProperty("manual")
	private Boolean manual;

	@JsonProperty("remarks")
	private String remarks;

	@JsonProperty("enquiry_comments")
	private String enquiryComments;

	@JsonProperty("importer_exporter_info_id")
	private String importerExporterInfoId;

	@JsonProperty("consignee_id")
	private String consigneeId;

	@JsonProperty("is_supplier_assigned")
	private Boolean isSupplierAssigned;

	@JsonProperty("income_pending")
	private Boolean incomePending;

	@JsonProperty("shi_ord_expense_pending")
	private Boolean shiOrdExpensePending;

	@JsonProperty("vgm_selected")
	private Boolean vgmSelected;

	@JsonProperty("lock_quotation")
	private Boolean lockQuotation;

	@JsonProperty("margin_percentage")
	private Double marginPercentage;

	@JsonProperty("buyer_markups")
	private Object buyerMarkups;

	@JsonProperty("invoices_ccr")
	private Object invoicesCcr;

	@JsonProperty("is_cancellation_requested")
	private Boolean isCancellationRequested;

	@JsonProperty("cancellation_requested_reason")
	private String cancellationRequestedReason;

	@JsonProperty("cancellation_reason")
	private String cancellationReason;

	@JsonProperty("cancellation_sub_reason")
	private String cancellationSubReason;

	@JsonProperty("cancellation_responsible_party")
	private String cancellationResponsibleParty;

	@JsonProperty("cancelled_by")
	private Object cancelledBy;

	@JsonProperty("replacement_shipment_id")
	private Integer replacementShipmentId;

	@JsonProperty("abort_reason")
	private String abortReason;

	@JsonProperty("cancellation_summary")
	private String cancellationSummary;

	@JsonProperty("cancelled_with_revenue_loss")
	private Boolean cancelledWithRevenueLoss;

	@JsonProperty("cancellation_approved_by_admin")
	private Boolean cancellationApprovedByAdmin;

	@JsonProperty("cancellation_assessment_status")
	private String cancellationAssessmentStatus;

	@JsonProperty("is_cancellation_reason_updated")
	private Boolean isCancellationReasonUpdated;

	@JsonProperty("booking_turnaround_time")
	private Integer bookingTurnaroundTime;

	@JsonProperty("etd_deviation")
	private Integer etdDeviation;

	@JsonProperty("transit_time_deviation")
	private Integer transitTimeDeviation;

	@JsonProperty("b_l_release_time")
	private Integer bLReleaseTime;

	@JsonProperty("billing_accuracy")
	private Double billingAccuracy;

	@JsonProperty("logistics_cost_to_fob")
	private Double logisticsCostToFob;

	@JsonProperty("expense_billing_accuracy")
	private Double expenseBillingAccuracy;

	@JsonProperty("loyalty_program_applicable")
	private Boolean loyaltyProgramApplicable;

	@JsonProperty("loyalty_config_snapshot")
	private Object loyaltyConfigSnapshot;

	@JsonProperty("is_store_transfer_done")
	private Boolean isStoreTransferDone;

	@JsonProperty("deduct_loyalty_points")
	private Boolean deductLoyaltyPoints;

	@JsonProperty("loyalty_points_redeem_type")
	private String loyaltyPointsRedeemType;

	@JsonProperty("loyalty_points_max_redeem_locked")
	private Boolean loyaltyPointsMaxRedeemLocked;

	@JsonProperty("loyalty_points_initially_redeemed")
	private Integer loyaltyPointsInitiallyRedeemed;

	@JsonProperty("loyalty_point_redemption_data")
	private Object loyaltyPointRedemptionData;

	@JsonProperty("loyalty_points_earning_breakup")
	private Object loyaltyPointsEarningBreakup;

	@JsonProperty("loyalty_points_actual_spending")
	private Integer loyaltyPointsActualSpending;

	@JsonProperty("loyalty_points_locked")
	private Boolean loyaltyPointsLocked;

	@JsonProperty("is_supplier_team_approved")
	private Boolean isSupplierTeamApproved;

	@JsonProperty("supplier_team_approved_at")
	private Date supplierTeamApprovedAt;

	@JsonProperty("supplier_negotiation_initiated")
	private Boolean supplierNegotiationInitiated;

	@JsonProperty("email_log_ids")
	private Object emailLogIds;

	@JsonProperty("is_confirmed_by_shipper")
	private Boolean isConfirmedByShipper;

	@JsonProperty("quotation_confirmed_at")
	private Date quotationConfirmedAt;

	@JsonProperty("bl_release")
	private Boolean blRelease;

	@JsonProperty("expected_shipment_date")
	private Date expectedShipmentDate;

	@JsonProperty("actual_time_of_departure")
	private Date actualTimeOfDeparture;

	@JsonProperty("expected_arrival_date")
	private Date expectedArrivalDate;

	@JsonProperty("actual_arrival_date")
	private Date actualArrivalDate;

	@JsonProperty("completed_at")
	private Date completedAt;

	@JsonProperty("cancelled_at")
	private Date cancelledAt;

	@JsonProperty("aborted_at")
	private Date abortedAt;

	@JsonProperty("shi_ord_branch_id")
	private String shiOrdBranchId;

	@JsonProperty("freight_discount_hash")
	private Object freightDiscountHash;

	@JsonProperty("promocode_discount_per_container")
	private Integer promocodeDiscountPerContainer;

	@JsonProperty("freight_search_discount_markup")
	private Object freightSearchDiscountMarkup;

	@JsonProperty("google_event_id")
	private String googleEventId;

	@JsonProperty("device")
	private String device;

	@JsonProperty("operating_system")
	private String operatingSystem;

	@JsonProperty("browser")
	private String browser;

	@JsonProperty("is_draft_expired")
	private Boolean isDraftExpired;

	@JsonProperty("draft_expiry_at")
	private Date draftExpiryAt;

	@JsonProperty("active_escalations_count")
	private Integer activeEscalationsCount;

	@JsonProperty("payment_options_snapshot")
	private Object paymentOptionsSnapshot;

	@JsonProperty("shi_ord_office_country_code")
	private String shiOrdOfficeCountryCode;

	@JsonProperty("booking_ref_number")
	private String bookingRefNumber;

	@JsonProperty("is_nostro_charge_applicable")
	private Boolean isNostroChargeApplicable;

	@JsonProperty("search_requirement_id")
	private String searchRequirementId;

	@JsonProperty("cogo_scheduled_automation_element_index")
	private Integer cogoScheduledAutomationElementIndex;

	@JsonProperty("cogo_email_recipient_id")
	private String cogoEmailRecipientId;

	@JsonProperty("cogo_email_template_id")
	private String cogoEmailTemplateId;

	@JsonProperty("cogo_scheduled_automation_id")
	private String cogoScheduledAutomationId;

	@JsonProperty("utm_source")
	private String utmSource;

	@JsonProperty("utm_medium")
	private String utmMedium;

	@JsonProperty("utm_campaign")
	private String utmCampaign;

	@JsonProperty("cogo_email")
	private String cogoEmail;

	@JsonProperty("cogo_token")
	private String cogoToken;

	@JsonProperty("cogo_org_user_id")
	private String cogoOrgUserId;

	@JsonProperty("cogo_lead_id")
	private String cogoLeadId;

	@JsonProperty("cogo_assisted_by_id")
	private String cogoAssistedById;

	@JsonProperty("shi_ord_created_at")
	private Date shiOrdCreatedAt;

	@JsonProperty("shi_ord_updated_at")
	private Date shiOrdUpdatedAt;

	@JsonProperty("shi_ord_mongo_id")
	private String shiOrdMongoId;

	@JsonProperty("current_invoice_preference_id")
	private String currentInvoicePreferenceId;

	@JsonProperty("is_haz")
	private Boolean isHaz;

	@JsonProperty("search_checkout_id")
	private String searchCheckoutId;

	@JsonProperty("search_package_id")
	private String searchPackageId;

	@JsonProperty("shipper_enquiry_id")
	private String shipperEnquiryId;

	@JsonProperty("origin_cha_id")
	private String originChaId;

	@JsonProperty("origin_customs_charge_id")
	private String originCustomsChargeId;

	@JsonProperty("origin_stuffing_charge_id")
	private String originStuffingChargeId;

	@JsonProperty("destination_cha_id")
	private String destinationChaId;

	@JsonProperty("destination_customs_charge_id")
	private String destinationCustomsChargeId;

	@JsonProperty("destination_destuffing_charge_id")
	private String destinationDestuffingChargeId;

	@JsonProperty("origin_transporter_id")
	private String originTransporterId;

	@JsonProperty("origin_truck_charge_id")
	private String originTruckChargeId;

	@JsonProperty("origin_trailer_charge_id")
	private String originTrailerChargeId;

	@JsonProperty("destination_transporter_id")
	private String destinationTransporterId;

	@JsonProperty("destination_truck_charge_id")
	private String destinationTruckChargeId;

	@JsonProperty("destination_trailer_charge_id")
	private String destinationTrailerChargeId;

	@JsonProperty("origin_haulage_provider_id")
	private String originHaulageProviderId;

	@JsonProperty("origin_haulage_charge_id")
	private String originHaulageChargeId;

	@JsonProperty("destination_haulage_provider_id")
	private String destinationHaulageProviderId;

	@JsonProperty("destination_haulage_charge_id")
	private String destinationHaulageChargeId;

	@JsonProperty("initial_booking_amount")
	private Object initialBookingAmount;

	@JsonProperty("pickup_location_id")
	private String pickupLocationId;

	@JsonProperty("delivery_location_id")
	private String deliveryLocationId;

	@JsonProperty("billing_address_id")
	private String billingAddressId;

	@JsonProperty("billing_address")
	private Object billingAddress;

	@JsonProperty("mailing_address_id")
	private String mailingAddressId;

	@JsonProperty("mailing_address")
	private Object mailingAddress;

	@JsonProperty("destuffing_type")
	private String destuffingType;

	@JsonProperty("cfs_stuffing_id")
	private String cfsStuffingId;

	@JsonProperty("cfs_stuffing_address")
	private Object cfsStuffingAddress;

	@JsonProperty("cfs_destuffing_id")
	private String cfsDestuffingId;

	@JsonProperty("cfs_destuffing_address")
	private Object cfsDestuffingAddress;

	@JsonProperty("factory_address_id")
	private String factoryAddressId;

	@JsonProperty("factory_address")
	private Object factoryAddress;

	@JsonProperty("consignee_warehouse_address_id")
	private String consigneeWarehouseAddressId;

	@JsonProperty("consignee_warehouse_address")
	private Object consigneeWarehouseAddress;

	@JsonProperty("shipping_bill_count")
	private Integer shippingBillCount;

	@JsonProperty("origin_truck_type")
	private String originTruckType;

	@JsonProperty("destination_truck_type")
	private String destinationTruckType;

	@JsonProperty("truck_count")
	private Integer truckCount;

	@JsonProperty("truck_type")
	private String truckType;

	@JsonProperty("cargo_weight")
	private Double cargoWeight;

	@JsonProperty("cargo_weight_unit")
	private String cargoWeightUnit;

	@JsonProperty("cargo_pickup_date")
	private Date cargoPickupDate;

	@JsonProperty("vgm_filed_at")
	private Date vgmFiledAt;

	@JsonProperty("form_13_filed_at")
	private Date form13FiledAt;

	@JsonProperty("si_filed_at")
	private Date siFiledAt;

	@JsonProperty("invoice_currency_for_freight")
	private String invoiceCurrencyForFreight;

	@JsonProperty("invoice_currency_for_other_services")
	private String invoiceCurrencyForOtherServices;

	@JsonProperty("trans_shipment_stops")
	private Integer transShipmentStops;

	@JsonProperty("vessel_name")
	private String vesselName;

	@JsonProperty("transport_weight_slab")
	private String transportWeightSlab;

	@JsonProperty("consignee_ids")
	private Object consigneeIds;

	@JsonProperty("payment_type")
	private String paymentType;

	@JsonProperty("payment_term")
	private String paymentTerm;

	@JsonProperty("clp_progress_stages")
	private Object clpProgressStages;

	@JsonProperty("has_kyc_consent")
	private Boolean hasKycConsent;

	@JsonProperty("origin_haulage_provider_type")
	private String originHaulageProviderType;

	@JsonProperty("origin_haulage_transport_mode")
	private String originHaulageTransportMode;

	@JsonProperty("origin_haulage_transport_service_provider")
	private String originHaulageTransportServiceProvider;

	@JsonProperty("destination_haulage_provider_type")
	private String destinationHaulageProviderType;

	@JsonProperty("destination_haulage_transport_mode")
	private String destinationHaulageTransportMode;

	@JsonProperty("destination_haulage_transport_service_provider")
	private String destinationHaulageTransportServiceProvider;

	@JsonProperty("milestone_etas")
	private Object milestoneEtas;
	
//	Organization Organizations
	
	@JsonProperty("oo_id")
	private String ooId;

	@JsonProperty("serial_id")
	private Integer serialId;

	@JsonProperty("business_name")
	private String businessName;

	@JsonProperty("short_name")
	private String shortName;

	@JsonProperty("about")
	private String about;

	@JsonProperty("account_type")
	private String accountType;

	@JsonProperty("website")
	private String website;

	@JsonProperty("logo")
	private String logo;

	@JsonProperty("oo_status")
	private String ooStatus;

	@JsonProperty("oo_mongo_id")
	private String ooMongoId;

	@JsonProperty("oo_created_at")
	private Date ooCreatedAt;

	@JsonProperty("oo_updated_at")
	private Date ooUpdatedAt;
	
//	Organization Organization Users
	
	@JsonProperty("oou_id")
	private String oouId;

	@JsonProperty("oou_organization_id")
	private String oouOrganizationId;

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("oou_status")
	private String oouStatus;

	@JsonProperty("designation")
	private String designation;

	@JsonProperty("mongo_ids")
	private Object mongoIds;

	@JsonProperty("oou_created_at")
	private Date oouCreatedAt;

	@JsonProperty("oou_updated_at")
	private Date oouUpdatedAt;
	
//	Location Locations 
	
	@JsonProperty("ll_id")
	private String llId;

	@JsonProperty("ll_mongo_id")
	private String llMongoId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("display_name")
	private String displayName;

	@JsonProperty("type")
	private String type;

	@JsonProperty("ll_status")
	private String llStatus;

	@JsonProperty("continent_id")
	private String continentId;

	@JsonProperty("trade_id")
	private String tradeId;

	@JsonProperty("country_id")
	private String countryId;

	@JsonProperty("region_id")
	private String regionId;

	@JsonProperty("city_id")
	private String cityId;

	@JsonProperty("cluster_id")
	private String clusterId;

	@JsonProperty("port_id")
	private String portId;

	@JsonProperty("pincode_id")
	private String pincodeId;

	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("longitude")
	private String longitude;

	@JsonProperty("loc")
	private Object loc;

	@JsonProperty("postal_code")
	private String postalCode;

	@JsonProperty("is_icd")
	private Boolean isIcd;

	@JsonProperty("is_airport")
	private Boolean isAirport;

	@JsonProperty("port_code")
	private String portCode;

	@JsonProperty("inttra_code")
	private String inttraCode;

	@JsonProperty("icd_ports")
	private Object icdPorts;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("mobile_country_code")
	private String mobileCountryCode;

	@JsonProperty("flag_icon_url")
	private String flagIconUrl;

	@JsonProperty("flag_image_url")
	private String flagImageUrl;

	@JsonProperty("ll_created_at")
	private Date llCreatedAt;

	@JsonProperty("ll_updated_at")
	private Date llUpdatedAt;
}
