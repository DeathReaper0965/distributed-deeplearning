package com.distributedDL.streaming.batch.cache.mapping;

import org.apache.flink.types.Row;

import com.distributedDL.streaming.batch.mapping.AppBatchMapping;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.models.consumer.OrganizationsConsumerModel;


@SuppressWarnings({"serial" })
public class OrgBatchCacheMapping extends AppBatchMapping{
	
	public OrgBatchCacheMapping(RocksDbCache rocksDbCache) {
		super(rocksDbCache);
	}

	@Override
	public Boolean map(Row value) throws Exception {
		OrganizationsConsumerModel organizationsConsumerModel = new OrganizationsConsumerModel(); 
		
		organizationsConsumerModel.setId(CommonUtils.checkNull(value.getField(0)));
		organizationsConsumerModel.setAccountType(CommonUtils.checkNull(value.getField(1)));
		organizationsConsumerModel.setAdress(CommonUtils.checkNull(value.getField(2)));
		organizationsConsumerModel.setBranchCity(CommonUtils.checkNull(value.getField(3)));
		organizationsConsumerModel.setBusinessName(CommonUtils.checkNull(value.getField(4)));
		organizationsConsumerModel.setConvertedAt(CommonUtils.checkNull(value.getField(5)));
		organizationsConsumerModel.setCreatedAt(CommonUtils.checkNull(value.getField(6)));
		organizationsConsumerModel.setGst(CommonUtils.checkNull(value.getField(7)));
		organizationsConsumerModel.setIec(CommonUtils.checkNull(value.getField(8)));
		organizationsConsumerModel.setIncId(Integer.valueOf(CommonUtils.checkNull(value.getField(9))));
		organizationsConsumerModel.setIsFieoMember(Boolean.valueOf(CommonUtils.checkNull(value.getField(10))));
		organizationsConsumerModel.setIsLead(Boolean.valueOf(CommonUtils.checkNull(value.getField(11))));
		organizationsConsumerModel.setIsShippingLine(Boolean.valueOf(CommonUtils.checkNull(value.getField(12))));
		organizationsConsumerModel.setIsSsp(Boolean.valueOf(CommonUtils.checkNull(value.getField(13))));
		organizationsConsumerModel.setLastSearchDate(CommonUtils.checkNull(value.getField(14)));
		organizationsConsumerModel.setOperationsOwnerId(CommonUtils.checkNull(value.getField(15)));
		organizationsConsumerModel.setOwnerId(CommonUtils.checkNull(value.getField(16)));
		organizationsConsumerModel.setRegistrationType(CommonUtils.checkNull(value.getField(17)));
		organizationsConsumerModel.setShortName(CommonUtils.checkNull(value.getField(18)));
		organizationsConsumerModel.setSignupCity(CommonUtils.checkNull(value.getField(19)));
		organizationsConsumerModel.setStatus(CommonUtils.checkNull(value.getField(20)));
		organizationsConsumerModel.setTier(CommonUtils.checkNullAndDouble(value.getField(21)));
		organizationsConsumerModel.setTotalSearchesCount(CommonUtils.checkNullAndDouble(value.getField(22)));
		organizationsConsumerModel.setType(CommonUtils.checkNull(value.getField(23)));
		organizationsConsumerModel.setUpdatedAt(CommonUtils.checkNull(value.getField(24)));
		
		return rocksDbCache.put(organizationsConsumerModel.getId(), organizationsConsumerModel);
	}

}
