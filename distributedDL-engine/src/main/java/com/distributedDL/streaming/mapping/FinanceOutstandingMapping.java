package com.distributedDL.streaming.mapping;

import java.util.HashMap;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.models.consumer.FinanceInvoicesConsumerModel;
import com.distributedDL.streaming.models.consumer.OrganizationOrganizationsConsumerModel;
import com.distributedDL.streaming.models.producer.FinanceOutstandingProducerModel;

@SuppressWarnings("serial")
public class FinanceOutstandingMapping extends AppMapping<FinanceInvoicesConsumerModel, FinanceOutstandingProducerModel>{
	
	public FinanceOutstandingMapping(HashMap<String, RocksDbCache> cMap) {
		cacheMap = cMap;
	}

	@Override
	public FinanceOutstandingProducerModel mapping(FinanceInvoicesConsumerModel financeInvoicesConsumerModel, FinanceOutstandingProducerModel financeOutstandingProducerModel) {
		OrganizationOrganizationsConsumerModel organizationOrganizationsConsumerModel = (OrganizationOrganizationsConsumerModel) cacheMap.get(CommonConstants.ORGANIZATION_ORGANIZATIONS_CACHE).get(financeInvoicesConsumerModel.getBuyerId());
		
		financeOutstandingProducerModel.setBusinessName(organizationOrganizationsConsumerModel.getBusinessName());
		
		financeOutstandingProducerModel.setDueDate(financeInvoicesConsumerModel.getDueDate());
		financeOutstandingProducerModel.setInrTotalDueAmount(financeInvoicesConsumerModel.getInrTotalDueAmount());
		financeOutstandingProducerModel.setInvoiceType(financeInvoicesConsumerModel.getInvoiceType());
		financeOutstandingProducerModel.setStatus(financeInvoicesConsumerModel.getStatus());
		
		return financeOutstandingProducerModel;
	}

}
