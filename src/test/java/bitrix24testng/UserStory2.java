package bitrix24testng;

import bitrix24testng.login.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class UserStory2 {
	static WebDriver driver = BrowserFactory.getDriver("chrome");

	public static void main(String[] args) {

		login();

		//highPriority();
		//displayVisualEditor();
		//uploadFilesAndImage();
		//createQuote();
		//addMention();
		//attachLink();
		//chekclistItems();
		//assignTaskViaAddMoreButton();
		//deadlineByDatePicker();
		specifyTaskDetailsViaMoreButton();


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

	//Acceptance Cretiria 1
	// User should be able to click on "High Priority" checkbox to set the current task to a top priority task.
	public static void highPriority() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		//Clicking the check box to check the high priority
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='tasks-task-priority-cb']")).click();
	}

	//Acceptance Cretiria 2
	// User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
	public static void displayVisualEditor() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		//Clicking the Visual Editor button
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='lhe_button_editor_task-form-lifefeed_task_form']")).click();
	}


	//Acceptance Cretiria 3
	// User should be able to click on upload files icon to upload files and pictures from local disks,
	// download from external drive, select documents from bixtrix24, and create files to upload.
	public static void uploadFilesAndImage() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		BrowserUtils.wait(4000);
		driver.findElement(By.xpath("//*[@id=\"bx-b-uploadfile-task-form-lifefeed_task_form\"]")).click();
		BrowserUtils.wait(1000);

		//Location for the files to upload
		String filePath = "/Users/mehmetgul/Desktop/lambda.jpeg";
		//Choosing the target file to upload.
		driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys(filePath);

	}

	//Acceptance Cretiria 4
	// User should be able to create a quote by clicking on the Comma icon.
	public static void createQuote() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='bx-b-quote-task-form-lifefeed_task_form']")).click();

		//Creating webelement for swithcinh to iframe.
		WebElement frameSwitch = driver.findElement(By.xpath("//*[@id=\"bx-html-editor-iframe-cnt-lifefeed_task_form\"]/iframe"));
		BrowserUtils.wait(2000);

		//Switching to iframe to handle the blockquote.
		driver.switchTo().frame(frameSwitch);

		//sending the keys text to blockquote.
		driver.findElement(By.cssSelector("body:nth-child(2) > blockquote.bxhtmled-quote")).sendKeys("This is my quote");

		//Switching back to the default page.
		driver.switchTo().defaultContent();
	}


	//Acceptance Cretiria 5
	//5. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
	public static void addMention() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@id='bx-b-mention-task-form-lifefeed_task_form']")).click();
		//span[@id='bx-b-mention-task-form-lifefeed_task_form']

		BrowserUtils.wait(2000);
		//Clicking the Employees and Departments link
		driver.findElement(By.xpath("//a[contains(@id,'destDepartmentTab_')]")).click();
	}

	//Acceptance Cretiria 6
	//6. User should be able to attach link by clicking on the link icon.
	public static void attachLink() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		BrowserUtils.wait(5000);
		driver.findElement(By.xpath("//span[@id='bx-b-link-task-form-lifefeed_task_form']")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='linklifefeed_task_form-text']")).sendKeys("This is Link text");

		driver.findElement(By.xpath("//input[@id='linklifefeed_task_form-href']")).sendKeys("htpp://www.thisislinkurl.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();
	}

	//Acceptance Cretiria 7
	//7. User should be able to click on "Checklist" to create checklists items(Things to do). User can add a checklist item by clicking
	// on add button or check mark. User can add separator lines between checklist items. User can delete a checklist item by clicking on x mark.
	public static void chekclistItems() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='tasks-task-mpf-link']")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='task-checklist-form-vpadding']//input[@placeholder='Things to do']")).sendKeys("To do 1");

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']")).click();

	}

	//Acceptance Cretiria 8
	//8. User can assign the tasks to employees by clicking on Add More and selecting contact from E-mail user, Employees and Departments and
	// Recent contact lists. Employees can be added in different assignment categories: Created By, Participants and Observer.
	public static void assignTaskViaAddMoreButton() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form-responsible\"]/span[2]/a[1]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[contains(@id,'destEmailTab_')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[contains(@id,'destDepartmentTab_')]")).click();


	}

	//Acceptance Cretiria 9
	//9. User can add Deadline, Time Planningby using date pickers.
	public static void deadlineByDatePicker() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='task-options-destination-wrap date']//input[@class='task-options-inp']")).click();

		BrowserUtils.wait(2000);
		//Targetting December 22, 2019

		//a[@class='bx-calendar-top-month']
		while (!driver.findElement(By.cssSelector("[class='bx-calendar-top-month']")).getText().contains("January")) {
			//this will click till finding the moth April.
			driver.findElement(By.xpath("//a[@class='bx-calendar-right-arrow']")).click();
			BrowserUtils.wait(1000);

		}
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[@class='bx-calendar-cell'][contains(text(),'23')]")).click();


		//clicking the select button on date picker.
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='bx-calendar-button-text'][contains(text(),'Select')]")).click();


	}

	//Acceptance Cretiria 10
	//10. User can click on More to specify the task details.
	public static void specifyTaskDetailsViaMoreButton() {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//div[@class='task-additional-alt-more']")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[@class='js-id-add-project']")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='side-panel-close-inner']")).click();

	}


}
