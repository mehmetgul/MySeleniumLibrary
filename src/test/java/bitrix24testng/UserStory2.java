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

public class UserStory2 {
	//global (instance) variables
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	String basedURL = "https://login1.nextbasecrm.com/";


	// locators
	//Task tab xpath. This is required for all methods.
	String element = "//span[@id='feed-add-post-form-tab-tasks']//span[contains(text(),'Task')]";

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
	public void highPriority() {
		String element1 = "//input[@id='tasks-task-priority-cb']";
		uHighPriority(element1);
	}

	@Test
	public void displayVisualEditor() {
		String e1 = "//span[@id='lhe_button_editor_task-form-lifefeed_task_form']";
		uDisplayVisualEditor(e1);
	}

	@Test
	public void uploadFilesAndImage() {
		String e1="//*[@id=\"bx-b-uploadfile-task-form-lifefeed_task_form\"]";
		uUploadFilesAndImage(e1);
	}

	@Test
	public void createQuote() {
		String e1="//span[@id='bx-b-quote-task-form-lifefeed_task_form']";
		uCreateQuote(e1);
	}

	@Test
	public void addMention() {
		String e1="//span[@id='bx-b-mention-task-form-lifefeed_task_form']";
		uAddMention(e1);
	}

	@Test
	public void attachLink() {
		String e1="//span[@id='bx-b-link-task-form-lifefeed_task_form']";
		uAttachLink(e1);
	}

	@Test
	public void chekclistItems() {
		String e1="//span[@class='tasks-task-mpf-link']" ;
		uChekclistItems(e1);
	}

	@Test
	public void assignTaskViaAddMoreButton() {
		String e1="//*[@id=\"bx-component-scope-lifefeed_task_form-responsible\"]/span[2]/a[1]";
		uAssignTaskViaAddMoreButton(e1);
	}

	@Test
	public void deadlineByDatePicker() {
		String e1="//span[@class='task-options-destination-wrap date']//input[@class='task-options-inp']";
		uDeadlineByDatePicker(e1);
	}

	@Test
	public void specifyTaskDetailsViaMoreButton() {
		String e1="//div[@class='task-additional-alt-more']";
		uSpecifyTaskDetailsViaMoreButton(e1);
	}


	//Methods
	//Login
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


	//Acceptance Cretiria 1
	// User should be able to click on "High Priority" checkbox to set the current task to a top priority task.
	public void uHighPriority(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		//Clicking the check box to check the high priority
		BrowserUtils.wait(2000);
		clickFunction(element1);
		//driver.findElement(By.xpath("//input[@id='tasks-task-priority-cb']")).click();
	}

	//Acceptance Cretiria 2
	// User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
	public void uDisplayVisualEditor(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		//Clicking the Visual Editor button
		BrowserUtils.wait(2000);
		clickFunction(element1);
		//driver.findElement(By.xpath("//span[@id='lhe_button_editor_task-form-lifefeed_task_form']")).click();
	}

	//Acceptance Cretiria 3
	// User should be able to click on upload files icon to upload files and pictures from local disks,
	// download from external drive, select documents from bixtrix24, and create files to upload.
	public void uUploadFilesAndImage(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(4000);
		clickFunction(element1);
		BrowserUtils.wait(1000);

		//Location for the files to upload
		String filePath = "/Users/mehmetgul/Desktop/lambda.jpeg";
		//Choosing the target file to upload.
		driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys(filePath);

	}

	//Acceptance Cretiria 4
	// User should be able to create a quote by clicking on the Comma icon.
	public void uCreateQuote(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(2000);
		clickFunction(element1);

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
	public void uAddMention(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(2000);
		clickFunction(element1);
		//span[@id='bx-b-mention-task-form-lifefeed_task_form']

		BrowserUtils.wait(2000);
		//Clicking the Employees and Departments link
		driver.findElement(By.xpath("//a[contains(@id,'destDepartmentTab_')]")).click();
	}

	//Acceptance Cretiria 6
	//6. User should be able to attach link by clicking on the link icon.
	public void uAttachLink(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(5000);
		clickFunction(element1);

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='linklifefeed_task_form-text']")).sendKeys("This is Link text");

		driver.findElement(By.xpath("//input[@id='linklifefeed_task_form-href']")).sendKeys("htpp://www.thisislinkurl.com");
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='undefined']")).click();
	}

	//Acceptance Cretiria 7
	//7. User should be able to click on "Checklist" to create checklists items(Things to do). User can add a checklist item by clicking
	// on add button or check mark. User can add separator lines between checklist items. User can delete a checklist item by clicking on x mark.
	public void uChekclistItems(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(2000);
		clickFunction(element1);

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='task-checklist-form-vpadding']//input[@placeholder='Things to do']")).sendKeys("To do 1");

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']")).click();

	}

	//Acceptance Cretiria 8
	//8. User can assign the tasks to employees by clicking on Add More and selecting contact from E-mail user, Employees and Departments and
	// Recent contact lists. Employees can be added in different assignment categories: Created By, Participants and Observer.
	public void uAssignTaskViaAddMoreButton(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(2000);
		clickFunction(element1);

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[contains(@id,'destEmailTab_')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[contains(@id,'destDepartmentTab_')]")).click();


	}

	//Acceptance Cretiria 9
	//9. User can add Deadline, Time Planningby using date pickers.
	public void uDeadlineByDatePicker(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(2000);
		clickFunction(element1);

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
	public void uSpecifyTaskDetailsViaMoreButton(String element1) {
		BrowserUtils.wait(2000);
		//clicking the TASK link
		clickFunction(element);

		BrowserUtils.wait(2000);
		clickFunction(element1);

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[@class='js-id-add-project']")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//span[@class='side-panel-close-inner']")).click();

	}


}
