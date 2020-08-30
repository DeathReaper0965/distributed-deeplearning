package com.distributedDL.streaming.job.streamer;

import java.util.HashMap;

import com.distributedDL.streaming.cachedb.CacheCollection;
import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.core.Streamer;
import com.distributedDL.streaming.job.BlCombinedStreamingJob;
import com.distributedDL.streaming.job.FinSoCombinedStreamJob;
import com.distributedDL.streaming.job.FinanceOutstandingStreamingJob;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MultiStreamStreamer extends Streamer{
	
	public MultiStreamStreamer() {

	}

	private static HashMap<String, RocksDbCache> cacheMap = CacheCollection.getAllCaches();

	public static void main(String[] args) {
		
		jobName = "Multi-Stream Flink Job";
		
		streamer = new MultiStreamStreamer();
		
		BlCombinedStreamingJob blCombinedStreamingJob = new BlCombinedStreamingJob(streamer, cacheMap);
		streamer = blCombinedStreamingJob.getStreamer();
		streamer.addJob(blCombinedStreamingJob);
		
		FinanceOutstandingStreamingJob financeOutstandingStreamingJob = new FinanceOutstandingStreamingJob(streamer, cacheMap);
		streamer = financeOutstandingStreamingJob.getStreamer();
		streamer.addJob(financeOutstandingStreamingJob);
		
		FinSoCombinedStreamJob finSoCombinedStreamJob = new FinSoCombinedStreamJob(streamer, cacheMap);
		streamer = finSoCombinedStreamJob.getStreamer();
		streamer.addJob(finSoCombinedStreamJob);
		
		try {
			streamer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
