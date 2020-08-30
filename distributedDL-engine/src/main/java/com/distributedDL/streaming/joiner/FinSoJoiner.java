package com.distributedDL.streaming.joiner;

import java.util.HashMap;

import org.apache.flink.util.Collector;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;
import com.distributedDL.streaming.models.consumer.FinanceInvoicesConsumerModel;
import com.distributedDL.streaming.models.consumer.LocationLocationsConsumerModel;
import com.distributedDL.streaming.models.consumer.OrganizationOrganizationUsersConsumerModel;
import com.distributedDL.streaming.models.consumer.OrganizationOrganizationsConsumerModel;
import com.distributedDL.streaming.models.consumer.ShipmentOrdersConsumerModel;
import com.distributedDL.streaming.models.producer.FinSoProducerModel;

@SuppressWarnings({"serial", "static-access"})
public class FinSoJoiner extends AppJoiner<ChangeDataConsumerModel, ChangeDataConsumerModel, FinSoProducerModel>{

	public FinSoJoiner(HashMap<String, RocksDbCache> cMap) {
		super(cMap);
	}

	@Override
	public void flatMap1(ChangeDataConsumerModel xModel, Collector<FinSoProducerModel> out) throws Exception {

		ChangeDataConsumerModel soStateValue = this.getYState().value();
		FinSoProducerModel finSoProducerValue = this.getZState().value();
		
		if (finSoProducerValue == null) {
			finSoProducerValue = new FinSoProducerModel();
		}
		
		FinanceInvoicesConsumerModel finConModel = (FinanceInvoicesConsumerModel) CommonUtils.getObjectMapper().convertValue(xModel.getAfter(), FinanceInvoicesConsumerModel.class);
		
		finSoProducerValue.setFinId(finConModel.getId());
		finSoProducerValue.setFinIncId(finConModel.getIncId());
		finSoProducerValue.setSellerId(finConModel.getSellerId());
		finSoProducerValue.setBuyerId(finConModel.getBuyerId());
		finSoProducerValue.setShipmentId(finConModel.getShipmentId());
		finSoProducerValue.setPlaceOfSupplyId(finConModel.getPlaceOfSupplyId());
		finSoProducerValue.setUpdatedById(finConModel.getUpdatedById());
		finSoProducerValue.setOriginId(finConModel.getOriginId());
		finSoProducerValue.setDestinationId(finConModel.getDestinationId());
		finSoProducerValue.setOrganizationId(finConModel.getOrganizationId());
		finSoProducerValue.setInvoiceType(finConModel.getInvoiceType());
		finSoProducerValue.setSubType(finConModel.getSubType());
		finSoProducerValue.setSellerType(finConModel.getSellerType());
		finSoProducerValue.setDueDate(finConModel.getDueDate());
		finSoProducerValue.setInvoiceDate(finConModel.getInvoiceDate());
		finSoProducerValue.setInvoiceNo(finConModel.invoiceNo);
		finSoProducerValue.setRefInvoiceNo(finConModel.getRefInvoiceNo());
		finSoProducerValue.setFinStatus(finConModel.getStatus());
		finSoProducerValue.setSubTotal(finConModel.getSubTotal());
		finSoProducerValue.setNetTotal(finConModel.getNetTotal());
		finSoProducerValue.setTotalTax(finConModel.getTotalTax());
		finSoProducerValue.setComments(finConModel.getComments());
		finSoProducerValue.setCurrency(finConModel.getCurrency());
		finSoProducerValue.setStatusChanges(finConModel.getStatusChanges());
		finSoProducerValue.setCurrencyConversionRate(finConModel.getCurrencyConversionRate());
		finSoProducerValue.setInvoiceFile(finConModel.getInvoiceFile());
		finSoProducerValue.setDueAmount(finConModel.getDueAmount());
		finSoProducerValue.setTds(finConModel.getTds());
		finSoProducerValue.setTdsValue(finConModel.getTdsValue());
		finSoProducerValue.setTdsAmount(finConModel.getTdsAmount());
		finSoProducerValue.setMasterTransactions(finConModel.masterTransactions);
		finSoProducerValue.setIncomes(finConModel.incomes);
		finSoProducerValue.setExpenses(finConModel.expenses);
		finSoProducerValue.setInvoiceMessage(finConModel.getInvoiceMessage());
		finSoProducerValue.setGst(finConModel.getGst());
		finSoProducerValue.setTerms(finConModel.getTerms());
		finSoProducerValue.setUrl(finConModel.getUrl());
		finSoProducerValue.setBlNumber(finConModel.getBlNumber());
		finSoProducerValue.setContainerNo(finConModel.getContainerNo());
		finSoProducerValue.setMailSent(finConModel.getMailSent());
		finSoProducerValue.setAlert(finConModel.getAlert());
		finSoProducerValue.setExpensePending(finConModel.getExpensePending());
		finSoProducerValue.setCombinedInvoice(finConModel.getCombinedInvoice());
		finSoProducerValue.setVendorInvoiceDate(finConModel.getVendorInvoiceDate());
		finSoProducerValue.setVendorInvoiceAmount(finConModel.getVendorInvoiceAmount());
		finSoProducerValue.setQuickbookMigration(finConModel.getQuickbookMigration());
		finSoProducerValue.setBranchId(finConModel.getBranchId());
		finSoProducerValue.setInrNetTotal(finConModel.getInrNetTotal());
		finSoProducerValue.setInrSubTotal(finConModel.getInrSubTotal());
		finSoProducerValue.setInrTotalTax(finConModel.getInrTotalTax());
		finSoProducerValue.setInrTotalDiscount(finConModel.getInrTotalDiscount());
		finSoProducerValue.setInrTotalDueAmount(finConModel.getInrTotalDueAmount());
		finSoProducerValue.setTdsMark(finConModel.getTdsMark());
		finSoProducerValue.setSailingDate(finConModel.getSailingDate());
		finSoProducerValue.setUnregistered(finConModel.getUnregistered());
		finSoProducerValue.setOfficeCountryCode(finConModel.getOfficeCountryCode());
		finSoProducerValue.setFinCreatedAt(finConModel.getCreatedAt());
		finSoProducerValue.setFinUpdatedAt(finConModel.getUpdatedAt());
		finSoProducerValue.setMongoId(finConModel.getMongoId());
		finSoProducerValue.setPromocodes(finConModel.getPromocodes());
		finSoProducerValue.setCreditNoteRedemption(finConModel.getCreditNoteRedemption());
		finSoProducerValue.setCreditNoteReconciliation(finConModel.getCreditNoteReconciliation());
		finSoProducerValue.setTdsType(finConModel.getTdsType());
		finSoProducerValue.setNegativeFreightAllowed(finConModel.getNegativeFreightAllowed());
		finSoProducerValue.setIsDigioSigned(finConModel.getIsDigioSigned());
		finSoProducerValue.setCommissionRate(finConModel.getCommissionRate());
		finSoProducerValue.setCommissionInvoiceId(finConModel.getCommissionInvoiceId());
		finSoProducerValue.setOrganizationUserId(finConModel.getOrganizationUserId());
		finSoProducerValue.setNbfcId(finConModel.getNbfcId());
		
		finSoProducerValue.setCreatedAt(CommonUtils.convertUnixTimeStampToDate(xModel.getTsMs()));
		
		if (finConModel.getOrganizationId() != null) {
			OrganizationOrganizationsConsumerModel ooConsumerModel = (OrganizationOrganizationsConsumerModel) cacheMap.get(CommonConstants.ORGANIZATION_ORGANIZATIONS_CACHE).get(finConModel.getOrganizationId());
			
			finSoProducerValue.setOoId(ooConsumerModel.getId());
			finSoProducerValue.setSerialId(ooConsumerModel.getSerialId());
			finSoProducerValue.setBusinessName(ooConsumerModel.getBusinessName());
			finSoProducerValue.setShortName(ooConsumerModel.getShortName());
			finSoProducerValue.setAbout(ooConsumerModel.getAbout());
			finSoProducerValue.setAccountType(ooConsumerModel.getAccountType());
			finSoProducerValue.setWebsite(ooConsumerModel.getWebsite());
			finSoProducerValue.setLogo(ooConsumerModel.getLogo());
			finSoProducerValue.setOoStatus(ooConsumerModel.getStatus());
			finSoProducerValue.setOoMongoId(ooConsumerModel.getMongoId());
			finSoProducerValue.setOoCreatedAt(ooConsumerModel.getCreatedAt());
			finSoProducerValue.setOoUpdatedAt(ooConsumerModel.getUpdatedAt());
			
		}
		
		if (finConModel.getOrganizationUserId() != null) {
			OrganizationOrganizationUsersConsumerModel oouConsumerModel = (OrganizationOrganizationUsersConsumerModel) cacheMap.get(CommonConstants.ORGANIZATION_ORGANIZATIONS_USERS_CACHE).get(finConModel.getOrganizationUserId());
			
			finSoProducerValue.setOouId(oouConsumerModel.getId());
			finSoProducerValue.setOouOrganizationId(oouConsumerModel.getOrganizationId());
			finSoProducerValue.setUserId(oouConsumerModel.getUserId());
			finSoProducerValue.setOouStatus(oouConsumerModel.getStatus());
			finSoProducerValue.setDesignation(oouConsumerModel.getDesignation());
			finSoProducerValue.setMongoIds(oouConsumerModel.mongoIds);
			finSoProducerValue.setOouCreatedAt(oouConsumerModel.getCreatedAt());
			finSoProducerValue.setOouUpdatedAt(oouConsumerModel.getUpdatedAt());
			
		}
		
		
		if (soStateValue != null) {
			this.cleanAllStates();
			out.collect(finSoProducerValue);
		}
		else {
			this.getXState().update(xModel);
			this.getZState().update(finSoProducerValue);
		}
		
	}

