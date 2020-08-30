<#assign count = 0 />
{
	"packageName": "${tsGeneratorModel.packageName}",
	"className": "${tsGeneratorModel.className}",
	"parentClassName": "${tsGeneratorModel.parentClassName}",
	
	"fields": [
		<#list tsGeneratorModel.fields as field>
		<#assign count = count + 1/>
		<#compress> {"field_name": "${field["name"]}", "field_type": "${field["type"]}"}<#if tsGeneratorModel.fields?size != count>, </#if> </#compress>
		</#list>
	]
}