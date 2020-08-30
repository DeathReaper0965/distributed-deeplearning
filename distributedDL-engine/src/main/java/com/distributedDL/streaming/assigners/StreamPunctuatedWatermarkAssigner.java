package com.distributedDL.streaming.assigners;

import org.apache.flink.streaming.api.functions.AssignerWithPunctuatedWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;

import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;

@SuppressWarnings({ "serial" })
public class StreamPunctuatedWatermarkAssigner implements AssignerWithPunctuatedWatermarks<ChangeDataConsumerModel>{

	@Override
	public long extractTimestamp(ChangeDataConsumerModel element, long previousElementTimestamp) {
		return element.getTsMs();
	}

	@Override
	public Watermark checkAndGetNextWatermark(ChangeDataConsumerModel lastElement, long extractedTimestamp) {
		return new Watermark(lastElement.getTsMs() - 5000);
	}

}
