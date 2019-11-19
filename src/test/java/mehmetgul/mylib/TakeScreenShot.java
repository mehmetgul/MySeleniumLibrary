package mehmetgul.mylib;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
	public static void main(String[] args) throws IOException {
		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.manage().window().maximize();


		driver.get("http://www.google.com");

		//While working in windows don't give c: drive. You may face access permision to c drive.
		//you can place it under c drive inside the user folder.

		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("/Users/mehmetgul/Desktop/screenshot.jpg"));



	}
}
