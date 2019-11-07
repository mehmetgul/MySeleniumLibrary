package tests.gmail;

import org.apache.commons.mail.SimpleEmail;

public class SendEmails {


       /*
            first Step:
                go to  :
                     https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web
                        Make sure that your google account allows third part app
         */

	public static void main(String[] args) {
		Credentials obj = new Credentials();
		String userName = obj.getUserName(),
				passWord = obj.getPassWord(),
				MSG = "Hi Mehmet gul",
				Subject = "This is from MEhmet";


		String[] Receivers = {"mehmetgulusa@gmail.com", "mehmetgul@gmail.com"};

		int times = 3;
		while (times > 0) {

			for (String students : Receivers) {
				sendEmails(userName, passWord, students, MSG, Subject);
				System.out.println("Send successfully");
			}

			times--;
		}


	}


	public static void sendEmails(String username, String password, String Receiver, String MSG, String Subject) {

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthentication(username, password);
		email.setSSLOnConnect(true);
		email.setSubject(Subject);


		try {
			email.setFrom(username);
			email.setMsg(MSG);
			email.addTo(Receiver);
			email.send();
			Thread.sleep(3000);
		} catch (Exception e) {
		}


	}


}

