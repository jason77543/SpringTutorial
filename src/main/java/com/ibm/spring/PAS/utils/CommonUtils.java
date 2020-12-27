package com.ibm.spring.PAS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {

	public Properties getConfig(String target) {
		Properties prop = new Properties();
		InputStream input = this.getClass().getResourceAsStream("/"+target);
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
