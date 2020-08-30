package com.distributedDL.streaming.job;

import java.util.HashMap;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.Streamer;
import com.distributedDL.streaming.joiner.BlDocJoiner;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;
import com.distributedDL.streaming.models.consumer.shipment.ShipmentBlDetailsConsumerModel;
import com.distributedDL.streaming.models.consumer.shipment.ShipmentDocumentsConsumerModel;

@SuppressWarnings({"unchecked", "serial", "rawtypes"})
public class BlCombinedStreamingJob extends AppStreamingJob{
	
	private HashMap<String, RocksDbCache> cacheMap = null;
	
	private ShipmentBlStreamingJob shipmentBlStreamingJob = null;
	private ShipmentDocumentsStreamingJob shipmentDocumentsStreamingJob = null;
	
	public BlCombinedStreamingJob(Streamer streamer, HashMap<String, RocksDbCache> cacheMap) {
		super();
		
		this.cacheMap = cacheMap;
		this.setIsMultiStream(true);
		
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.SHIPMENT_DB);
		template.setTableName(CommonConstants.COMBINED_SHIPMENT_BL);
		
		for (Object job: streamer.jobs) {
			if (job instanceof ShipmentBlStreamingJob && this.shipmentBlStreamingJob == null) {
				this.shipmentBlStreamingJob = (ShipmentBlStreamingJob) job;
			}
			
			if (job instanceof ShipmentDocumentsStreamingJob && this.shipmentDocumentsStreamingJob == null) {
				this.shipmentDocumentsStreamingJob = (ShipmentDocumentsStreamingJob) job;
			}
			
			if (this.shipmentBlStreamingJob != null && this.shipmentDocumentsStreamingJob != null) {
				break;
			}
			
		}
		
		if (this.shipmentBlStreamingJob == null) {
			this.shipmentBlStreamingJob = new ShipmentBlStreamingJob();
			streamer.addJob(this.shipmentBlStreamingJob);
		}
		
		if (this.shipmentDocumentsStreamingJob == null) {
			this.shipmentDocumentsStreamingJob = new ShipmentDocumentsStreamingJob();
			streamer.addJob(this.shipmentDocumentsStreamingJob);
		}
		
		this.setStreamer(streamer);
		
	}
	
	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Combined Streams Transformer...");
		
		DataStream<ChangeDataConsumerModel> blStream = this.shipmentBlStreamingJob.getStream();
		DataStream<ChangeDataConsumerModel> documentStream = this.shipmentDocumentsStreamingJob.getStream();
		
		blStream = blStream.keyBy(new BlSelector());
		documentStream = documentStream.keyBy(new DocSelector());
		
		blStream.print();
		documentStream.print();
		
		stream = blStream.connect(documentStream)
						 .flatMap(new BlDocJoiner(this.cacheMap));
		
		stream.print();
		
		return stream;
	}
	
	private static class BlSelector implements KeySelector<ChangeDataConsumerModel, String>{

		@Override
		public String getKey(ChangeDataConsumerModel value) throws Exception {
			ShipmentBlDetailsConsumerModel shipmentBlDetailsConsumerModel = 
					(ShipmentBlDetailsConsumerModel) CommonUtils.getObjectMapper().convertValue(value.getAfter(), ShipmentBlDetailsConsumerModel.class);
			System.out.println("BL Selector " + shipmentBlDetailsConsumerModel.getShipmentId());
			return shipmentBlDetailsConsumerModel.getShipmentId();
		}
		
	}
	
	private static class DocSelector implements KeySelector<ChangeDataConsumerModel, String>{

		@Override
		public String getKey(ChangeDataConsumerModel value) throws Exception {
			ShipmentDocumentsConsumerModel shipmentDocumentsConsumerModel = 
					(ShipmentDocumentsConsumerModel) CommonUtils.getObjectMapper().convertValue(value.getAfter(), ShipmentDocumentsConsumerModel.class);
			System.out.println("Doc Selector " + shipmentDocumentsConsumerModel.getEntityId());
			return shipmentDocumentsConsumerModel.getEntityId();
		}
		
	}

}
