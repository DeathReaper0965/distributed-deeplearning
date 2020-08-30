package com.distributedDL.streaming.table.schema;

import com.distributedDL.streaming.common.CommonConstants;

public class TableSchemaGenerator extends AppTableSchemaGenerator{
	
	public void startGeneratingSchemas() {
		
//		Finance Jobs
		this.addJob(new TableSchema(CommonConstants.FINANCE_DB, CommonConstants.FINANCE_INVOICES_TABLE));
		this.addJob(new TableSchema(CommonConstants.FINANCE_DB, CommonConstants.FINANCE_PAYMENT_TRANSACTIONS_TABLE));
		this.addJob(new TableSchema(CommonConstants.FINANCE_DB, CommonConstants.FINANCE_INVOICE_TRANSACTIONS_TABLE));
		this.addJob(new TableSchema(CommonConstants.FINANCE_DB, CommonConstants.FINANCE_INVOICE_DOCUMENTS_TABLE));
		this.addJob(new TableSchema(CommonConstants.FINANCE_DB, CommonConstants.FINANCE_INVOICE_LINE_ITEMS_TABLE));
		
//		Location Job
		this.addJob(new TableSchema(CommonConstants.LOCATION_DB, CommonConstants.LOCATION_LOCATIONS_TABLE));
		
//		Shipment Jobs
		this.addJob(new TableSchema(CommonConstants.SHIPMENT_DB, CommonConstants.SHIPMENT_ORDERS_TABLE));
		this.addJob(new TableSchema(CommonConstants.SHIPMENT_DB, CommonConstants.SHIPMENT_QUOTATIONS_TABLE));
		this.addJob(new TableSchema(CommonConstants.SHIPMENT_DB, CommonConstants.SHIPMENT_PAYMENT_METHODS_TABLE));
		this.addJob(new TableSchema(CommonConstants.SHIPMENT_DB, CommonConstants.SHIPMENT_BL_DETAILS_TABLE));
		this.addJob(new TableSchema(CommonConstants.SHIPMENT_DB, CommonConstants.SHIPMENT_BOOKING_DETAILS_TABLE));
		this.addJob(new TableSchema(CommonConstants.SHIPMENT_DB, CommonConstants.SHIPMENT_BOOKING_NUMBERS_TABLE));
		this.addJob(new TableSchema(CommonConstants.SHIPMENT_DB, CommonConstants.SHIPMENT_DOCUMENTS_TABLE));
		
//		Organization Jobs
		this.addJob(new TableSchema(CommonConstants.ORGANIZATION_DB, CommonConstants.ORGANIZATION_ORGANIZATIONS_TABLE));
		this.addJob(new TableSchema(CommonConstants.ORGANIZATION_DB, CommonConstants.ORGANIZATION_ORGANIZATION_USERS_TABLE));
		this.addJob(new TableSchema(CommonConstants.ORGANIZATION_DB, CommonConstants.ORGANIZATION_USERS_TABLE));
		this.addJob(new TableSchema(CommonConstants.ORGANIZATION_DB, CommonConstants.ORGANIZATION_SERVICE_PROVIDER_FTL_TRANSPORT_SERVICES_TABLE));
		this.addJob(new TableSchema(CommonConstants.ORGANIZATION_DB, CommonConstants.ORGANIZATION_SERVICE_PROVIDER_SERVICE_PROFILES_TABLE));
		
//		Data Mapping Jobs
		this.addJob(new TableSchema(CommonConstants.DATA_MAPPING_DB, CommonConstants.DATA_MAPPING_SHIPPING_LINES_TABLE));
		this.addJob(new TableSchema(CommonConstants.DATA_MAPPING_DB, CommonConstants.DATA_MAPPING_CURRRENCY_CONVERSIONS_TABLE));
		this.addJob(new TableSchema(CommonConstants.DATA_MAPPING_DB, CommonConstants.DATA_MAPPING_CURRRENCY_CONVERSION_HISTORICAL_VALUES_TABLE));
		
//		FCL Rate Jobs
		this.addJob(new TableSchema(CommonConstants.FCL_RATE_DB, CommonConstants.FCL_RATE_FREIGHT_CHARGES_TABLE));
		
//		Search Jobs
		this.addJob(new TableSchema(CommonConstants.SEARCH_DB, CommonConstants.SEARCH_SPOT_SEARCHES_TABLE));
		this.addJob(new TableSchema(CommonConstants.SEARCH_DB, CommonConstants.SEARCH_ESTIMATED_FREIGHT_SEARCHES_TABLE));
		
//		Transport Rate Jobs
		this.addJob(new TableSchema(CommonConstants.TRANSPORT_RATE_DB, CommonConstants.TRANSPORT_RATE_TRUCK_CHARGES_TABLE));
		this.addJob(new TableSchema(CommonConstants.TRANSPORT_RATE_DB, CommonConstants.TRANSPORT_RATE_TRUCK_CHARGE_CHARGES_TABLE));
		
//		Xeneta Jobs
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_CORRIDOR_AGGREGATE_PRICES_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_CORRIDOR_AGGREGATE_REQUESTS_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_CORRIDOR_PRICE_REQUESTS_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_CORRIDOR_PRICES_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_CORRIDORS_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_GEO_HIERARCHIES_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_LANE_AGGREGATE_PRICES_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_LANE_AGGREGATE_REQUESTS_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_MIXED_LOC_AGGR_PRICES_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_MIXED_LOC_AGGR_REQUESTS_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_REGIONS_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_UNLOC_CODES_TABLE));
		this.addJob(new TableSchema(CommonConstants.XENETA_DB, CommonConstants.XENETA_SERVICE_UNLOCODE_DUMPS_TABLE));
		
		
		this.executeJobs();
	}
	
}
