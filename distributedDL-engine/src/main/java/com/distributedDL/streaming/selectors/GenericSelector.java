package com.distributedDL.streaming.selectors;

import org.apache.flink.api.java.functions.KeySelector;

import com.distributedDL.streaming.models.consumer.AppConsumerModel;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class GenericSelector implements KeySelector<ChangeDataConsumerModel, Object>{
	
	private ChangeDataConsumerModel changeDataConsumerModel = null;
	private AppConsumerModel consumerModel = null;
	private Object keyObj = null; 

	@Override
	public Object getKey(ChangeDataConsumerModel changeDataConsumerModel) throws Exception {
		this.setChangeDataConsumerModel(changeDataConsumerModel);
		return this.getKeyObj();
	}
	
	public GenericSelector(String value){
		Object keyObj = this.getChangeDataConsumerModel().getAfter().get(value);
		this.setKeyObj(keyObj);
	}

}
