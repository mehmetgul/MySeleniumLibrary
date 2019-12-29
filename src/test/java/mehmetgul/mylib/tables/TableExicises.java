package mehmetgul.mylib.tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TableExicises {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		WebDriver driver=BrowserFactory.getDriver("chrome");
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
		BrowserUtils.wait(2000);
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		//int rowcount = table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		BrowserUtils.wait(2000);
		for (int i = 0; i < count - 2; i++) {
			String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int valueinteger = Integer.parseInt(value);
			sum = sum + valueinteger;//103

		}
		//System.out.println(sum);
		BrowserUtils.wait(2000);
		String Extras = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();

		int extrasValue = Integer.parseInt(Extras);
		int TotalSumValue = sum + extrasValue;
		System.out.println(TotalSumValue);

		BrowserUtils.wait(2000);
		String ActualTotal = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int ActualTotalVAlue = Integer.parseInt(ActualTotal);
		if (ActualTotalVAlue == TotalSumValue) {
			System.out.println("Count Matches");
		} else {
			System.out.println("count fails");
		}
	}
}