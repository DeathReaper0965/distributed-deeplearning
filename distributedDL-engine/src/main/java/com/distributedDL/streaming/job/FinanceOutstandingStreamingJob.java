package com.distributedDL.streaming.job;

import java.util.HashMap;

import org.apache.flink.streaming.api.datastream.DataStream;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.common.CommonConstants;
import com.distributedDL.streaming.common.CommonUtils;
import com.distributedDL.streaming.core.Streamer;
import com.distributedDL.streaming.mapping.FinanceOutstandingMapping;
import com.distributedDL.streaming.models.consumer.ChangeDataConsumerModel;

@SuppressWarnings({"unchecked", "rawtypes"})
public class FinanceOutstandingStreamingJob extends AppStreamingJob {
	
	private HashMap<String, RocksDbCache> cacheMap = null;
	
	private FinanceInvoicesStreamingJob financeInvoicesStreamingJob = null;
	
	public FinanceOutstandingStreamingJob(Streamer streamer, HashMap<String, RocksDbCache> cacheMap){
		super();
		
		this.cacheMap = cacheMap;
		this.setIsMultiStream(true);
		
		template = CommonUtils.setKafkaTopicProperties(template, CommonConstants.COMBINED_STREAM);
		template.setTableName(CommonConstants.OUTSTANDING);
		
		for (Object job: streamer.jobs) {
			
			if (this.financeInvoicesStreamingJob != null) {
				break;
			}
			
			if(job instanceof FinanceInvoicesStreamingJob && this.financeInvoicesStreamingJob != null) {
				this.financeInvoicesStreamingJob = (FinanceInvoicesStreamingJob) job;
			}
			
		}
		
		if (this.financeInvoicesStreamingJob == null) {
			this.financeInvoicesStreamingJob = new FinanceInvoicesStreamingJob();
			streamer.addJob(this.financeInvoicesStreamingJob);
		}
		
		this.setStreamer(streamer);
		
	}

	public DataStream addTransformer(DataStream stream) {
		System.out.println("Adding Combined Streams Transformer...");
		
		DataStream<ChangeDataConsumerModel> fiStream = this.financeInvoicesStreamingJob.getStream();
		
		fiStream.print();
		
		stream = fiStream.map(new FinanceOutstandingMapping(this.cacheMap));
		
		stream.print();
		
		return stream;
	}

}
