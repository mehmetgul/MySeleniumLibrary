package bitrix24testng;

import bitrix24testng.login.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
//1. User should be able to click on upload files icon to upload files and pictures from local disks,
// download from external drive, select documents from bixtrix24, and create files to upload.
//2. User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
//3. User should be able to attach link by clicking on the link icon.
//4. User should be able to insert videos by clicking on the video icon and entering the video URL.
//5. User should be able to create a quote by clicking on the Comma icon.
//6. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
//7. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
//8. User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.
//9. User should be able to click on "Record Video" tab to record a video and attach it with the message.

public class UserStory1 {

	//global (instance) variables
	WebDriver driver = BrowserFactory.getDriver("chrome");
	String basedURL = "https://login1.nextbasecrm.com/";


	// locators
	//message tab xpath. This is required for all methods.
	String element = "//span[contains(text(),'Message')]";


	//Test Execution
	@BeforeTest(description = "Log in to the give URL")
	public void login() {
		uLogin();
	}

	@AfterTest(description = "Quiting the browser")
	public void quit() {
		BrowserUtils.wait(4000);
		driver.quit();
	}


	//Acceptance Criteria 1
	@Test(description = "User able to click use upload features under Message Tab")
	public void uploadFilesAndImages_1() {
		uploadingFilesAndImages_1("//span[@id='bx-b-uploadfile-blogPostForm']");

	}

	//Acceptance Criteria 1
	@Test(description = "User able to click use upload features under Message Tab")
	public void selectDocumentFromBitrix24_1() {
		selectingDocumentFromBitrix24_1("//span[@id='bx-b-uploadfile-blogPostForm']");

	}

	//Acceptance Criteria 1
	@Test(description = "User able to click use upload features under Message Tab")
	public void downloadFromExternalDrive_1() {
		downloadingFromExternalDrive_1();
	}

	//Acceptance Criteria 1
	@Test(description = "User able to click use upload features under Message Tab")
	public void createUsingDesktopApplications_1() {
		creatingUsingDesktopApplications_1();
	}

	//Acceptance Criteria 2
	@Test(description = "User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.")
	public void selectContact() {

		//Clicking the Add more or Add persons, groups or department
		String e2 = "//a[@id='bx-destination-tag']";

		//Choosing from recent employee (All employee)
		String e3 = "//div[@class='bx-finder-box-item-t7-name']";

		//After choosing, closing the open window by clicking the x in corner.
		String e4 = "//span[@class='popup-window-close-icon']";

		// Clicking the Add persons, groups or department and choosing from Emplooyees and Departments
		//Clicking the Add more or Add persons, groups or department
		String e5 = "//a[@id='bx-destination-tag']";

		//Clicking the Employees and Departments link
		String e6 = "//a[contains(@id,'destDepartmentTab_')]";

		//Choosing the multiple employees part need to think
		//Clicking E-mail users tab.
		String e7 = "//a[contains(@id,'destEmailTab_')]";

		//After choosing, closing the open window by clicking the x in corner.
		String e8 = "//span[@class='popup-window-close-icon']";

		selectingContact(e2, e3, e4, e5, e6, e7, e8);

	}

	//Acceptance Criteria 3
	@Test(description = "User should be able to attach link by clicking on the link icon.")
	public void attachLink() {
		attachingLink();


	}

	//Acceptance Criteria 4
	@Test(description = " User should be able to insert videos by clicking on the video icon and entering the video URL.")
	public void instertVideo() {

		instertingVideo();

	}

	//Acceptance Criteria 5
	@Test(description = "User should be able to create a quote by clicking on the Comma icon.")
	public void createQuote() {
		creatingQuote();
	}

	//Acceptance Criteria 6
	@Test(description = " User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.")
	public void addMention() {
		addingMention();

	}

	//Acceptance Criteria 7
	@Test(description = "User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.")
	public void visualEditor() {
		clickVisualEditor();
	}

	//Acceptance Criteria 8
	@Test(description = "User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.")
	public void messageTopic() {
		messagingTopic();
	}

	//Acceptance Criteria 9
	@Test(description = " User should be able to click on \"Record Video\" tab to record a video and attach it with the message.")
	public void recordVideo() {
		recordingVideo();
	}


	// methods

