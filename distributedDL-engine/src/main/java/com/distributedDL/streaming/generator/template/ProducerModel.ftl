package com.distributedDL.streaming.models.consumer;

import java.util.List;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "id", "inc_id", "quantity", "grouped_commodity", "hazardous_type", "commodity", "container_size",
		"container_type", "trade_type", "bl_count", "bl_type", "bl_delivery_mode", "shipping_line_id",
		"origin_main_port_id", "destination_main_port_id", "origin_port_id", "destination_port_id",
		"organization_user_id", "freight_forwarder_id", "initial_freight_forwarder_id", "prev_current_bd_id",
		"current_booking_detail_id", "prev_current_dod_id", "current_do_detail_id", "status_changes", "mode", "is_lcl",
		"source", "customer_ref_number", "seller_ref_number", "is_advance_shipment", "inco_terms", "status",
		"pre_status", "booking_detail_status", "do_status", "last_activity_for_seller", "booking_no", "bl_no",
		"delivery_order_no", "assisted_by_id", "quotation_verified_by_id", "quotation_confirmed_by_id",
		"duplicated_from_id", "duplicated_at", "duplicated_till_stage", "duplicated_shipment_inc_ids", "is_freightos",
		"is_booked_during_flash_sale", "booked_through_exim", "third_party_shipper_id", "search_id",
		"fcl_freight_charge_id", "cfs_charge_id", "haulage_charge_id", "icd_charge_id", "request_quote_quotation_id",
		"contracted_rate_quote_quotation_id", "offer_id", "booking_party_rate_id", "origin_country_id",
		"origin_trade_lane_id", "origin_continent_id", "destination_country_id", "destination_trade_lane_id",
		"destination_continent_id", "cfs_address", "shipper_address", "stuffing_address", "consignee_address",
		"cfs_location_id", "shipper_location_id", "stuffing_location_id", "consignee_location_id", "provider",
		"haulage_weight_slab", "stuffing_type", "sales_owner_id", "engagement_owner_id", "operations_owner_id",
		"booking_desk_owner_id", "freight_discount_id", "delivery_feedback_received", "shipping_line_change_requested",
		"shipping_line_change_request_id", "shipper_address_details", "consignee_details", "imports_consignee_address",
		"sail_schedule_details", "transit_time", "from_email", "shipment_value", "shipment_currency",
		"invoicing_currency", "expected_booking_note_issue_date", "sku_number", "is_open_examination_marked",
		"booking_internal_process_start_date", "booking_received_at", "confirmed_by_shipper_at", "booking_accepted_at",
		"share_request", "is_bl_couriered", "bl_courier_company_name", "bl_courier_tracking_id",
		"europe_inter_modal_mode", "origin_detention", "destination_detention", "destination_demmurage",
		"plugin_day_origin", "plugin_day_destination", "detention_day_origin", "detention_day_destination",
		"demurage_day_destination", "containers_pickup_date", "container_weight_limit", "weight_slab",
		"weight_slab_unit", "temperature_slab", "temperature_slab_unit", "temperature", "vent_setting", "ventilation",
		"ventilation_unit", "humidity", "humidity_unit", "length", "width", "height", "dimension_unit",
		"container_pickup_activity", "container_gate_in_activity", "container_linking_activity", "bl_activity",
		"ingauge", "manual", "remarks", "enquiry_comments", "importer_exporter_info_id", "consignee_id",
		"is_supplier_assigned", "income_pending", "expense_pending", "vgm_selected", "lock_quotation",
		"margin_percentage", "buyer_markups", "invoices_ccr", "is_cancellation_requested",
		"cancellation_requested_reason", "cancellation_reason", "cancellation_sub_reason",
		"cancellation_responsible_party", "cancelled_by", "replacement_shipment_id", "abort_reason",
		"cancellation_summary", "cancelled_with_revenue_loss", "cancellation_approved_by_admin",
		"cancellation_assessment_status", "is_cancellation_reason_updated", "booking_turnaround_time", "etd_deviation",
		"transit_time_deviation", "b_l_release_time", "billing_accuracy", "logistics_cost_to_fob",
		"expense_billing_accuracy", "loyalty_program_applicable", "is_store_transfer_done", "deduct_loyalty_points",
		"loyalty_points_redeem_type", "loyalty_points_max_redeem_locked", "loyalty_points_initially_redeemed",
		"loyalty_point_redemption_data", "loyalty_points_earning_breakup", "loyalty_points_actual_spending",
		"loyalty_points_locked", "is_supplier_team_approved", "supplier_team_approved_at",
		"supplier_negotiation_initiated", "email_log_ids", "is_confirmed_by_shipper", "quotation_confirmed_at",
		"bl_release", "expected_shipment_date", "actual_time_of_departure", "expected_arrival_date",
		"actual_arrival_date", "completed_at", "cancelled_at", "aborted_at", "branch_id", "freight_discount_hash",
		"promocode_discount_per_container", "freight_search_discount_markup", "google_event_id", "device",
		"operating_system", "browser", "is_draft_expired", "draft_expiry_at", "active_escalations_count",
		"payment_options_snapshot", "office_country_code", "booking_ref_number", "is_nostro_charge_applicable",
		"search_requirement_id", "cogo_scheduled_automation_element_index", "cogo_email_recipient_id",
		"cogo_email_template_id", "cogo_scheduled_automation_id", "utm_source", "utm_medium", "utm_campaign",
		"cogo_email", "cogo_token", "cogo_org_user_id", "cogo_lead_id", "cogo_assisted_by_id", "created_at",
		"updated_at", "mongo_id" })

public class ShipmentOrderConsumerModel extends AppConsumerModel {

	@JsonProperty("id")
	private String id;
	@JsonProperty("inc_id")
	private Integer incId;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("grouped_commodity")
	private String groupedCommodity;
	@JsonProperty("hazardous_type")
	private String hazardousType;
	@JsonProperty("commodity")
	private String commodity;
	@JsonProperty("container_size")
	private String containerSize;
	@JsonProperty("container_type")
	private String containerType;

}