package btrix24;

import btrix24.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
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
	static WebDriver driver = BrowserFactory.getDriver("chrome");

	public static void main(String[] args) {
		login();
		BrowserUtils.wait(1000);
		//uploadFilesAndImages_1();
		//	selectDocumentFromBitrix24_1();
		//selectContact();
		attachLink();
		//instertVideo();
		//createQuote();
		//addMention();
		//visualEditor();
		//messageTopic();
		//recordVideo();

	}

	public static void login() {

		Credentials obj = new Credentials();
		String userName = obj.getUserName(),
				passWord = obj.getPassWord();
		driver.get("https://login1.nextbasecrm.com/");
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys(userName);
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passWord);
		BrowserUtils.wait(1000);
		driver.findElement(By.xpath("//input[@class='login-btn']")).click();
	}
	//Acceptance Creteria 1

	public static void uploadFilesAndImages_1() {
		//clicking the message link under Activity Stream
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();
		BrowserUtils.wait(3000);
		driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm']")).click();
		BrowserUtils.wait(3000);

		//Location for the files to upload
		String filePath = "/Users/mehmetgul/Desktop/lambda.jpeg";
		//Choosing the target file to upload.
		driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys(filePath);

		/*
		//using action class to mouseOver on the element and clicking on the focused element.
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//input[@name='bxu_files[]']"))).click().build().perform();
		*/

		//Submiting the Message along with attachment
		//driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();
	}

	public static void selectDocumentFromBitrix24_1() {

	}

	public static void downloadFromExternalDrive_1() {

	}

	public static void createUsingDesktopApplications_1() {

	}

	//Acceptance Creteria 2
	public static void selectContact() {
		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();
		BrowserUtils.wait(1000);

		//Clicking the Add more or Add persons, groups or department
		driver.findElement(By.xpath("//a[@id='bx-destination-tag']")).click();
		BrowserUtils.wait(1000);

		//Choosing from recent employee (All employee)
		driver.findElement(By.xpath("//div[@class='bx-finder-box-item-t7-name']")).click();
		BrowserUtils.wait(1000);
		//After choosing, closing the open window by clicking the x in corner.
		driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();

		BrowserUtils.wait(2000);
		// Clicking the Add persons, groups or department and choosing from Emplooyees and Departments
		//Clicking the Add more or Add persons, groups or department
		driver.findElement(By.xpath("//a[@id='bx-destination-tag']")).click();
		BrowserUtils.wait(2000);

		//Clicking the Employees and Departments link
		driver.findElement(By.xpath("//a[contains(@id,'destDepartmentTab_')]")).click();
		BrowserUtils.wait(2000);
		//Choosing the multiple employees part need to think

		//Clicking E-mail users tab.
		driver.findElement(By.xpath("//a[contains(@id,'destEmailTab_')]")).click();
		BrowserUtils.wait(2000);

		//After choosing, closing the open window by clicking the x in corner.
		driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();

	}

	//Acceptance Creteria 3
	public static void attachLink() {

		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(5000);
		driver.findElement(By.xpath("//span[@id='bx-b-link-blogPostForm']")).click();
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text']")).sendKeys("This is Link text");
		driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']")).sendKeys("htpp://www.thisislinkurl.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();


	}

	//Acceptance Creteria 4
	public static void instertVideo() {

		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(5000);
		driver.findElement(By.xpath("//span[@id='bx-b-video-blogPostForm']")).click();
		BrowserUtils.wait(2000);

		//insertin video url
		driver.findElement(By.xpath("//input[@id='video_idPostFormLHE_blogPostForm-source']")).sendKeys("http://www.youtube.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();

	}

	//Acceptance Creteria 5
	public static void createQuote() {
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

	}


	//Acceptance Creteria 6

	public static void addMention(){
		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='bx-b-mention-blogPostForm']")).click();

		BrowserUtils.wait(2000);
		//Clicking the Employees and Departments link
		driver.findElement(By.xpath("//a[contains(@id,'destDepartmentTab_')]")).click();

	}

	//Acceptance Creteria 7
	public static void visualEditor(){

		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm']")).click();



	}


	//Acceptance Creteria 8
	public static void messageTopic(){

		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='lhe_button_title_blogPostForm']")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='POST_TITLE']")).sendKeys("This is my topic");

	}


	//Acceptance Creteria 9
	public static void recordVideo(){

		//Clicking the Message link
		driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//div[@id='divoPostFormLHE_blogPostForm']//span[@class='feed-add-post-form-but-cnt feed-add-videomessage'][contains(text(),'Record Video')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']")).click();


	}

}


