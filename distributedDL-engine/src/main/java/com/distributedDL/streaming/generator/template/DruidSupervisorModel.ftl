<#assign count = 0 />
{
  "type": "kafka",
  "dataSchema": {
    "dataSource": "${druidSupervisorModel.dataSource}",
    "parser": {
      "type": "string",
      "parseSpec": {
        "format": "json",
        "timestampSpec": {
          "column": "created_at",
          "format": "auto"
        },
        "dimensionsSpec": {
            "dimensions": [
            	<#list druidSupervisorModel.dimensions as dimension>
                <#assign count = count + 1/>
                { "name": "${dimension["name"]}", "type": "${dimension["type"]}" }<#if druidSupervisorModel.dimensions?size != count>, </#if>
                </#list>
            ]
        }
      }
    },
    "metricsSpec" : [
    	<#list druidSupervisorModel.metrics as metric>
    	{
    		"name": "${metric["name"]}",
    		<#if (metric["fieldName"])??>"fieldName": "${metric["fieldName"]}", </#if>
    		"type": "${metric["type"]}"
    	}
    	</#list>
    ],
    "granularitySpec": {
    	"type": "uniform",
    	"segmentGranularity": "DAY",
    	"queryGranularity": "NONE",
    	"rollup": false
    }
  },
  "tuningConfig": {
    "type": "kafka",
    "reportParseExceptions": false
  },
  "ioConfig": {
    "topic": "${druidSupervisorModel.topic}",
    "replicas": ${druidSupervisorModel.replicas},
    "taskDuration": "PT10M",
    "completionTimeout": "PT20M",
    "consumerProperties": {
      "bootstrap.servers": "${druidSupervisorModel.bootStrapServers}"
    }
  }
}