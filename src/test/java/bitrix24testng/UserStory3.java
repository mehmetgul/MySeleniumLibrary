package bitrix24testng;

import bitrix24testng.login.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class UserStory3 {
	//global (instance) variables
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	String basedURL = "https://login1.nextbasecrm.com/";
	// locators
	//Task tab xpath. This is required for all methods.
	String e1, element = "//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]";

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

	@Test
	public void uploadImageAndFiles() {
		e1 = "//span[@id='bx-b-uploadfile-blogPostForm_calendar']";
		uUploadImageAndFiles(e1);
	}

	@Test
	public void attachLink() {
		e1 = "//span[@id='bx-b-link-blogPostForm_calendar']";
		attachLink(e1);

	}

	@Test
	public void insertVideo() {
		e1 = "//span[@id='bx-b-video-blogPostForm_calendar']";
		insertVideo(e1);
	}

	@Test
	public void insertQuote() {
		e1 = "//span[@id='bx-b-quote-blogPostForm_calendar']";
		insertQuote(e1);
	}

	@Test
	public void visualEditor() {
		e1 = "//span[@id='lhe_button_editor_blogPostForm_calendar']";
		visualEditor(e1);

	}

	@Test
	public void addEventAndSetReminder() {
		uAddEventAndSetReminder();

	}

	@Test
	public void selectEventLocation() {
		e1 = "//input[@id='event-locationcal_3Jcl']";
		selectEventLocation(e1);

	}

	@Test
	public void addAttendies() {
		e1 = "//a[@id='feed-event-dest-add-link']";
		addAttendies(e1);
	}

	@Test
	public void clickOnMoreToSpecifyEventDetails() {
		e1 ="//span[@class='feed-event-more-link-text'][contains(text(),'More')]";
		clickOnMoreToSpecifyEventDetails(e1);

	}

	//Methods
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
		//clicking the Task link under Activity Stream
		driver.findElement(By.xpath(element)).click();
	}


	//"1. User should be able to click on upload files icon to upload files and pictures from local disks,
	// download from external drive, select documents from bixtrix24, and create files to upload.
	public void uUploadImageAndFiles(String e1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);
		BrowserUtils.wait(3000);
		clickFunction(e1);
		BrowserUtils.wait(2000);

		//Location for the files to upload
		String filePath = "/Users/mehmetgul/Desktop/lambda.jpeg";
		//Choosing the target file to upload.
		driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys(filePath);


	}


	//2. User should be able to attach link by clicking on the link icon.
	public void attachLink(String e1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(3000);
		clickFunction(e1);

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='linkoCalEditorcal_3Jcl-text']")).sendKeys("This is Link text");

		driver.findElement(By.xpath("//input[@id='linkoCalEditorcal_3Jcl-href']")).sendKeys("htpp://www.thisislinkurl.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();
	}

	//4. User should be able to insert videos by clicking on the video icon and entering the video URL.
	public void insertVideo(String e1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(3000);

		clickFunction(e1);
		driver.findElement(By.xpath("")).click();
		BrowserUtils.wait(2000);

		//insertin video url
		driver.findElement(By.xpath("//input[@id='video_oCalEditorcal_3Jcl-source']")).sendKeys("http://www.youtube.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();

	}

	//5. User should be able to create a quote by clicking on the Comma icon.
	public void insertQuote(String e1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(3000);

		clickFunction(e1);

		//Creating webelement for swithcinh to iframe.
		WebElement frameSwitch = driver.findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-oCalEditorcal_3Jcl']//iframe[@class='bx-editor-iframe']"));

		BrowserUtils.wait(2000);

		//Switching to iframe to handle the blockquote.
		driver.switchTo().frame(frameSwitch);

		//sending the keys text to blockquote.
		driver.findElement(By.cssSelector("body:nth-child(2) > blockquote.bxhtmled-quote")).sendKeys("This is my quote");

		//Switching back to the default page.
		driver.switchTo().defaultContent();

	}


	//6. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
	public void visualEditor(String e1) {
		BrowserUtils.wait(2000);
		//clicking the EVENT link
		clickFunction(element);

		//Clicking the Visual Editor button
		BrowserUtils.wait(2000);
		clickFunction(e1);

	}

	//7. User should be able to add Event start and ending date and time, and specify the time zone.
	//8. User should be able to set reminder by entering the timeing.
	public void uAddEventAndSetReminder() {
		BrowserUtils.wait(2000);
		//clicking the EVENT link
		clickFunction(element);

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='feed-cal-event-namecal_3Jcl']")).sendKeys("We have event.. please come");

		BrowserUtils.wait(2000);
		WebElement frameSwitch = driver.findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-oCalEditorcal_3Jcl']//iframe[@class='bx-editor-iframe']"));
		driver.switchTo().frame(frameSwitch);
		driver.findElement(By.xpath("//html//body")).sendKeys("Our event will be on Selenium");
		driver.switchTo().defaultContent();


		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='feed-cal-event-fromcal_3Jcl']")).click();

		BrowserUtils.wait(2000);
		//Targetting December 22, 2019

		//a[@class='bx-calendar-top-month']
		while (!driver.findElement(By.cssSelector("[class='bx-calendar-top-month']")).getText().contains("November")) {
			//this will click till finding the moth April.
			driver.findElement(By.xpath("//a[@class='bx-calendar-right-arrow']")).click();
			BrowserUtils.wait(1000);

		}
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[contains(text(),'21')]")).click();


		//choosing time
		driver.findElement(By.xpath("//input[@id='feed_cal_event_from_timecal_3Jcl']")).click();
		BrowserUtils.wait(2000);

		//clicking the hours up button
		driver.findElement(By.xpath("//div[@id='feed_cal_event_from_timecal_3Jcl_div']//table[1]//tbody[1]//tr[1]//td[2]")).click();
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//div[@id='feed_cal_event_from_timecal_3Jcl_div']//table[1]//tbody[1]//tr[1]//td[2]")).click();

		BrowserUtils.wait(2000);
		//Clicking the minutes down button
		driver.findElement(By.xpath("//table[2]//tbody[1]//tr[2]//td[1]")).click();
		driver.findElement(By.xpath("//table[2]//tbody[1]//tr[2]//td[1]")).click();
		driver.findElement(By.xpath("//table[2]//tbody[1]//tr[2]//td[1]")).click();
		driver.findElement(By.xpath("//table[2]//tbody[1]//tr[2]//td[1]")).click();

		driver.findElement(By.xpath("//body[@class='template-bitrix24 no-paddings start-page bitrix24-default-theme']/div[@id='feed_cal_event_from_timecal_3Jcl_div']/div[@class='bxc-controls-cont']/input[1]")).click();


		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='event-locationcal_3Jcl']")).click();
		BrowserUtils.wait(2000);

		driver.findElement(By.xpath("//div[@id='bxecmr_2']")).click();

		//Setting up the Reminder

		WebElement element = driver.findElement(By.xpath("//input[@id='event-remindercal_3Jcl']"));
		if (!element.isEnabled()) {
			element.click();
		}
		driver.findElement(By.xpath("//input[@id='event-remind_countcal_3Jcl']")).clear();
		driver.findElement(By.xpath("//input[@id='event-remind_countcal_3Jcl']")).sendKeys("60");


	}


	//9. User should be able to select event location from dropdown.
	public void selectEventLocation(String e1) {
		BrowserUtils.wait(2000);
		//clicking the EVENT link
		clickFunction(element);

		BrowserUtils.wait(2000);
		clickFunction(e1);
		BrowserUtils.wait(2000);

		driver.findElement(By.xpath("//div[@id='bxecmr_2']")).click();


	}

	//10. User should be able to add attendees by selecting contacts individually or adding grups and departments.
	public void addAttendies(String e1) {

		BrowserUtils.wait(2000);
		//clicking the EVENT link
		clickFunction(element);

		BrowserUtils.wait(2000);
		//Clicking the Add more or Add persons, groups or department
		clickFunction(e1);
		BrowserUtils.wait(1000);

		//Choosing from recent employee (All employee)
		driver.findElement(By.xpath("//a[@id='destLastTab_calnAJEM3']")).click();
		BrowserUtils.wait(1000);

		//Clicking the Employees and Departments link
		driver.findElement(By.xpath("//a[@id='destDepartmentTab_calnAJEM3']")).click();
		BrowserUtils.wait(2000);

		//After choosing, closing the open window by clicking the x in corner.
		driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();


	}

	//11. Useer should be able to click on More to specify the event details.
	public void clickOnMoreToSpecifyEventDetails(String e1) {

		BrowserUtils.wait(2000);
		//clicking the EVENT link
		clickFunction(element);

		BrowserUtils.wait(2000);
		clickFunction(e1);
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//*[@id=\"event-accessibilitycal_3Jcl\"]")).click();
		BrowserUtils.wait(2000);
		WebElement element = driver.findElement(By.xpath("//select[@id='event-accessibilitycal_3Jcl']"));

		//Click the free option
		driver.findElement(By.xpath("//select[@id='event-accessibilitycal_3Jcl']//option[contains(text(),'Free')]")).click();

	}

}
