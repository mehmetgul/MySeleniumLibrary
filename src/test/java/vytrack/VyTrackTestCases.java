package vytrack;

import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrackTestCases {
	private WebDriver driver;
	private WebDriverWait wait;

	//!!!! BrowserUtils.wait(1000); My waiting time calculates in MILISECONDS. !!!!
	//if you are using SECONDS in your file. Change my miliseconds to seconds. Exp: 2000 to 2

	@BeforeTest
	public void setup() {
		driver = BrowserFactory.getDriver("chrome");
		//explicit wait
		wait = new WebDriverWait(driver, 10);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximize browser
		//driver.manage().window().maximize();
		driver.get("https://qa1.vytrack.com/");
		driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
		driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
		BrowserUtils.wait(5000);



	}

	@Test(description = "Verify that 'view', 'edit' and 'delete' options are available for each calendar event")
	public void testCase1Run() {
		testCase1();


	}

	@Test(description = "Verify that title column is displayed ")
	public void testCase2run() {
		testCase2();
	}

	@Test(description = "Verify that 'Save and Close','Save and New', and 'Save' options are available ")
	public void testCase3Run() {
		testCase3();
	}

	@Test(description = " Verify that 'All Calendar Events' page subtitle is displayed")
	public void testCase4Run() {
		testCase4();
	}

	@Test(description = "Verify that difference between end and start time is exactly 1 hour ")
	public void testCase5Run() {
		testCase5();
	}

	@Test(description = " Verify that end time is equals to 10:00pm when 9:00 PM start time is selected")
	public void testCase6Run() {
		testCase6();
	}

	@Test(description = " Verify taht 'All-Day Event' is selected and start/end time slots are not displayed")
	public void testCase7Run() {
		testCase7();

	}

	@Test(description = " Verify that Repeat checkbox is selected and that Daily checkbox selected by default")
	public void testCase8Run() {

		testCase8();

	}

	@Test(description = "After selecting Repeat,Repeat Every and Never button verify that summanry message is displayed ")
	public void testCase9Run() {
		testCase9();

	}

	@Test(description = " After selected Repeat, After 10 occurences Verify that the correct message is displayed")
	public void testCase10Run() {

		testCase10();

	}

	@Test(description = " After Selecting 'By Nov 18 2021' Verify that summary message is properly displayed")
	public void testCase11Run() {

		testCase11();

	}

	@Test(description = " After selecting Repeat, Weekly, Monday and Friday. Verify that summary message is correct")
	public void testCase12Run() {

		testCase12();

	}

	@AfterTest
	public void teardown() {
		BrowserUtils.wait(8000);
		driver.quit();
	}

// All test case codes are below //

	public void testCase1() {

		//Creating actions object to perform mouse hover
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);

		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(1000);

		// Narrowing the target location to make the mouse hover easier
		WebElement minimizeTheTarget = driver.findElement(By.xpath("//tr[13]//td[9]"));

		//we are using actions class to mouse hover on the target link.
		WebElement verifyViewEditDelete = minimizeTheTarget.findElement(By.className("dropdown-toggle"));
		a.moveToElement(verifyViewEditDelete).build().perform();

		BrowserUtils.wait(1000);

		// Narrowing the target location to make the mouse hover easier
		WebElement minimizeTheTargetView = driver.findElement(By.xpath("//tr[13]"));

		//To move our object to VIEW. we are using actions class to mouse hover on the target link.
		WebElement view = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-eye hide-text']"));
		a.moveToElement(view).build().perform();

		//Using Assert to verify that target is displayed.
		Assert.assertTrue(view.isDisplayed());
		BrowserUtils.wait(1000);

		//To move our object to EDIT. we are using actions class to mouse hover on the target link.
		WebElement edit = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"));
		a.moveToElement(edit).build().perform();

		//Using Assert to verify that target is displayed.
		Assert.assertTrue(edit.isDisplayed());
		BrowserUtils.wait(1000);

		//To move our object to DELETE. we are using actions class to mouse hover on the target link.
		WebElement delete = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"));
		a.moveToElement(delete).build().perform();

		//Using Assert to verify that target is displayed.
		Assert.assertTrue(delete.isDisplayed());
		BrowserUtils.wait(3000);

	}

	public void testCase2() {
		//Creating actions object to perform mouse hover
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(3000);

		//Clicking the Grid Setting
		driver.findElement(By.xpath("//i[@class='fa-cog hide-text']")).click();
		BrowserUtils.wait(3000);

		//counting the size of the table rows.
		List<WebElement> row = driver.findElements(By.xpath("//div[@class='toolbar']//tr//td[1]"));
		for (int i = 0; i < row.size(); i++) {
			BrowserUtils.wait(1000);

			WebElement name = driver.findElement(By.xpath("//div[@class='toolbar']//tr//td[1]"));

			//finding the name which is not Title and click the check box which is not Title.
			if (!row.get(i).getText().equalsIgnoreCase("Title")) {
				row.get(i).click();

			}
		}
		//Verifying the TITLE is available or not.
		String name = driver.findElement(By.xpath("//thead[@class='grid-header']//span[@class='grid-header-cell__label'][contains(text(),'Title')]")).getText();
		Assert.assertEquals(name, "TITLE");
		BrowserUtils.wait(8000);
	}

	public void testCase3() {
		//Creating actions object to perform mouse hover
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Exanding Save and Close button
		driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']")).click();
		BrowserUtils.wait(3000);

		//Verifiying Save And Close
		String saveAndClose = driver.findElement(By.xpath("//div[@class='container-fluid page-title']//li[1]")).getText();
		Assert.assertEquals(saveAndClose, "Save And Close");
		BrowserUtils.wait(1000);

		//Verifiying Save and New
		String saveAndNew = driver.findElement(By.xpath("//div[@id='container']//li[2]")).getText();
		Assert.assertEquals(saveAndNew, "Save And New");
		BrowserUtils.wait(1000);
		//Verifiying Save
		String save = driver.findElement(By.xpath("//div[@class='app-page__main']//li[3]")).getText();
		Assert.assertEquals(save, "Save");
		BrowserUtils.wait(2000);

	}

	public void testCase4() {
		//Creating actions object to perform mouse hover
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Clicking the Cancel Button
		driver.findElement(By.xpath("//a[contains(@class,'btn back icons-holder-text')]")).click();
		BrowserUtils.wait(3000);

		//Verifying the All Calendar Events test
		String verifyText = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();

		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='oro-subtitle']")));

		Assert.assertEquals(verifyText, "All Calendar Events");
	}

	public void testCase5() {
		//Creating actions object to perform mouse hover
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);


		//Clicking the first time.
		driver.findElement(By.xpath("//input[contains(@id,'time_selector_oro_calendar_event_form_start-uid')]")).click();
		BrowserUtils.wait(2);
		String firstTime = "";
		List<WebElement> ele = driver.findElements(By.xpath("//li[contains(@class,'timepicker')]"));
		for (int i = 0; i < ele.size(); i++) {
			//System.out.println(ele.get(i).getText());
			BrowserUtils.wait(50);

			//if the first time is equal to 10am then it clicks it and exiting the loop
			if (ele.get(i).getText().equalsIgnoreCase("9:00 AM")) {
				firstTime = ele.get(i).getText();
				ele.get(i).click();

				break;
			}
		}


		//To retrieve exact one hour difference, I will get the hour from start time and will add 1 to it
		// and after that will compare the expected and actual.
		int hour = 0;
		String amPm = "",expected="";

		// if the hour 2 digit (10:00 AM) using if block , and if the hour 1 digit(9:00 AM) then using else block
		if(!firstTime.substring(1,2).equals(":")){
			//parsing string to integer first.
			hour = Integer.parseInt(firstTime.substring(0, 2))+1;

			//Adding 1 to the hour and converting it to string again.
			expected = hour + firstTime.substring(2);
			System.out.println("If block run");
		}else {
			//parsing string to integer first.
			hour = Integer.parseInt(firstTime.substring(0, 1))+1;

			//Adding 1 to the hour and converting it to string again.
			expected = hour + firstTime.substring(1);
			System.out.println("else block run");
		}



		//clicking the second time value
		driver.findElement(By.xpath("//input[contains(@id,'time_selector_oro_calendar_event_form_end-uid')]")).click();
		BrowserUtils.wait(2);

		//getting the selected value and comparing it with expected.
		String actual=driver.findElement(By.xpath("//div[8]//li[contains(@class,'selected')]")).getText();
		Assert.assertEquals(actual,expected,"didn't find the expected.. try more");



	}

	public void testCase6() {

		//Creating actions object to perform mouse hover
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Selecting the 9.00 PM as starting time
		WebElement element = driver.findElement(By.xpath("//div[@class='fields-row']//input[contains(@name,'time_selector_oro_calendar_event_form_start-uid')]"));
		BrowserUtils.wait(1000);
		//clicking the time box to display the times.
		element.click();

		//creating list to retreive the total available times and clicking the desired ones.
		List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'ui-timepicker')]"));

		for (int i = 0; i < list.size() - 2; i++) {
			BrowserUtils.wait(300);
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equalsIgnoreCase("9:00 PM")) {
				Assert.assertEquals(list.get(i).getText(), "9:00 PM", "expected result 9pm");
				list.get(i).click();
				break;
			}
		}
		BrowserUtils.wait(3000);

		//Verifying the end time is equal to 10.00PM
		WebElement element10 = driver.findElement(By.xpath("//div[@class='fields-row']//input[contains(@name,'time_selector_oro_calendar_event_form_end-uid')]"));
		//clicking the time box to display the times.
		element10.click();

		//creating list to retreive the total available times and clicking the desired ones.
		List<WebElement> list1 = driver.findElements(By.xpath("//li[contains(@class,'ui-timepicker')]"));
		for (int i = 0; i < list1.size() - 2; i++) {
			if (list1.get(i).getText().equalsIgnoreCase("10:00 PM")) {
				Assert.assertEquals(list1.get(i).getText(), "10:00 PM", "expected result 9pm");
				list1.get(i).click();
				break;
			}
		}
		BrowserUtils.wait(3000);

	}

	public void testCase7() {
//Creating actions object to perform mouse hover
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Clicking the All-Day Event
		WebElement element = driver.findElement(By.xpath("//div[@class='controls']//input[contains(@id,'oro_calendar_event_form_allDay-uid-')]"));
		element.click();
		boolean b = element.isEnabled();
		boolean expected = true;
		Assert.assertEquals(b, expected, "expected true");
		System.out.println("Actual value : " + b);
		BrowserUtils.wait(3000);

	}

	public void testCase8() {
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Select Repeat
		WebElement element = driver.findElement(By.xpath("//div[@class='controls']//input[contains(@id,'recurrence-repeat-view')]"));
		element.click();

		// Verify Repeat checkbox is selected
		boolean b = element.isEnabled();
		boolean expected = true;
		Assert.assertEquals(b, expected, "expected true");
		System.out.println("Actual value : " + b);
		BrowserUtils.wait(1000);

		//Verify Daily is selected by default available options in Repeats
		driver.findElement(By.xpath("//select[contains(@id,'recurrence-repeats-view')]")).click();
		List<WebElement> we = driver.findElements(By.xpath("//select[contains(@id,'recurrence-repeats-view')]"));

		for (int i = 0; i < we.size(); i++) {
			System.out.println(we.get(i).getText());
		}
		BrowserUtils.wait(3000);


	}

	public void testCase9() {
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Select Repeat
		WebElement element = driver.findElement(By.xpath("//div[@class='controls']//input[contains(@id,'recurrence-repeat-view')]"));
		element.click();

		// Verify Repeat checkbox is selected
		boolean b = element.isEnabled();
		boolean expected = true;
		Assert.assertEquals(b, expected, "expected true");
		BrowserUtils.wait(1000);

		//Verify Daily is selected by default available options in Repeats
		driver.findElement(By.xpath("//select[contains(@id,'recurrence-repeats-view')]")).click();

		BrowserUtils.wait(1000);

		//Verifying the radio button is selected as "Never"
		WebElement radioButtonVerify = driver.findElement(By.xpath("//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//div[1]//label[1]//input[1]"));
		boolean bool = radioButtonVerify.isEnabled();
		boolean expect = true;
		Assert.assertEquals(bool, expect, "expected true");

		BrowserUtils.wait(1000);
		// verifying Summary: Daily every 1 day is displayed.

		String el = driver.findElement(By.xpath("//div[@class='control-group recurrence-summary alert-info']")).getText();
		System.out.println(el);
		System.out.println("===============");

		String expSummary = "Summary:\n" + "Daily every 1 day";
		Assert.assertEquals(el, expSummary, "expected true");
		BrowserUtils.wait(3000);
	}

	public void testCase10() {
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Select Repeat
		WebElement element = driver.findElement(By.xpath("//div[@class='controls']//input[contains(@id,'recurrence-repeat-view')]"));
		element.click();

		BrowserUtils.wait(1000);

		//Selecting After and entering 10 as a occurrence
		WebElement clickAfterRadioButton = driver.findElement(By.xpath("//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//label[@class='fields-row']//input[1]"));
		clickAfterRadioButton.click();

		//Clicking the After and entering 10.
		WebElement narrowTheTarget = driver.findElement(By.xpath("//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//label[@class='fields-row']"));
		narrowTheTarget.findElement(By.className("recurrence-subview-control__number")).sendKeys("10");
		narrowTheTarget.findElement(By.className("recurrence-subview-control__number")).sendKeys(Keys.ENTER);

		BrowserUtils.wait(1000);

		//Verifying the Summary: Daily every 1 day, end after 10 occurrences displayed.
		String summaryDisplay = driver.findElement(By.xpath("//div[@class='control-group recurrence-summary alert-info']")).getText();
		String expSummary = "Summary:\n" + "Daily every 1 day, end after 10 occurrences";
		Assert.assertEquals(summaryDisplay, expSummary, "expected somtehing");
		BrowserUtils.wait(3000);

	}

	public void testCase11() {
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Select Repeat checkbox
		WebElement element = driver.findElement(By.xpath("//div[@class='controls']//input[contains(@id,'recurrence-repeat-view')]"));
		element.click();

		BrowserUtils.wait(1000);

		//Select By Nov 18, 2021
		//Clicking the "By" radio button
		driver.findElement(By.xpath("//div[@class='recurrence-subview-control__item recurrence-subview-control__item-datetime']//label//input")).click();

		//To Click datepicker, first i minimize the target location to write the locator more easy. Clicking the date picker
		WebElement narrowDatePicker = driver.findElement(By.xpath("//div[@class='recurrence-subview-control__item recurrence-subview-control__item-datetime']"));
		narrowDatePicker.findElement(By.xpath("//input[contains(@id,'dp')]")).click();

		BrowserUtils.wait(1000);
		//clicking the year and going down to 2021
		narrowDatePicker.findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();


		BrowserUtils.wait(2000);
		//When a date used in <select></select> tag then we need to use the Select class.
		Select option = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")));

		// we are selecting the value which is equal to 2021
		option.selectByValue("2021");

		BrowserUtils.wait(2000);
		//after choosing the year we are clicking the month.
		driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).click();
		BrowserUtils.wait(2000);
		// Again using select class to choose the month.
		Select option2 = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")));

		//selecting the month value which is 10 (November)
		option2.selectByValue("10");

		// choosing the date 18.
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[5]/a")).click();
		BrowserUtils.wait(2000);

		WebElement print = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']"));
		System.out.println(print.getText());
		Assert.assertEquals(print.getText(),"Summary:\n" + "Daily every 1 day, end by Nov 18, 2021", " You are failed, Try harder!!");


	}

	public void testCase12() {


		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(2000);

		//Clicking the Create Calendar Event button
		//Explicit Wait to element to load.
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")));
		driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]")).click();
		BrowserUtils.wait(3000);

		//Select Repeat checkbox
		WebElement element = driver.findElement(By.xpath("//div[@class='controls']//input[contains(@id,'recurrence-repeat-view')]"));
		element.click();

		BrowserUtils.wait(1000);



		//Using select class and choosing WEEKLY option from menu.
		Select opt = new Select(driver.findElement(By.xpath("//*[contains(@class,'recurrence-repeats')]")));
		opt.selectByValue("weekly");

		BrowserUtils.wait(2000);
		// Selecting the Monday and Friday
		driver.findElement(By.xpath("//input[contains(@value,'monday')]")).click();

		BrowserUtils.wait(1000);
		//clicking the friday
		driver.findElement(By.xpath("//input[contains(@value,'friday')]")).click();



		//Verify the Summary
		WebElement print = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']"));
		System.out.println(print.getText());
		Assert.assertEquals(print.getText(),"Summary:\n" + "Weekly every 1 week on Monday, Friday", " You are failed, Try harder!!");

	}




}
