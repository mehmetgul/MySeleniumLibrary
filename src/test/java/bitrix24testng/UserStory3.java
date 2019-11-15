package bitrix24testng;

import bitrix24testng.login.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class UserStory3 {
	static WebDriver driver = BrowserFactory.getDriver("chrome");

	public static void main(String[] args) {
		login();
		//uploadImageAndFiles();
		//attachLink();
		//insertVideo();
		//insertQuote();
		//visualEditor();
		addEventAndSetReminder();
		//selectEventLocation();
		//addAttendies();
		//clickOnMoreToSpecifyEventDetails();

	}

	public static void login() {

		Credentials obj = new Credentials();
		String userName = obj.getUserName(),
				passWord = obj.getPassWord();
		driver.get("https://login1.nextbasecrm.com/");
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys("hr55@cybertekschool.com");
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser");
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@class='login-btn']")).click();
	}

	//"1. User should be able to click on upload files icon to upload files and pictures from local disks,
	// download from external drive, select documents from bixtrix24, and create files to upload.
	public static void uploadImageAndFiles(){
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

		BrowserUtils.wait(3000);
		driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm_calendar']")).click();
		BrowserUtils.wait(2000);

		//Location for the files to upload
		String filePath = "/Users/mehmetgul/Desktop/lambda.jpeg";
		//Choosing the target file to upload.
		driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys(filePath);


	}


	//2. User should be able to attach link by clicking on the link icon.
	public static void attachLink(){
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

		BrowserUtils.wait(3000);

		driver.findElement(By.xpath("//span[@id='bx-b-link-blogPostForm_calendar']")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='linkoCalEditorcal_3Jcl-text']")).sendKeys("This is Link text");

		driver.findElement(By.xpath("//input[@id='linkoCalEditorcal_3Jcl-href']")).sendKeys("htpp://www.thisislinkurl.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();
	}

	//4. User should be able to insert videos by clicking on the video icon and entering the video URL.
	public static void insertVideo(){
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

		BrowserUtils.wait(3000);

		driver.findElement(By.xpath("//span[@id='bx-b-video-blogPostForm_calendar']")).click();
		BrowserUtils.wait(2000);

		//insertin video url
		driver.findElement(By.xpath("//input[@id='video_oCalEditorcal_3Jcl-source']")).sendKeys("http://www.youtube.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();

	}

	//5. User should be able to create a quote by clicking on the Comma icon.
	public static void insertQuote(){
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

		BrowserUtils.wait(3000);

		driver.findElement(By.xpath("//span[@id='bx-b-quote-blogPostForm_calendar']")).click();

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
	public static void visualEditor(){
		BrowserUtils.wait(2000);
		//clicking the EVENT link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

		//Clicking the Visual Editor button
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm_calendar']")).click();

	}

	//7. User should be able to add Event start and ending date and time, and specify the time zone.
	//8. User should be able to set reminder by entering the timeing.
	public static void addEventAndSetReminder(){
		BrowserUtils.wait(2000);
		//clicking the EVENT link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

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

		WebElement element=driver.findElement(By.xpath("//input[@id='event-remindercal_3Jcl']"));
		if(!element.isEnabled()){
			element.click();
		}
		driver.findElement(By.xpath("//input[@id='event-remind_countcal_3Jcl']")).clear();
		driver.findElement(By.xpath("//input[@id='event-remind_countcal_3Jcl']")).sendKeys("60");


	}


	//9. User should be able to select event location from dropdown.
	public static void selectEventLocation(){
		BrowserUtils.wait(2000);
		//clicking the EVENT link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='event-locationcal_3Jcl']")).click();
		BrowserUtils.wait(2000);

		driver.findElement(By.xpath("//div[@id='bxecmr_2']")).click();


	}

	//10. User should be able to add attendees by selecting contacts individually or adding grups and departments.
	public static void addAttendies(){

		BrowserUtils.wait(2000);
		//clicking the EVENT link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

		BrowserUtils.wait(2000);
		//Clicking the Add more or Add persons, groups or department
		driver.findElement(By.xpath("//a[@id='feed-event-dest-add-link']")).click();
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
	public static void clickOnMoreToSpecifyEventDetails(){

		BrowserUtils.wait(2000);
		//clicking the EVENT link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='feed-event-more-link-text'][contains(text(),'More')]")).click();
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//*[@id=\"event-accessibilitycal_3Jcl\"]")).click();
		BrowserUtils.wait(2000);
		WebElement element= driver.findElement(By.xpath("//select[@id='event-accessibilitycal_3Jcl']"));

		//Click the free option
		driver.findElement(By.xpath("//select[@id='event-accessibilitycal_3Jcl']//option[contains(text(),'Free')]")).click();

	}

}
