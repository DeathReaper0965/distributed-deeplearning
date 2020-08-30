package com.distributedDL.streaming.job.streamer;

import com.distributedDL.streaming.batch.ActivityLogsBatchJob;
import com.distributedDL.streaming.batch.ActivityLogsBucketsBatchJob;
import com.distributedDL.streaming.batch.ActivityLogsTagsBatchJob;
import com.distributedDL.streaming.batch.AdminsBatchJob;
import com.distributedDL.streaming.batch.LocationLocationsBatchJob;
import com.distributedDL.streaming.batch.OrganizationOrganizationUsersBatchJob;
import com.distributedDL.streaming.batch.OrganizationOrganizationsBatchJob;
import com.distributedDL.streaming.batch.OrganizationsBatchJob;
import com.distributedDL.streaming.batch.OrganizationsUsersBatchJob;
import com.distributedDL.streaming.core.Streamer;

@SuppressWarnings({"rawtypes", "unchecked"})
public class BatchCacheStreamer extends Streamer{
	
	public BatchCacheStreamer() {

	}

	public static void main(String[] args) {
		
		jobName = "Batch Cache Flink Job";
		
		streamer = new BatchCacheStreamer();
		
		streamer.addJob(new ActivityLogsBatchJob());
		streamer.addJob(new ActivityLogsTagsBatchJob());
		streamer.addJob(new ActivityLogsBucketsBatchJob());
		streamer.addJob(new AdminsBatchJob());
		streamer.addJob(new OrganizationsUsersBatchJob());
		streamer.addJob(new OrganizationsBatchJob());
		streamer.addJob(new LocationLocationsBatchJob());
		streamer.addJob(new OrganizationOrganizationsBatchJob());
		streamer.addJob(new OrganizationOrganizationUsersBatchJob());
		
		try {
			streamer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
