package bitrix24testng.login;

public class Credentials {
	private String userName = "";
	private String passWord = "";
	public String getUserName(){
		//returns username
		return userName;
	}
	public String getPassWord(){
		//returns password
		return passWord;
	}

	/**
	 * @param role
	 */
	public void userRole(String role){
		switch(role.toLowerCase()){
			case "helpdesk":
				userName = "helpdesk55@cybertekschool.com";
				passWord = "UserUser";
				break;
			case "marketing":
				userName = "marketing55@cybertekschool.com";
				passWord = "UserUser";
				break;
			case "hr":
				userName = "hr55@cybertekschool.com";
				passWord = "UserUser";
				break;
			default:
				userName = "helpdesk55@cybertekschool.com";
				passWord = "UserUser";
		}
		userRole(userName,passWord);
	}
	/**
	 * @param userName
	 * @param passWord
	 */
	public void userRole(String userName,String passWord){
		this.userName=userName;
		this.passWord=passWord;
	}

}
