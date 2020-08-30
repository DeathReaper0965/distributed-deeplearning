package com.distributedDL.streaming.common;

public class CommonConstants {
	
//  Shipments DB Constants
	public final static String SHIPMENT_DB = "shipment"; 
	public final static String SHIPMENT_DEBEZIUM_SERVER = "SHIPMENT_SERVER"; 
	public final static String SHIPMENT_CONSUMER_GROUP = "shipments_group";
	public final static String SHIPMENT_ORDERS_TABLE = "shipment_orders";
	public final static String SHIPMENT_QUOTATIONS_TABLE = "shipment_quotations";
	public final static String SHIPMENT_PAYMENT_METHODS_TABLE = "shipment_payment_methods";
	public final static String SHIPMENT_BL_DETAILS_TABLE = "shipment_bl_details";
	public final static String SHIPMENT_DOCUMENTS_TABLE = "shipment_documents";
	public final static String SHIPMENT_ORDER_CACHE = "shipment_order_cache";
	public final static String SHIPMENT_BOOKING_DETAILS_TABLE = "shipment_booking_details";
	public final static String SHIPMENT_BOOKING_NUMBERS_TABLE = "shipment_booking_numbers";
	
//  Mongo Dump DB Constants
	public final static String MONGO_DUMP_DB = "mongo_dump";
	public final static String MONGO_DUMP_DEBEZIUM_SERVER = "MONGO_DUMP_SERVER";
	public final static String MONGO_DUMP_CONSUMER_GROUP = "mongo_dump_group";
	public final static String ACTIVITY_LOGS_TABLE = "pg_acitivitylogs";
	public final static String ORGANIZATIONS_TABLE = "pg_organizations";
	public final static String ORGANIZATIONS_USERS_TABLE = "pg_organizations_users";
	public final static String ADMINS_TABLE = "pg_admins";
	public final static String ACTIVITY_LOGS_BUCKETS_TABLE = "pg_acitivity_logs_buckets";
	public final static String ACTIVITY_LOGS_TAGS_TABLE = "pg_acitivity_logs_tags";
	public final static String ORGANIZATIONS_USERS_CACHE = "organizations_users_cache";
	public final static String ORGANIZATIONS_CACHE = "organizations_cache";
	public final static String ADMINS_CACHE = "admins_cache";
	public final static String ACTIVITY_LOGS_BUCKETS_CACHE = "activity_logs_buckets_cache";
	public final static String ACTIVITY_LOGS_TAGS_CACHE = "activity_logs_tags_cache";
	public final static String ACTIVITY_LOGS_CACHE = "activity_logs_cache";
	
//	Finance DB Constants
	public final static String FINANCE_DB = "finance";
	public final static String FINANCE_DEBEZIUM_SERVER = "FINANCE_SERVER";
	public final static String FINANCE_CONSUMER_GROUP = "finance_group";
	public final static String FINANCE_INVOICES_TABLE = "finance_invoices";
	public final static String FINANCE_INVOICE_DOCUMENTS_TABLE = "finance_invoice_documents";
	public final static String FINANCE_PAYMENT_TRANSACTIONS_TABLE = "finance_payment_transactions";
	public final static String FINANCE_INVOICE_TRANSACTIONS_TABLE = "finance_invoice_transactions";
	public final static String FINANCE_INVOICE_LINE_ITEMS_TABLE = "finance_invoice_line_items";
	
//	distributedDL API PG Constants
	public final static String distributedDL_API_DB = "api_pg";
	public final static String distributedDL_API_DEBEZIUM_SERVER = "API_PG_SERVER";
	public final static String distributedDL_API_CONSUMER_GROUP = "ticket_group";
	public final static String TICKET_ESCALATION_REASONS_TABLE = "ticket_escalation_reasons";
	
//	Location DB Constants
	public final static String LOCATION_DB = "location";
	public final static String LOCATION_DEBEZIUM_SERVER = "LOCATION_SERVER";
	public final static String LOCATION_CONSUMER_GROUP = "location_group";
	public final static String LOCATION_LOCATIONS_TABLE = "location_locations";
	public final static String LOCATION_LOCATIONS_CACHE = "location_locations_cache";
	
//	Organization DB Constants
	public final static String ORGANIZATION_DB = "organization";
	public final static String ORGANIZATION_ORGANIZATIONS_TABLE = "organization_organizations";
	public final static String ORGANIZATION_ORGANIZATION_USERS_TABLE = "organization_organization_users";
	public final static String ORGANIZATION_ORGANIZATIONS_CACHE = "organization_organizations_cache";
	public final static String ORGANIZATION_ORGANIZATIONS_USERS_CACHE = "organization_organization_users_cache";
	public final static String ORGANIZATION_USERS_TABLE = "organization_users";
	public final static String ORGANIZATION_SERVICE_PROVIDER_FTL_TRANSPORT_SERVICES_TABLE = "organization_service_provider_ftl_transport_services";
	public final static String ORGANIZATION_SERVICE_PROVIDER_SERVICE_PROFILES_TABLE = "organization_service_provider_service_profiles";
	
//	Data Mapping DB Constants
	public final static String DATA_MAPPING_DB = "data_mapping_pg";
	public final static String DATA_MAPPING_SHIPPING_LINES_TABLE = "data_mapping_shipping_lines";
	public final static String DATA_MAPPING_CURRRENCY_CONVERSIONS_TABLE = "data_mapping_currency_conversions";
	public final static String DATA_MAPPING_CURRRENCY_CONVERSION_HISTORICAL_VALUES_TABLE= "data_mapping_currency_conversion_historical_values";
	
//	FCL Rate DB Constants
	public final static String FCL_RATE_DB= "fcl_rate";
	public final static String FCL_RATE_FREIGHT_CHARGES_TABLE = "fcl_rate_freight_charges";
	
//	Search DB Constants
	public final static String SEARCH_DB = "search";
	public final static String SEARCH_SPOT_SEARCHES_TABLE = "search_spot_searches";
	public final static String SEARCH_ESTIMATED_FREIGHT_SEARCHES_TABLE = "search_estimated_freight_searches";
	
//	Transport Rate Constants
	public final static String TRANSPORT_RATE_DB = "transport";
	public final static String TRANSPORT_RATE_TRUCK_CHARGES_TABLE = "transportation_rate_truck_charges";
	public final static String TRANSPORT_RATE_TRUCK_CHARGE_CHARGES_TABLE= "transportation_rate_truck_charge_charges";
	
//	Xeneta Constants
	public final static String XENETA_DB = "xeneta";
	public final static String XENETA_SERVICE_CORRIDOR_AGGREGATE_PRICES_TABLE = "xeneta_service_corridor_aggregate_prices";
	public final static String XENETA_SERVICE_CORRIDOR_AGGREGATE_REQUESTS_TABLE = "xeneta_service_corridor_aggregate_requests";
	public final static String XENETA_SERVICE_CORRIDOR_PRICE_REQUESTS_TABLE = "xeneta_service_corridor_price_requests";
	public final static String XENETA_SERVICE_CORRIDOR_PRICES_TABLE = "xeneta_service_corridor_prices";
	public final static String XENETA_SERVICE_CORRIDORS_TABLE = "xeneta_service_corridors";
	public final static String XENETA_SERVICE_GEO_HIERARCHIES_TABLE = "xeneta_service_geo_hierarchies";
	public final static String XENETA_SERVICE_LANE_AGGREGATE_PRICES_TABLE = "xeneta_service_lane_aggregate_prices";
	public final static String XENETA_SERVICE_LANE_AGGREGATE_REQUESTS_TABLE = "xeneta_service_lane_aggregate_requests";
	public final static String XENETA_SERVICE_MIXED_LOC_AGGR_PRICES_TABLE = "xeneta_service_mixed_loc_aggr_prices";
	public final static String XENETA_SERVICE_MIXED_LOC_AGGR_REQUESTS_TABLE = "xeneta_service_mixed_loc_aggr_requests";
	public final static String XENETA_SERVICE_REGIONS_TABLE = "xeneta_service_regions";
	public final static String XENETA_SERVICE_UNLOC_CODES_TABLE = "xeneta_service_unloc_codes";
	public final static String XENETA_SERVICE_UNLOCODE_DUMPS_TABLE = "xeneta_service_unlocode_dumps";

//	Multi-Streaming Constants
	public final static String COMBINED_SHIPMENT_BL = "combined_stream_bl";
	public final static String FINANCE_ORGANIZATIONS = "finance_organizations";
	public final static String OUTSTANDING = "outstanding";
	public final static String COMBINED_STREAM = "combined_stream";
	public final static String COMBINED_STREAM_SERVER = "STREAM_COMBINED_SERVER";
	public final static String COMBINED_STREAM_GROUP = "combined_stream_group00";
	public final static String COMBINED_CACHE_DIR = "combined_cache";
	public final static String FIN_SO_COMBINED = "fin_so_combined";
	
//	DRUID Constants
	public final static String SUPERVISOR_SUSPENDED = "supervisor_suspended";
	public final static String DATA_SCHEMA = "dataSchema";
	public final static String DATA_SOURCE = "dataSource";
	public final static String SUSPENDED = "suspended";
	public final static String PAYLOAD = "payload";
	public final static String ACTIVE_TASKS = "activeTasks";
	public final static String STATUS_ENDPOINT = "/status";
	public final static String SHUTDOWN_ENDPOINT = "/shutdown";
	public final static String SUPERVISOR_NOT_FOUND = "supervisor_not_found";
	public final static String UNABLE_TO_TERMINATE = "unable_to_terminate";
	public final static String UNABLE_TO_SUBMIT = "unable_to_submit";
	public final static String SUBMIT_SUCCESS = "submit_success";
	public final static String SUPERVISOR_STATE = "state";
	
//	Constants
	public final static String CONSUMER_PACKAGE_NAME = "com.distributedDL.streaming.models.consumer";
	public final static String STREAM = "stream";
	public final static int DEFAULT_PARALLELISM = 3;
	public final static String FILE_MISSING = "file_missing";
	
}
