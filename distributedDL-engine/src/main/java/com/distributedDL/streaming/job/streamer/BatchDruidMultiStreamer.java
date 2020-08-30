package com.distributedDL.streaming.job.streamer;

import com.distributedDL.streaming.batch.FinanceOutstandingBatchJob;
import com.distributedDL.streaming.batch.ShipmentBlCombinedBatchJob;
import com.distributedDL.streaming.core.Streamer;

@SuppressWarnings({"rawtypes", "unchecked"})
public class BatchDruidMultiStreamer extends Streamer{
	
	public BatchDruidMultiStreamer() {

	}

	public static void main(String[] args) {
		
		jobName = "Batch-Druid-Multi-Stream-Submitter Flink Job";
		
		streamer = new BatchDruidMultiStreamer();
		
		streamer.addJob(new ShipmentBlCombinedBatchJob());
		streamer.addJob(new FinanceOutstandingBatchJob());
		
		try {
			streamer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
