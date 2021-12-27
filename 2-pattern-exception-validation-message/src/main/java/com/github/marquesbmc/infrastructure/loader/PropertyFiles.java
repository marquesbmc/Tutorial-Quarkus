package com.github.marquesbmc.infrastructure.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFiles {

	String result = "";
	InputStream inputStream = null;

	public String getPropValues(String mensagem) throws IOException {
		try {
			Properties prop = new Properties();
			String propFileName = "validation-messages.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			prop.load(inputStream);

			String msgValid = prop.getProperty(mensagem);

			result = msgValid;
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			inputStream.close();
		}
		return result;
	}
}
