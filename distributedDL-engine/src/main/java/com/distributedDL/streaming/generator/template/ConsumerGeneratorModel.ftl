<#include "Commons.ftl">
package ${consumerGeneratorModel.packageName};

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

<#compress>
<#assign found_field_types = [] />

<#list consumerGeneratorModel.fields as field>

	<#if field["field_type"] == "Jdbc4Array" && !found_field_types?seq_contains("Jdbc4Array")>

		<#assign found_field_types = found_field_types + ["Jdbc4Array"] />
		import org.postgresql.jdbc4.Jdbc4Array;
		
	<#elseif field["field_type"] == "PGobject" && !found_field_types?seq_contains("PGobject")>
	
		<#assign found_field_types = found_field_types + ["PGobject"] />
		import org.postgresql.util.PGobject;
		
	<#elseif field["field_type"] == "Date" && !found_field_types?seq_contains("Date")>
	
		<#assign found_field_types = found_field_types + ["Date"] />
		import java.util.Date;
		
	<#elseif (field["field_type"] == "List" || field["field_type"] == "List<Object>") && !found_field_types?seq_contains("List")>
	
		<#assign found_field_types = found_field_types + ["List"] />
		import java.util.List;
	
	</#if>
	
</#list>
</#compress>


@Data
@JsonDeserialize
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class ${consumerGeneratorModel.className} extends ${consumerGeneratorModel.parentClassName} {
	
	<#list consumerGeneratorModel.fields as field>
	@JsonProperty("${field["field_name"]}")
	<@compress_single_line>
		<#if ((field["is_static"])?? && field["is_static"] == "true") || 
				(field["field_type"] == "Jdbc4Array") || 
				(field["field_type"] == "PGobject")> 
				public static 
		<#else>
			private 
		</#if>
		<#if field["field_type"] == "List"> 
			${field["field_type"]}<#if field["data_type"]??><${field["data_type"]}></#if> 
		<#else>
			${field["field_type"]} 
		</#if>
		${field["java_field_name"]}; 
	</@compress_single_line>

	</#list>

}