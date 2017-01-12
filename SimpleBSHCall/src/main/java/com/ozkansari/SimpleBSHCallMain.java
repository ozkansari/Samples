package com.ozkansari;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import bsh.EvalError;
import bsh.TargetError;

public class SimpleBSHCallMain {

	private static final Logger LOGGER = Logger.getLogger(SimpleBSHCallMain.class);
	
	private static final String BSH_LOGGER_VAR_NAME = "logger";
	
	public static void main(String[] args) {
		
		// Set a variableMap to use inside BSH
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("message", "Hello world");
		
		// Set an output map to receive from BSH
		Map<String, String> outputMap = new HashMap<String, String>();
		variableMap.put("outputMap", outputMap);
		
		// Execute BSH
		URL resource = FileBshSource.class.getClassLoader().getResource("simple.bsh");
		String bshFile = resource.getFile();
		boolean success = execute(bshFile, "eval", variableMap);
		LOGGER.debug(bshFile + " executed with result " + success );
		
		// Get output
		LOGGER.info("Output from BSH: ");
		if (!outputMap.isEmpty()) {
			for (Entry<String, String> o : outputMap.entrySet()) {
				LOGGER.info(o.getKey() + " --> " + o.getValue());
			}
			
		}
		
		
	}

	public static boolean execute(String bshAbsoluteFileName, String methodName, Map<String, Object> variableMap) {
		return execute(new FileBshSource(bshAbsoluteFileName), methodName, variableMap);
	}
	
	public static boolean execute(IBshSource bshSource, String methodName, Map<String, Object> variableMap) {
		try {
			bsh.Interpreter bsh = new bsh.Interpreter();
			bsh.eval(bshSource.getReader());
			bsh.set(BSH_LOGGER_VAR_NAME, LOGGER);

			for (Map.Entry<String, Object> entry : variableMap.entrySet()) {
				bsh.set(entry.getKey(), entry.getValue());
			}

			bsh.eval(methodName + "()");
			
			return true;
			
		} catch (TargetError e) {
			LOGGER.error(
					"BSH Target Error:" + bshSource.getIdentifier() + " localizedMessage:" + e.getLocalizedMessage()
					+ ":" + e.getErrorText() + ":" + e.getErrorSourceFile() + ":" + e.getErrorLineNumber(),
					e.getTarget());
		} catch (EvalError e) {
			LOGGER.error("BSH file evalution exception:" + bshSource.getIdentifier(), e);
		} catch (IOException e) {
			LOGGER.error("BSH IOException:" + bshSource.getIdentifier(), e);
		}
		return false;
	}
	
	
	
	

}
