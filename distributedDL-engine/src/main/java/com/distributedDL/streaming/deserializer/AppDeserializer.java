package com.distributedDL.streaming.deserializer;

import com.distributedDL.streaming.core.Deserializer;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;

@SuppressWarnings({"serial" })
public class AppDeserializer extends Deserializer<ChangeDataConsumerModel> {

	public AppDeserializer() {
		super();
		this.setClassInstance(ChangeDataConsumerModel.class);
	}
}
