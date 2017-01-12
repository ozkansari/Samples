package com.ozkansari;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.Version;

public class SimpleFTLCallMain {

	private static final Logger LOGGER = Logger.getLogger(SimpleFTLCallMain.class);
	
	public static void main(String[] args) throws Exception {

		// Set a variableMap to use inside BSH
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("message", "Hello world");
				
		URL resource = SimpleFTLCallMain.class.getClassLoader().getResource("simple.ftl");

		String templatePath = findFilePath(resource.getFile());
		String templateName = trimFilePath(resource.getFile());
		
		String result = execute(variableMap, templatePath, templateName);
		
		LOGGER.info("FTL Result: " + result);
		
	}

	public static String execute(Map<String, Object> dataModel,String templatePath, String templateName) throws Exception {
		
		dataModel.put("statics", BeansWrapper.getDefaultInstance().getStaticModels());
		
		Configuration fmConfig = initTemplate(templatePath);
		
		Iterator<Entry<String, Object>> iter = dataModel.entrySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next().getKey();
			fmConfig.setSharedVariable(key, dataModel.get(key));
		}
		
		Template template = fmConfig.getTemplate("simple.ftl");

		return processTemplate(dataModel, template);
	}

	/* --------------------------------------------------------- */
	/* INTERNAL METHOD(S) */
	/* --------------------------------------------------------- */
	
	/**
	 * @param templatePath
	 * @return
	 * @throws IOException
	 */
	private static Configuration initTemplate(String templatePath) throws IOException {
		Version version = new Version("2.3.25");
		Configuration fmConfig = new Configuration(version);
		fmConfig.setObjectWrapper(new DefaultObjectWrapper(version));
		fmConfig.setDefaultEncoding("ISO-8859-9");
		fmConfig.setWhitespaceStripping(true);
		// fmConfig.setTemplateLoader(new FileTemplateLoader());
		fmConfig.setDirectoryForTemplateLoading(new File(templatePath));
		
		return fmConfig;
	}

	/**
	 * @param dataModel
	 * @param template
	 * @return
	 */
	private static String processTemplate(Map<String, Object> dataModel,
			Template template) {
		if (template == null) {
			throw new IllegalArgumentException(
					"No template is set for FreeMarker!");
		}
		StringWriter sw = null;
		try {
			sw = new StringWriter();
			template.process(dataModel, sw);
			sw.flush();
			return sw.toString();
		} catch (Exception e) {

		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e) {

				}
			}
			sw = null;
		}
		return null;
	}
	
	/* --------------------------------------------------------- */
	/* HELPER METHOD(S) */
	/* --------------------------------------------------------- */
	
	private static String findFilePath(String absFileName) {
		String fileName = trimFilePath(absFileName);
		if (fileName.equals(absFileName)) {
			return "";
		}
		return absFileName.substring(0, absFileName.length() - fileName.length());
	}
	
	private static String trimFilePath(String absoluteFileName) {
		int sep1 = absoluteFileName.lastIndexOf('/');
		int sep2 = absoluteFileName.lastIndexOf('\\');
		int maxSep = sep1 > sep2 ? sep1 : sep2;
		if (maxSep < 0) {
			return absoluteFileName;
		}
		return absoluteFileName.substring(maxSep + 1);
	}
	

}
