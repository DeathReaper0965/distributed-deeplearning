package com.distributedDL.streaming.streamer;

import org.apache.flink.api.java.utils.ParameterTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.distributedDL.streaming.apis.DruidSupervisorSubmitter;
import com.distributedDL.streaming.generator.ConsumerGenerator;
import com.distributedDL.streaming.generator.DebeziumConnectorGenerator;
import com.distributedDL.streaming.generator.DruidSupervisorGenerator;
import com.distributedDL.streaming.job.streamer.BatchCacheStreamer;
import com.distributedDL.streaming.job.streamer.BatchDruidMultiStreamer;
import com.distributedDL.streaming.job.streamer.MultiStreamStreamer;
import com.distributedDL.streaming.job.streamer.SingleStreamStreamer;
import com.distributedDL.streaming.table.schema.TableSchemaGenerator;

public class AppStreamer{
	
	private final static Logger LOG = LoggerFactory.getLogger(AppStreamer.class);
	
	private static String job;
	private static String generate;
	private static String submit;
	
	public static void main(String[] args) {
		
        final ParameterTool params = ParameterTool.fromArgs(args);
        
        job = params.get("job", null);
        generate = params.get("generate", null);
        submit = params.get("submit", null);
		
        if (job == null && generate == null && submit == null) {
        	LOG.error("No job or genarator or submit supervisor specified. "
        			+ "\nPlease run 'java -jar <jar_name> --job <job_name>' or "
        			+ "\n'java -jar <jar_name> --generate <generate_command>' or "
        			+ "\n'java -jar <jar_name> --submit <druid_supervisor_filename>");
			return;
		}
        
		if (job != null) {
		
			if (job.equals("batch_cache_job")) {
				BatchCacheStreamer.main(null);
			}
			else if (job.equals("single_stream_job")) {
				SingleStreamStreamer.main(null);
			}
			else if (job.equals("multi_stream_job")) {
				MultiStreamStreamer.main(null);
			}
			else if (job.equals("druid_job")) {
				BatchDruidMultiStreamer.main(null);
			}
		}
		
		if (generate != null) {
			
			if (generate.equals("consumer_schema")) {
				TableSchemaGenerator tableSchemaGenerator = new TableSchemaGenerator();
				tableSchemaGenerator.startGeneratingSchemas();
				
				try {
					ConsumerGenerator consumerGenerator = new ConsumerGenerator();
					consumerGenerator.generate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (generate.equals("druid_supervisor")) {
				
				try {
					DruidSupervisorGenerator druidSupervisorGenerator = new DruidSupervisorGenerator();
					druidSupervisorGenerator.generate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (generate.equals("debezium_connectors")) {
				
				try {
					DebeziumConnectorGenerator debeziumConnectorGenerator = new DebeziumConnectorGenerator();
					debeziumConnectorGenerator.generate();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if (submit != null) {
			DruidSupervisorSubmitter druidSupervisorSubmitter = new DruidSupervisorSubmitter();
			String submitStatus = druidSupervisorSubmitter.submitSupervisor(submit);
			
			LOG.info("final status: " + submitStatus);
			
		}
	}
	
}
