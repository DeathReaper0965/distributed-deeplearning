package com.distributedDL.streaming.job;

import java.util.HashMap;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.Streamer;
import com.distributedDL.streaming.joiner.FinSoJoiner;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;
import com.distributedDL.streaming.models.consumer.FinanceInvoicesConsumerModel;
import com.distributedDL.streaming.models.consumer.ShipmentOrdersConsumerModel;


@SuppressWarnings({"unchecked", "serial", "rawtypes"})
public class FinSoCombinedStreamJob extends AppStreamingJob {

	private HashMap<String, RocksDbCache> cacheMap = null;
	
	private ShipmentOrdersStreamingJob shipmentOrdersStreamingJob = null;
	private FinanceInvoicesStreamingJob financeInvoicesStreamingJob = null;
	
	
	public FinSoCombinedStreamJob(Streamer streamer, HashMap<String, RocksDbCache> cacheMap) {
		super();
		
		this.cacheMap = cacheMap;
		this.setIsMultiStream(true);
		
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.COMBINED_STREAM);
		template.setTableName(CommonConstants.FIN_SO_COMBINED);
		
		for (Object job: streamer.jobs) {
			if (job instanceof FinanceInvoicesStreamingJob && this.financeInvoicesStreamingJob == null) {
				this.financeInvoicesStreamingJob = (FinanceInvoicesStreamingJob) job;
			}
			
			if (job instanceof ShipmentOrdersStreamingJob && this.shipmentOrdersStreamingJob == null) {
				this.shipmentOrdersStreamingJob = (ShipmentOrdersStreamingJob) job;
			}
			
			if (this.financeInvoicesStreamingJob != null && this.shipmentOrdersStreamingJob != null) {
				break;
			}
			
		}
		
		if (this.financeInvoicesStreamingJob == null) {
			this.financeInvoicesStreamingJob = new FinanceInvoicesStreamingJob();
			streamer.addJob(this.financeInvoicesStreamingJob);
		}
		
		if (this.shipmentOrdersStreamingJob == null) {
			this.shipmentOrdersStreamingJob = new ShipmentOrdersStreamingJob();
			streamer.addJob(this.shipmentOrdersStreamingJob);
		}
		
		this.setStreamer(streamer);
	}
	
	@Override
	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Combined Streams Transformer...");
		
		DataStream<ChangeDataConsumerModel> finStream = this.financeInvoicesStreamingJob.getStream();
		DataStream<ChangeDataConsumerModel> soStream = this.shipmentOrdersStreamingJob.getStream();
		
		finStream = finStream.keyBy(new FinSelector());
		soStream = soStream.keyBy(new SoSelector());
		
		finStream.print();
		soStream.print();
		
		stream = finStream.connect(soStream)
						 .flatMap(new FinSoJoiner(this.cacheMap));
		
		stream.print();
		
		return stream;
	}
	
	private static class FinSelector implements KeySelector<ChangeDataConsumerModel, String>{

		@Override
		public String getKey(ChangeDataConsumerModel value) throws Exception {
			FinanceInvoicesConsumerModel financeInvoicesConsumerModel = 
					(FinanceInvoicesConsumerModel) CommonUtils.getObjectMapper().convertValue(value.getAfter(), FinanceInvoicesConsumerModel.class);
			System.out.println("Fin Selector " + financeInvoicesConsumerModel.getShipmentId());
			return financeInvoicesConsumerModel.getShipmentId();
		}
		
	}
	
	private static class SoSelector implements KeySelector<ChangeDataConsumerModel, String>{

		@Override
		public String getKey(ChangeDataConsumerModel value) throws Exception {
			ShipmentOrdersConsumerModel shipmentOrdersConsumerModel = 
					(ShipmentOrdersConsumerModel) CommonUtils.getObjectMapper().convertValue(value.getAfter(), ShipmentOrdersConsumerModel.class);
			System.out.println("Doc Selector " + shipmentOrdersConsumerModel.getId());
			return shipmentOrdersConsumerModel.getId();
		}
		
	}

}
