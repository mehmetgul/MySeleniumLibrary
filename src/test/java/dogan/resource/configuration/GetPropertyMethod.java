package dogan.resource.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//ConfigurationReader.configFile.getProperty("browser") direct access
//ConfigurationReader.getProperty("browser")
public class GetPropertyMethod {
	//this class will be responsible for loading properties file and will provide access
	//to values based on key names
	//we use Properties class to load custom .properties files
	private static Properties configFile;
	static {
		try {
			//provides access to file
			//try/catch block stands for handling exceptions
			//if exception occurs, code inside a catch block will be executed
			//any class that is related to InputOutput produce checked exceptions
			//without handling checked exception, you cannot run a code
			FileInputStream fileInputStream = new FileInputStream("youtube.properties");
			//initialize properties object
			configFile = new Properties();
			//load configuration.properties file
			configFile.load(fileInputStream);
		} catch (IOException e) {
			System.out.println("Failed to load properties file!");
			e.printStackTrace();
		}
	}
	public static String getProperty(String key) {
		return configFile.getProperty(key);
	}
}