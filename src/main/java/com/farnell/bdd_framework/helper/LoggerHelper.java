package com.farnell.bdd_framework.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	
	/**
	 * @Description Method to initiate Logger function
	 * @param Class
	 * @return Logger
	 */

	public static Logger getLogger(Class<?> cls) {

		PropertyConfigurator.configure("log4j.properties");

		return Logger.getLogger(cls);

	}

	public static void main(String [] args) {
			Logger log = Logger.getLogger(Logger.class);
			log.info("I am a test logger");
			
		}

}
