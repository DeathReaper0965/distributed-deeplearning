package com.distributedDL.streaming.mapping;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.Mapper;
import com.distributedDL.streaming.models.consumer.AppConsumerModel;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;
import com.distributedDL.streaming.models.producer.AppProducerModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings({ "serial", "unchecked" })
public abstract class AppMapping<X, Y> extends Mapper<ChangeDataConsumerModel, Y> {

	ChangeDataConsumerModel changeDataConsumerModel = null;
	AppConsumerModel consumerModel = null;
	AppProducerModel producerModel = null;
	Date eventTime = null;
	
	public static HashMap<String, RocksDbCache> cacheMap = new HashMap<String, RocksDbCache>();

	@Override
	public Y map(ChangeDataConsumerModel value) throws Exception {
		this.setChangeDataConsumerModel(value);

		LinkedHashMap<String, Object> consumerMap = value.getAfter();

		if (consumerMap == null) {
			return null;
		}
		
		this.setConsumerModel((AppConsumerModel) this.getInstanceOfX());
		this.setConsumerModel(
				(AppConsumerModel) this.getMapper().convertValue(consumerMap, this.getConsumerModel().getClass()));
		this.setProducerModel((AppProducerModel) this.getInstanceOfY());

		this.setEventTime(CommonUtils.convertUnixTimeStampToDate(value.getTsMs()));
		this.getProducerModel().setCreatedAt(this.getEventTime());

		return this.mapping((X) this.getConsumerModel(), (Y) this.getProducerModel());
	}

	public abstract Y mapping(X consumer, Y producer);

	public X getInstanceOfX() {
		ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
		Class<X> type = (Class<X>) superClass.getActualTypeArguments()[0];
		try {
			return type.newInstance();
		} catch (Exception e) {
			// Oops, no default constructor
			throw new RuntimeException(e);
		}
	}

	public Y getInstanceOfY() {
		ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
		Class<Y> type = (Class<Y>) superClass.getActualTypeArguments()[1];
		try {
			return type.newInstance();
		} catch (Exception e) {
			// Oops, no default constructor
			throw new RuntimeException(e);
		}
	}

}