	@Override
	public void flatMap2(ChangeDataConsumerModel yModel, Collector<FinSoProducerModel> out) throws Exception {
		
		ChangeDataConsumerModel finStateValue = this.getXState().value();
		FinSoProducerModel finSoProducerValue = this.getZState().value();
		
		if (finSoProducerValue == null) {
			finSoProducerValue = new FinSoProducerModel();
		}
		
		ShipmentOrdersConsumerModel shiOrdModel = (ShipmentOrdersConsumerModel) CommonUtils.getObjectMapper().convertValue(yModel.getAfter(), ShipmentOrdersConsumerModel.class);
		
		finSoProducerValue.setShiOrdId(shiOrdModel.getId());
		finSoProducerValue.setShiOrdIncId(shiOrdModel.getIncId());
		finSoProducerValue.setQuantity(shiOrdModel.getQuantity());
		finSoProducerValue.setGroupedCommodity(shiOrdModel.getGroupedCommodity());
		finSoProducerValue.setHazardousType(shiOrdModel.getHazardousType());
		finSoProducerValue.setCommodity(shiOrdModel.getCommodity());
		finSoProducerValue.setContainerSize(shiOrdModel.getContainerSize());
		finSoProducerValue.setContainerType(shiOrdModel.getContainerType());
		finSoProducerValue.setTradeType(shiOrdModel.getTradeType());
		finSoProducerValue.setBlCount(shiOrdModel.getBlCount());
		finSoProducerValue.setBlType(shiOrdModel.getBlType());
		finSoProducerValue.setBlDeliveryMode(shiOrdModel.getBlDeliveryMode());
		finSoProducerValue.setShippingLineId(shiOrdModel.getShippingLineId());
		finSoProducerValue.setOriginMainPortId(shiOrdModel.getOriginMainPortId());
		finSoProducerValue.setDestinationMainPortId(shiOrdModel.getDestinationMainPortId());
		finSoProducerValue.setOriginPortId(shiOrdModel.getOriginPortId());
		finSoProducerValue.setDestinationPortId(shiOrdModel.getDestinationPortId());
		finSoProducerValue.setShiOrdOrganizationUserId(shiOrdModel.getOrganizationUserId());
		finSoProducerValue.setFreightForwarderId(shiOrdModel.getFreightForwarderId());
		finSoProducerValue.setInitialFreightForwarderId(shiOrdModel.getInitialFreightForwarderId());
		finSoProducerValue.setPrevCurrentBdId(shiOrdModel.getPrevCurrentBdId());
		finSoProducerValue.setCurrentBookingDetailId(shiOrdModel.getCurrentBookingDetailId());
		finSoProducerValue.setPrevCurrentDodId(shiOrdModel.getPrevCurrentDodId());
		finSoProducerValue.setCurrentDoDetailId(shiOrdModel.getCurrentDoDetailId());
		finSoProducerValue.setShiOrdStatusChanges(shiOrdModel.getStatusChanges());
		finSoProducerValue.setMode(shiOrdModel.getMode());
		finSoProducerValue.setIsLcl(shiOrdModel.getIsLcl());
		finSoProducerValue.setSource(shiOrdModel.getSource());
		finSoProducerValue.setCustomerRefNumber(shiOrdModel.getCustomerRefNumber());
		finSoProducerValue.setSellerRefNumber(shiOrdModel.getSellerRefNumber());
		finSoProducerValue.setIsAdvanceShipment(shiOrdModel.getIsAdvanceShipment());
		finSoProducerValue.setIncoTerm(shiOrdModel.getIncoTerm());
		finSoProducerValue.setShiOrdStatus(shiOrdModel.getStatus());
		finSoProducerValue.setPreStatus(shiOrdModel.getPreStatus());
		finSoProducerValue.setBookingDetailStatus(shiOrdModel.getBookingDetailStatus());
		finSoProducerValue.setDoStatus(shiOrdModel.getDoStatus());
		finSoProducerValue.setLastActivityForSeller(shiOrdModel.getLastActivityForSeller());
		finSoProducerValue.setStatusMilestones(shiOrdModel.getStatus());
		finSoProducerValue.setStatusMilestonesHash(shiOrdModel.getStatusMilestonesHash());
		finSoProducerValue.setBookingNo(shiOrdModel.bookingNo);
		finSoProducerValue.setBlNo(shiOrdModel.blNo);
		finSoProducerValue.setDeliveryOrderNo(shiOrdModel.deliveryOrderNo);
		finSoProducerValue.setAssistedById(shiOrdModel.getAssistedById());
		finSoProducerValue.setQuotationVerifiedById(shiOrdModel.getQuotationVerifiedById());
		finSoProducerValue.setQuotationConfirmedById(shiOrdModel.getQuotationConfirmedById());
		finSoProducerValue.setDuplicatedFromId(shiOrdModel.getDuplicatedFromId());
		finSoProducerValue.setDuplicatedAt(shiOrdModel.getDuplicatedAt());
		finSoProducerValue.setDuplicatedTillStage(shiOrdModel.getDuplicatedTillStage());
		finSoProducerValue.setDuplicatedShipmentIncIds(shiOrdModel.duplicatedShipmentIncIds);
		finSoProducerValue.setIsFreightos(shiOrdModel.getIsFreightos());
		finSoProducerValue.setIsBookedDuringFlashSale(shiOrdModel.getIsBookedDuringFlashSale());
		finSoProducerValue.setBookedThroughExim(shiOrdModel.getBookedThroughExim());
		finSoProducerValue.setThirdPartyShipperId(shiOrdModel.getThirdPartyShipperId());
		finSoProducerValue.setSearchId(shiOrdModel.getSearchId());
		finSoProducerValue.setFclFreightChargeId(shiOrdModel.getFclFreightChargeId());
		finSoProducerValue.setCfsChargeId(shiOrdModel.getCfsChargeId());
		finSoProducerValue.setHaulageChargeId(shiOrdModel.getHaulageChargeId());
		finSoProducerValue.setIcdChargeId(shiOrdModel.getIcdChargeId());
		finSoProducerValue.setRequestQuoteQuotationId(shiOrdModel.getRequestQuoteQuotationId());
		finSoProducerValue.setContractedRateQuoteQuotationId(shiOrdModel.getContractedRateQuoteQuotationId());
		finSoProducerValue.setOfferId(shiOrdModel.getOfferId());
		finSoProducerValue.setBookingPartyRateId(shiOrdModel.getBookingPartyRateId());
		finSoProducerValue.setOriginCountryId(shiOrdModel.getOriginCountryId());
		finSoProducerValue.setOriginTradeLaneId(shiOrdModel.getOriginTradeLaneId());
		finSoProducerValue.setOriginContinentId(shiOrdModel.getOriginContinentId());
		finSoProducerValue.setDestinationCountryId(shiOrdModel.getDestinationCountryId());
		finSoProducerValue.setDestinationTradeLaneId(shiOrdModel.getDestinationTradeLaneId());
		finSoProducerValue.setDestinationContinentId(shiOrdModel.getDestinationContinentId());
		finSoProducerValue.setCfsAddress(shiOrdModel.getCfsAddress());
		finSoProducerValue.setShipperAddress(shiOrdModel.getShipperAddress());
		finSoProducerValue.setStuffingAddress(shiOrdModel.getStuffingAddress());
		finSoProducerValue.setConsigneeAddress(shiOrdModel.getConsigneeAddress());
		finSoProducerValue.setCfsLocationId(shiOrdModel.getCfsLocationId());
		finSoProducerValue.setShipperLocationId(shiOrdModel.getShipperLocationId());
		finSoProducerValue.setStuffingLocationId(shiOrdModel.getStuffingLocationId());
		finSoProducerValue.setConsigneeLocationId(shiOrdModel.getConsigneeLocationId());
		finSoProducerValue.setProvider(shiOrdModel.getProvider());
		finSoProducerValue.setHaulageWeightSlab(shiOrdModel.getHaulageWeightSlab());
		finSoProducerValue.setStuffingType(shiOrdModel.getStuffingType());
		finSoProducerValue.setSalesOwnerId(shiOrdModel.getSalesOwnerId());
		finSoProducerValue.setEngagementOwnerId(shiOrdModel.getEngagementOwnerId());
		finSoProducerValue.setOperationsOwnerId(shiOrdModel.getOperationsOwnerId());
		finSoProducerValue.setBookingDeskOwnerId(shiOrdModel.getBookingDeskOwnerId());
		finSoProducerValue.setFreightDiscountId(shiOrdModel.getFreightDiscountId());
		finSoProducerValue.setDeliveryFeedbackReceived(shiOrdModel.getDeliveryFeedbackReceived());
		finSoProducerValue.setFreightResult(shiOrdModel.getFreightResult());
		finSoProducerValue.setShippingLineChangeRequested(shiOrdModel.getShippingLineChangeRequested());
		finSoProducerValue.setShippingLineChangeRequestId(shiOrdModel.getShippingLineChangeRequestId());
		finSoProducerValue.setShipperAddressDetails(shiOrdModel.getShipperAddressDetails());
		finSoProducerValue.setConsigneeDetails(shiOrdModel.getConsigneeDetails());
		finSoProducerValue.setImportsConsigneeAddress(shiOrdModel.getImportsConsigneeAddress());
		finSoProducerValue.setSailScheduleDetails(shiOrdModel.getSailScheduleDetails());
		finSoProducerValue.setTransitTime(shiOrdModel.getTransitTime());
		finSoProducerValue.setFromEmail(shiOrdModel.getFromEmail());
		finSoProducerValue.setShipmentValue(shiOrdModel.getShipmentValue());
		finSoProducerValue.setShipmentCurrency(shiOrdModel.getShipmentCurrency());
		finSoProducerValue.setInvoicingCurrency(shiOrdModel.getInvoicingCurrency());
		finSoProducerValue.setExpectedBookingNoteIssueDate(shiOrdModel.getExpectedBookingNoteIssueDate());
		finSoProducerValue.setSkuNumber(shiOrdModel.getSkuNumber());
		finSoProducerValue.setIsOpenExaminationMarked(shiOrdModel.getIsOpenExaminationMarked());
		finSoProducerValue.setBookingInternalProcessStartDate(shiOrdModel.getBookingInternalProcessStartDate());
		finSoProducerValue.setBookingReceivedAt(shiOrdModel.getBookingReceivedAt());
		finSoProducerValue.setConfirmedByShipperAt(shiOrdModel.getConfirmedByShipperAt());
		finSoProducerValue.setBookingAcceptedAt(shiOrdModel.getBookingAcceptedAt());
		finSoProducerValue.setShareRequest(shiOrdModel.getShareRequest());
		finSoProducerValue.setIsBlCouriered(shiOrdModel.getIsBlCouriered());
		finSoProducerValue.setBlCourierCompanyName(shiOrdModel.getBlCourierCompanyName());
		finSoProducerValue.setBlCourierTrackingId(shiOrdModel.getBlCourierTrackingId());
		finSoProducerValue.setEuropeInterModalMode(shiOrdModel.getEuropeInterModalMode());
		finSoProducerValue.setOriginDetention(shiOrdModel.getOriginDetention());
		finSoProducerValue.setDestinationDetention(shiOrdModel.getDestinationDetention());
		finSoProducerValue.setDestinationDemmurage(shiOrdModel.getDestinationDemmurage());
		finSoProducerValue.setPluginDayOrigin(shiOrdModel.getPluginDayOrigin());
		finSoProducerValue.setPluginDayDestination(shiOrdModel.getPluginDayDestination());
		finSoProducerValue.setDetentionDayOrigin(shiOrdModel.getDetentionDayOrigin());
		finSoProducerValue.setDetentionDayDestination(shiOrdModel.getDetentionDayDestination());
		finSoProducerValue.setDemurageDayDestination(shiOrdModel.getDemurageDayDestination());
		finSoProducerValue.setContainersPickupDate(shiOrdModel.getContainersPickupDate());
		finSoProducerValue.setContainerWeightLimit(shiOrdModel.getContainerWeightLimit());
		finSoProducerValue.setWeightSlab(shiOrdModel.getWeightSlab());
		finSoProducerValue.setWeightSlabUnit(shiOrdModel.getWeightSlabUnit());
		finSoProducerValue.setTemperatureSlab(shiOrdModel.getTemperatureSlab());
		finSoProducerValue.setTemperatureSlabUnit(shiOrdModel.getTemperatureSlabUnit());
		finSoProducerValue.setTemperature(shiOrdModel.getTemperature());
		finSoProducerValue.setVentSetting(shiOrdModel.getVentSetting());
		finSoProducerValue.setVentilation(shiOrdModel.getVentilation());
		finSoProducerValue.setVentilationUnit(shiOrdModel.getVentilationUnit());
		finSoProducerValue.setHumidity(shiOrdModel.getHumidity());
		finSoProducerValue.setHumidityUnit(shiOrdModel.getHumidityUnit());
		finSoProducerValue.setLength(shiOrdModel.getLength());
		finSoProducerValue.setWidth(shiOrdModel.getWidth());
		finSoProducerValue.setHeight(shiOrdModel.getHeight());
		finSoProducerValue.setDimensionUnit(shiOrdModel.getDimensionUnit());
		finSoProducerValue.setContainerPickupActivity(shiOrdModel.getContainerPickupActivity());
		finSoProducerValue.setContainerGateInActivity(shiOrdModel.getContainerGateInActivity());
		finSoProducerValue.setContainerLinkingActivity(shiOrdModel.getContainerLinkingActivity());
		finSoProducerValue.setBlActivity(shiOrdModel.getBlActivity());
		finSoProducerValue.setIngauge(shiOrdModel.getIngauge());
		finSoProducerValue.setManual(shiOrdModel.getManual());
		finSoProducerValue.setRemarks(shiOrdModel.getRemarks());
		finSoProducerValue.setEnquiryComments(shiOrdModel.getEnquiryComments());
		finSoProducerValue.setImporterExporterInfoId(shiOrdModel.getImporterExporterInfoId());
		finSoProducerValue.setConsigneeId(shiOrdModel.getConsigneeId());
		finSoProducerValue.setIsSupplierAssigned(shiOrdModel.getIsSupplierAssigned());
		finSoProducerValue.setIncomePending(shiOrdModel.getIncomePending());
		finSoProducerValue.setShiOrdExpensePending(shiOrdModel.getExpensePending());
		finSoProducerValue.setVgmSelected(shiOrdModel.getVgmSelected());
		finSoProducerValue.setLockQuotation(shiOrdModel.getLockQuotation());
		finSoProducerValue.setMarginPercentage(shiOrdModel.getMarginPercentage());
		finSoProducerValue.setBuyerMarkups(shiOrdModel.getBuyerMarkups());
		finSoProducerValue.setInvoicesCcr(shiOrdModel.getInvoicesCcr());
		finSoProducerValue.setIsCancellationRequested(shiOrdModel.getIsCancellationRequested());
		finSoProducerValue.setCancellationRequestedReason(shiOrdModel.getCancellationRequestedReason());
		finSoProducerValue.setCancellationReason(shiOrdModel.getCancellationReason());
		finSoProducerValue.setCancellationSubReason(shiOrdModel.getCancellationSubReason());
		finSoProducerValue.setCancellationResponsibleParty(shiOrdModel.getCancellationResponsibleParty());
		finSoProducerValue.setCancelledBy(shiOrdModel.getCancelledBy());
		finSoProducerValue.setReplacementShipmentId(shiOrdModel.getReplacementShipmentId());
		finSoProducerValue.setAbortReason(shiOrdModel.getAbortReason());
		finSoProducerValue.setCancellationSummary(shiOrdModel.getCancellationSummary());
		finSoProducerValue.setCancelledWithRevenueLoss(shiOrdModel.getCancelledWithRevenueLoss());
		finSoProducerValue.setCancellationApprovedByAdmin(shiOrdModel.getCancellationApprovedByAdmin());
		finSoProducerValue.setCancellationAssessmentStatus(shiOrdModel.getCancellationAssessmentStatus());
		finSoProducerValue.setIsCancellationReasonUpdated(shiOrdModel.getIsCancellationReasonUpdated());
		finSoProducerValue.setBookingTurnaroundTime(shiOrdModel.getBookingTurnaroundTime());
		finSoProducerValue.setEtdDeviation(shiOrdModel.getEtdDeviation());
		finSoProducerValue.setTransitTimeDeviation(shiOrdModel.getTransitTimeDeviation());
		finSoProducerValue.setBLReleaseTime(shiOrdModel.getBLReleaseTime());
		finSoProducerValue.setBillingAccuracy(shiOrdModel.getBillingAccuracy());
		finSoProducerValue.setLogisticsCostToFob(shiOrdModel.getLogisticsCostToFob());
		finSoProducerValue.setExpenseBillingAccuracy(shiOrdModel.getExpenseBillingAccuracy());
		finSoProducerValue.setLoyaltyProgramApplicable(shiOrdModel.getLoyaltyProgramApplicable());
		finSoProducerValue.setLoyaltyConfigSnapshot(shiOrdModel.getLoyaltyConfigSnapshot());
		finSoProducerValue.setIsStoreTransferDone(shiOrdModel.getIsStoreTransferDone());
		finSoProducerValue.setDeductLoyaltyPoints(shiOrdModel.getDeductLoyaltyPoints());
		finSoProducerValue.setLoyaltyPointsRedeemType(shiOrdModel.getLoyaltyPointsRedeemType());
		finSoProducerValue.setLoyaltyPointsMaxRedeemLocked(shiOrdModel.getLoyaltyPointsMaxRedeemLocked());
		finSoProducerValue.setLoyaltyPointsInitiallyRedeemed(shiOrdModel.getLoyaltyPointsInitiallyRedeemed());
		finSoProducerValue.setLoyaltyPointRedemptionData(shiOrdModel.getLoyaltyPointRedemptionData());
		finSoProducerValue.setLoyaltyPointsEarningBreakup(shiOrdModel.getLoyaltyPointsEarningBreakup());
		finSoProducerValue.setLoyaltyPointsLocked(shiOrdModel.getLoyaltyPointsLocked());
		finSoProducerValue.setIsSupplierTeamApproved(shiOrdModel.getIsSupplierTeamApproved());
		finSoProducerValue.setSupplierTeamApprovedAt(shiOrdModel.getSupplierTeamApprovedAt());
		finSoProducerValue.setSupplierNegotiationInitiated(shiOrdModel.getSupplierNegotiationInitiated());
		finSoProducerValue.setEmailLogIds(shiOrdModel.emailLogIds);
		finSoProducerValue.setIsConfirmedByShipper(shiOrdModel.getIsConfirmedByShipper());
		finSoProducerValue.setQuotationConfirmedAt(shiOrdModel.getQuotationConfirmedAt());
		finSoProducerValue.setBlRelease(shiOrdModel.getBlRelease());
		finSoProducerValue.setExpectedShipmentDate(shiOrdModel.getExpectedShipmentDate());
		finSoProducerValue.setActualTimeOfDeparture(shiOrdModel.getActualTimeOfDeparture());
		finSoProducerValue.setExpectedArrivalDate(shiOrdModel.getExpectedArrivalDate());
		finSoProducerValue.setCompletedAt(shiOrdModel.getCompletedAt());
		finSoProducerValue.setCancelledAt(shiOrdModel.getCancelledAt());
		finSoProducerValue.setAbortedAt(shiOrdModel.getAbortedAt());
		finSoProducerValue.setShiOrdBranchId(shiOrdModel.getBranchId());
		finSoProducerValue.setFreightDiscountHash(shiOrdModel.getFreightDiscountHash());
		finSoProducerValue.setPromocodeDiscountPerContainer(shiOrdModel.getPromocodeDiscountPerContainer());
		finSoProducerValue.setFreightSearchDiscountMarkup(shiOrdModel.getFreightSearchDiscountMarkup());
		finSoProducerValue.setGoogleEventId(shiOrdModel.getGoogleEventId());
		finSoProducerValue.setDevice(shiOrdModel.getDevice());
		finSoProducerValue.setOperatingSystem(shiOrdModel.getOperatingSystem());
		finSoProducerValue.setBrowser(shiOrdModel.getBrowser());
		finSoProducerValue.setIsDraftExpired(shiOrdModel.getIsDraftExpired());
		finSoProducerValue.setDraftExpiryAt(shiOrdModel.getDraftExpiryAt());
		finSoProducerValue.setActiveEscalationsCount(shiOrdModel.getActiveEscalationsCount());
		finSoProducerValue.setPaymentOptionsSnapshot(shiOrdModel.getPaymentOptionsSnapshot());
		finSoProducerValue.setShiOrdOfficeCountryCode(shiOrdModel.getOfficeCountryCode());
		finSoProducerValue.setBookingRefNumber(shiOrdModel.getBookingRefNumber());
		finSoProducerValue.setIsNostroChargeApplicable(shiOrdModel.getIsNostroChargeApplicable());
		finSoProducerValue.setSearchRequirementId(shiOrdModel.getSearchRequirementId());
		finSoProducerValue.setCogoScheduledAutomationElementIndex(shiOrdModel.getCogoScheduledAutomationElementIndex());
		finSoProducerValue.setCogoEmailRecipientId(shiOrdModel.getCogoEmailRecipientId());
		finSoProducerValue.setCogoScheduledAutomationId(shiOrdModel.getCogoScheduledAutomationId());
		finSoProducerValue.setUtmSource(shiOrdModel.getUtmSource());
		finSoProducerValue.setUtmMedium(shiOrdModel.getUtmMedium());
		finSoProducerValue.setUtmCampaign(shiOrdModel.getUtmCampaign());
		finSoProducerValue.setCogoEmail(shiOrdModel.getCogoEmail());
		finSoProducerValue.setCogoToken(shiOrdModel.getCogoToken());
		finSoProducerValue.setCogoOrgUserId(shiOrdModel.getCogoOrgUserId());
		finSoProducerValue.setCogoLeadId(shiOrdModel.getCogoLeadId());
		finSoProducerValue.setCogoAssistedById(shiOrdModel.getCogoAssistedById());
		finSoProducerValue.setShiOrdCreatedAt(shiOrdModel.getCreatedAt());
		finSoProducerValue.setShiOrdUpdatedAt(shiOrdModel.getUpdatedAt());
		finSoProducerValue.setShiOrdMongoId(shiOrdModel.getMongoId());
		finSoProducerValue.setCurrentInvoicePreferenceId(shiOrdModel.getCurrentInvoicePreferenceId());
		finSoProducerValue.setIsHaz(shiOrdModel.getIsHaz());
		finSoProducerValue.setSearchCheckoutId(shiOrdModel.getSearchCheckoutId());
		finSoProducerValue.setSearchPackageId(shiOrdModel.getSearchPackageId());
		finSoProducerValue.setShipperEnquiryId(shiOrdModel.getShipperEnquiryId());
		finSoProducerValue.setOriginChaId(shiOrdModel.getOriginChaId());
		finSoProducerValue.setOriginCustomsChargeId(shiOrdModel.getOriginCustomsChargeId());
		finSoProducerValue.setOriginStuffingChargeId(shiOrdModel.getOriginStuffingChargeId());
		finSoProducerValue.setDestinationChaId(shiOrdModel.getDestinationChaId());
		finSoProducerValue.setDestinationCustomsChargeId(shiOrdModel.getDestinationCustomsChargeId());
		finSoProducerValue.setDestinationDestuffingChargeId(shiOrdModel.getDestinationDestuffingChargeId());
		finSoProducerValue.setOriginTransporterId(shiOrdModel.getOriginTransporterId());
		finSoProducerValue.setOriginTruckChargeId(shiOrdModel.getOriginTruckChargeId());
		finSoProducerValue.setOriginTrailerChargeId(shiOrdModel.getOriginTrailerChargeId());
		finSoProducerValue.setDestinationTransporterId(shiOrdModel.getDestinationTransporterId());
		finSoProducerValue.setDestinationTruckChargeId(shiOrdModel.getDestinationTruckChargeId());
		finSoProducerValue.setDestinationTrailerChargeId(shiOrdModel.getDestinationTrailerChargeId());
		finSoProducerValue.setOriginHaulageProviderId(shiOrdModel.getOriginHaulageProviderId());
		finSoProducerValue.setOriginHaulageChargeId(shiOrdModel.getOriginHaulageChargeId());
		finSoProducerValue.setDestinationHaulageProviderId(shiOrdModel.getDestinationHaulageProviderId());
		finSoProducerValue.setDestinationHaulageChargeId(shiOrdModel.getDestinationHaulageChargeId());
		finSoProducerValue.setInitialBookingAmount(shiOrdModel.getInitialBookingAmount());
		finSoProducerValue.setPickupLocationId(shiOrdModel.getPickupLocationId());
		finSoProducerValue.setDeliveryLocationId(shiOrdModel.getDeliveryLocationId());
		finSoProducerValue.setBillingAddressId(shiOrdModel.getBillingAddressId());
		finSoProducerValue.setMailingAddressId(shiOrdModel.getMailingAddressId());
		finSoProducerValue.setMailingAddress(shiOrdModel.getMailingAddress());
		finSoProducerValue.setDestuffingType(shiOrdModel.getDestuffingType());
		finSoProducerValue.setCfsStuffingId(shiOrdModel.getCfsStuffingId());
		finSoProducerValue.setCfsStuffingAddress(shiOrdModel.getCfsStuffingAddress());
		finSoProducerValue.setCfsDestuffingId(shiOrdModel.getCfsDestuffingId());
		finSoProducerValue.setCfsDestuffingAddress(shiOrdModel.getCfsDestuffingAddress());
		finSoProducerValue.setFactoryAddressId(shiOrdModel.getFactoryAddressId());
		finSoProducerValue.setFactoryAddress(shiOrdModel.getFactoryAddress());
		finSoProducerValue.setConsigneeWarehouseAddressId(shiOrdModel.getConsigneeWarehouseAddressId());
		finSoProducerValue.setConsigneeAddress(shiOrdModel.getConsigneeAddress());
		finSoProducerValue.setShippingBillCount(shiOrdModel.getShippingBillCount());
		finSoProducerValue.setOriginTruckType(shiOrdModel.getOriginTruckType());
		finSoProducerValue.setDestinationTruckType(shiOrdModel.getDestinationTruckType());
		finSoProducerValue.setTruckCount(shiOrdModel.getTruckCount());
		finSoProducerValue.setTruckType(shiOrdModel.getTruckType());
		finSoProducerValue.setCargoWeight(shiOrdModel.getCargoWeight());
		finSoProducerValue.setCargoWeightUnit(shiOrdModel.getCargoWeightUnit());
		finSoProducerValue.setCargoPickupDate(shiOrdModel.getCargoPickupDate());
		finSoProducerValue.setVgmFiledAt(shiOrdModel.getVgmFiledAt());
		finSoProducerValue.setForm13FiledAt(shiOrdModel.getForm_13_filed_at());
		finSoProducerValue.setSiFiledAt(shiOrdModel.getSiFiledAt());
		finSoProducerValue.setInvoiceCurrencyForFreight(shiOrdModel.getInvoiceCurrencyForFreight());
		finSoProducerValue.setInvoiceCurrencyForOtherServices(shiOrdModel.getInvoiceCurrencyForOtherServices());
		finSoProducerValue.setTransShipmentStops(shiOrdModel.getTransShipmentStops());
		finSoProducerValue.setVesselName(shiOrdModel.getVesselName());
		finSoProducerValue.setTransportWeightSlab(shiOrdModel.getTransportWeightSlab());
		finSoProducerValue.setConsigneeIds(shiOrdModel.consigneeIds);
		finSoProducerValue.setPaymentType(shiOrdModel.getPaymentType());
		finSoProducerValue.setPaymentTerm(shiOrdModel.getPaymentTerm());
		finSoProducerValue.setClpProgressStages(shiOrdModel.getClpProgressStages());
		finSoProducerValue.setHasKycConsent(shiOrdModel.getHasKycConsent());
		finSoProducerValue.setOriginHaulageProviderType(shiOrdModel.getOriginHaulageProviderType());
		finSoProducerValue.setOriginHaulageTransportMode(shiOrdModel.getOriginHaulageTransportMode());
		finSoProducerValue.setOriginHaulageTransportServiceProvider(shiOrdModel.getOriginHaulageTransportServiceProvider());
		finSoProducerValue.setDestinationHaulageProviderType(shiOrdModel.getDestinationHaulageProviderType());
		finSoProducerValue.setDestinationHaulageTransportMode(shiOrdModel.getDestinationHaulageTransportMode());
		finSoProducerValue.setDestinationHaulageTransportServiceProvider(shiOrdModel.getDestinationHaulageTransportServiceProvider());
		finSoProducerValue.setMilestoneEtas(shiOrdModel.getMilestoneEtas());
		
		if (shiOrdModel.getOriginPortId() != null) {
			
			LocationLocationsConsumerModel llConsumerModel = (LocationLocationsConsumerModel) cacheMap.get(CommonConstants.LOCATION_LOCATIONS_CACHE).get(shiOrdModel.getOriginPortId());
			
			finSoProducerValue.setLlId(llConsumerModel.getId());
			finSoProducerValue.setLlMongoId(llConsumerModel.getMongoId());
			finSoProducerValue.setName(llConsumerModel.getName());
			finSoProducerValue.setDisplayName(llConsumerModel.getDisplayName());
			finSoProducerValue.setType(llConsumerModel.getType());
			finSoProducerValue.setLlStatus(llConsumerModel.getStatus());
			finSoProducerValue.setContinentId(llConsumerModel.getContinentId());
			finSoProducerValue.setTradeId(llConsumerModel.getTradeId());
			finSoProducerValue.setCountryId(llConsumerModel.getCountryId());
			finSoProducerValue.setRegionId(llConsumerModel.getRegionId());
			finSoProducerValue.setCityId(llConsumerModel.getCityId());
			finSoProducerValue.setClusterId(llConsumerModel.getClusterId());
			finSoProducerValue.setPortId(llConsumerModel.getPortId());
			finSoProducerValue.setPincodeId(llConsumerModel.getPincodeId());
			finSoProducerValue.setLatitude(llConsumerModel.getLatitude());
			finSoProducerValue.setLongitude(llConsumerModel.getLongitude());
			finSoProducerValue.setLoc(llConsumerModel.getLoc());
			finSoProducerValue.setPostalCode(llConsumerModel.getPostalCode());
			finSoProducerValue.setIsIcd(llConsumerModel.getIsIcd());
			finSoProducerValue.setIsAirport(llConsumerModel.getIsAirport());
			finSoProducerValue.setPortCode(llConsumerModel.getPortCode());
			finSoProducerValue.setInttraCode(llConsumerModel.getInttraCode());
			finSoProducerValue.setIcdPorts(llConsumerModel.icdPorts);
			finSoProducerValue.setCurrencyCode(llConsumerModel.getCurrencyCode());
			finSoProducerValue.setCountryCode(llConsumerModel.getCountryCode());
			finSoProducerValue.setMobileCountryCode(llConsumerModel.getMobileCountryCode());
			finSoProducerValue.setFlagIconUrl(llConsumerModel.getFlagIconUrl());
			finSoProducerValue.setFlagImageUrl(llConsumerModel.getFlagImageUrl());
			finSoProducerValue.setLlCreatedAt(llConsumerModel.getCreatedAt());
			finSoProducerValue.setLlUpdatedAt(llConsumerModel.getUpdatedAt());
		}
		
		if (finStateValue != null) {
			this.cleanAllStates();
			out.collect(finSoProducerValue);
		}
		else {
			this.getXState().update(yModel);
			this.getZState().update(finSoProducerValue);
		}
		
	}

}
