package com.australianopen.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private InputStream input = null;

	/**
	 * This method is used to load properties
	 * 
	 * @throws Exception
	 */
	public void loadProperties() throws Exception {
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.properties");
			properties = new Properties();
			properties.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method is used to get the value from properties file based on key
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getKey(String key) throws Exception {
		loadProperties();
		return properties.getProperty(key);
	}
}
