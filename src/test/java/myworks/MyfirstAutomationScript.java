package myworks;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MyfirstAutomationScript {

    public static void main(String[] args) {

        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        WebDriver driver = new SafariDriver();
        driver.get("http://www.google.com");
        //WebDriverManager.chromedriver().setup();
// changes
        //obj.findElement(By.id("email")).sendKeys("mehmetgul@gmail.com");
        //obj.findElement(By.name("pass")).sendKeys("4972137Gezgin!");
        //obj.findElement(By.xpath("//*[@id=\'u_0_2\']")).click();
        //obj.findElement(By.linkText("Forgot account?")).click();
        //obj.findElement(By.)
        //obj.close();
      /* obj.get("https://www.rediff.com");
       //obj.manage().window().fullscreen();
        obj.manage().window().maximize();
        obj.findElement(By.cssSelector("a[title*='Sign in']")).click();
        obj.findElement(By.xpath("//input[@id='login1']")).sendKeys("ddsdsdas@gmail.com");
       obj.findElement(By.cssSelector("input#password")).sendKeys("1234566");
        obj.findElement(By.xpath("//input[contains(@name,'procee')]")).click();
        obj.navigate().to("http://www.amazon.com");
        obj.navigate().back();
        String cUrl = obj.getCurrentUrl();
        System.out.println(cUrl);
*/
    }
}



