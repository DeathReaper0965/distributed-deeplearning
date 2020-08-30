package com.distributedDL.streaming.core;

import java.io.File;
import java.io.IOException;

import com.distributedDL.streaming.common.CommonUtils;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import lombok.Data;

@Data
@SuppressWarnings("rawtypes")
public abstract class BaseGenerator<T> {
	public final Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);

	public BaseGenerator generatorTemplate = null;

	public T generatorModel;

	public String templatePath = CommonUtils.getTemplatepath();

	public String generatePath = null;
	
	public BaseGenerator(T obj) throws IOException {
		/* ------------------------------------------------------------------------ */
		/* You should do this ONLY ONCE in the whole application life-cycle: */

		/* Create and adjust the configuration singleton */
		
		this.setGeneratorModel(obj);
		
		cfg.setDirectoryForTemplateLoading(new File(this.getTemplatePath()));

		// Recommended settings for new projects: 
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		cfg.setFallbackOnNullLoopVariable(false);
	}
	
	public abstract void generate() throws Exception;
}
