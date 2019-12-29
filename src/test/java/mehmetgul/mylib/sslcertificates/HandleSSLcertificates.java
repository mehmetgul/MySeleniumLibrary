package mehmetgul.mylib.sslcertificates;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandleSSLcertificates {
	//SSL certificates

	public static void main(String[] args) {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		//dc.acceptInsecureCerts();

		//This will make our browser to accept insecure and SSL cert problem websites.
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

		//Below is our local browser
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);



	}
}
