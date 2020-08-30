package com.distributedDL.streaming.job.streamer;

import com.distributedDL.streaming.core.Streamer;
import com.distributedDL.streaming.job.ActivityLogStreamingJob;
import com.distributedDL.streaming.job.FinanceStreamingJob;
import com.distributedDL.streaming.job.ShipmentOrdersStreamingJob;
import com.distributedDL.streaming.job.TicketsStreamingJob;
import com.distributedDL.streaming.job.cache.LocationLocationsCacheStreamingJob;
import com.distributedDL.streaming.job.cache.OrganizationsCacheStreamingJob;
import com.distributedDL.streaming.job.cache.OrganizationsUsersCacheStreamingJob;
import com.distributedDL.streaming.job.cache.ShipmentOrderCacheStreamingJob;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SingleStreamStreamer extends Streamer{

	public SingleStreamStreamer() {

	}

	public static void main(String[] args) {
		
		jobName = "Single-Stream Flink Job";
		
		streamer = new SingleStreamStreamer();
		
		streamer.addJob(new ShipmentOrdersStreamingJob());
		streamer.addJob(new ActivityLogStreamingJob());
		streamer.addJob(new FinanceStreamingJob());
		streamer.addJob(new TicketsStreamingJob());
		streamer.addJob(new ShipmentOrderCacheStreamingJob());
		streamer.addJob(new OrganizationsCacheStreamingJob());
		streamer.addJob(new OrganizationsUsersCacheStreamingJob());
		streamer.addJob(new LocationLocationsCacheStreamingJob());
		
		try {
			streamer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
