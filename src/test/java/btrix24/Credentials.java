package btrix24;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

public class Credentials {
	private String userName = "hr55@cybertekschool.com";
	private String passWord = "UserUser";
	public String getUserName(){
		//returns username
		return userName;
	}
	public String getPassWord(){
		//returns password
		return passWord;
	}

}

