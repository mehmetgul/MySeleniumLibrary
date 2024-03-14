package mehmetgul.mylib.logger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingLogs {

	/**
	 * To use logger in your project. add 2 dependency
	 * slf4j-api and logback-classic dependencies
	 * you can see the type of log details below
	 */
	//Logger objecti olusturuyoruz.
	Logger logger= LoggerFactory.getLogger(UsingLogs.class);

	@Test
	public void test(){
		logger.info("loggg");
		String title = "This is the title for home page";
		logger.info("We landed- {} -to Homepage ",title);
		logger.info("Another way of log  " +title + " fsdfsdfsd");
		logger.info("This is without parameter.");
		logger.warn("We are warning");
		logger.error("This is error");
		System.out.println("This is error");
	}


}