	public void uLogin() {

		Credentials obj = new Credentials();
		obj.userRole("helpdesk");
		String userName = obj.getUserName(),
				passWord = obj.getPassWord();
		driver.get(basedURL);
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys(userName);
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passWord);
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@class='login-btn']")).click();
	}

	public void clickFunction(String element) {

		//clicking the message link under Activity Stream
		driver.findElement(By.xpath(element)).click();
	}

	public void uploadingFilesAndImages_1(String element2) {
		//clicking the message link under Activity Stream
		clickFunction(element);
		BrowserUtils.wait(3000);
		clickFunction(element2);
		// driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm']")).click();
		BrowserUtils.wait(3000);

		//Location for the files to upload
		String filePath = "/Users/mehmetgul/Desktop/lambda.jpeg";
		//Choosing the target file to upload.
		driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys(filePath);
//
	}

	public void selectingDocumentFromBitrix24_1(String element2) {
		BrowserUtils.wait(1000);
		clickFunction(element);
		BrowserUtils.wait(1000);
		clickFunction(element2);
		BrowserUtils.wait(1000);
		WebElement element3 = driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/span[1]/span[1]/span[1]"));
		element3.click();

		BrowserUtils.wait(1000);
		WebElement upload = driver.findElement(By.xpath("//div[contains(@class,'bx-file-dialog-content-wrap')]"));
		List<WebElement> listElement = upload.findElements(By.tagName("a"));
		for (int i = 0; i < listElement.size(); i++) {
			System.out.println(listElement.get(i).getText());
			if (listElement.get(i).getText().equalsIgnoreCase("lambda (1).jpeg")) {
				listElement.get(i).click();
				System.out.println(listElement.get(i).getText());
				break;
			}

		}
		BrowserUtils.wait(1000);

		driver.findElement(By.xpath("//span[contains(@class,'popup-window-button popup-window-button-accept')]")).click();
		BrowserUtils.wait(1000);
		element3.click();
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//div[contains(@class,'bx-file-dialog-tab-group')]//div[2]//a[1]")).click();
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Marketing and advertising')]")).click();
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//a[contains(@class,'bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file')]")).click();
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//span[contains(@class,'popup-window-button popup-window-button-accept')]")).click();
		BrowserUtils.wait(1000);
	}

	public void downloadingFromExternalDrive_1() {

	}

	public void creatingUsingDesktopApplications_1() {

	}

	public void selectingContact(String element2,
	                             String element3, String element4, String element5,
	                             String element6, String element7, String element8) {

		//Clicking the Message link
		clickFunction(element);
		BrowserUtils.wait(1000);

		//Clicking the Add more or Add persons, groups or department
		clickFunction(element2);
		BrowserUtils.wait(1000);

		//Choosing from recent employee (All employee)
		clickFunction(element3);
		BrowserUtils.wait(1000);

		//After choosing, closing the open window by clicking the x in corner.
		clickFunction(element4);
		BrowserUtils.wait(2000);

		// Clicking the Add persons, groups or department and choosing from Emplooyees and Departments
		//Clicking the Add more or Add persons, groups or department
		clickFunction(element5);
		BrowserUtils.wait(2000);

		//Clicking the Employees and Departments link
		clickFunction(element6);
		BrowserUtils.wait(2000);

		//Choosing the multiple employees part need to think
		//Clicking E-mail users tab.
		clickFunction(element7);
		BrowserUtils.wait(2000);

		//After choosing, closing the open window by clicking the x in corner.
		clickFunction(element8);

	}

	public void attachingLink() {

		//Clicking the Message link
		clickFunction(element);

		BrowserUtils.wait(5000);
		driver.findElement(By.xpath("//span[@id='bx-b-link-blogPostForm']")).click();
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text']")).sendKeys("This is Link text");
		driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']")).sendKeys("htpp://www.thisislinkurl.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();

//
	}

	public void instertingVideo() {

		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(3000);
		driver.findElement(By.xpath("//span[@id='bx-b-video-blogPostForm']")).click();
		//	BrowserUtils.wait(2000);

		//inserting video url
		BrowserUtils.wait(3000);
		driver.findElement(By.xpath("//input[@id='video_idPostFormLHE_blogPostForm-source']")).sendKeys("https://www.youtube.com/watch?v=FHh5f_1An4c");
		//	BrowserUtils.wait(2000);
		WebDriverWait dd = new WebDriverWait(driver, 10);
		dd.until(ExpectedConditions.visibilityOfElementLocated(By.className("adm-btn-save")));

		//driver.findElement(By.className("adm-btn-save")).click();
		//	BrowserUtils.wait(3000);
//
	}

	public void creatingQuote() {
		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='bx-b-quote-blogPostForm']")).click();

		WebElement frameSwitch = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
		BrowserUtils.wait(2000);

		//Switching to iframe to handle the blockquote.
		driver.switchTo().frame(frameSwitch);

		//sending the keys text to blockquote.
		driver.findElement(By.cssSelector("body:nth-child(2) > blockquote.bxhtmled-quote")).sendKeys("This is my quote");

		//Switching back to the default page.
		driver.switchTo().defaultContent();
		//

	}

	public void addingMention() {
		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='bx-b-mention-blogPostForm']")).click();

		BrowserUtils.wait(2000);
		//Clicking the Employees and Departments link
		driver.findElement(By.xpath("//a[contains(@id,'destDepartmentTab_')]")).click();
//
	}

	public void clickVisualEditor() {

		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm']")).click();
//

	}

	public void messagingTopic() {

		//Clicking the Message link
		clickFunction(element);

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='lhe_button_title_blogPostForm']")).click();
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='POST_TITLE']")).sendKeys("This is my topic");

	}

	public void recordingVideo() {

		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//div[@id='divoPostFormLHE_blogPostForm']//span[@class='feed-add-post-form-but-cnt feed-add-videomessage'][contains(text(),'Record Video')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']")).click();
//

	}


}

