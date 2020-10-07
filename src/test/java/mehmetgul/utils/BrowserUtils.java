package utils;

public class BrowserUtils {


	//It will be used to pause our test execution
	//just provide number of miliseconds as a parameter
	/**
	 * This method will put on pause execution
	 * @param   miliseconds
	 */
	public static void wait(int miliseconds){
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
