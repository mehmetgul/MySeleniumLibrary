package vytrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.Driver;

//we write extends TestBase to inherit @before and @after methods
//this class will be dedicated to tests related to Login page only
//we don't have to find elements here
//we should find elements in page classes only
public class LoginTests extends TestBase {
	@Test(description = "Verify that page title is a 'Dashboard'")
	public void test1(){
		//create page object
		LoginPage loginPage = new LoginPage();
		//call login method
		//provide username and password
		loginPage.login("storemanager85", "UserUser123");
		//verification stage
		//Driver.get() = driver same things
		//Driver.get() returns webdriver object
		WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
		//this is an explicit wait
		//it waits until title is 'Dashboard'
		wait.until(ExpectedConditions.titleIs("Dashboard"));
		Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
	}
}