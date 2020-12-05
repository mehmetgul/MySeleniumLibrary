package mehmetgul.mylib.z_mysandbox.cucumberDDT;

public class ResetLikesInFacebook {
	/*
	div[aria-label="Action options"]  need to be replaved based on language
	English:div[aria-label="Action options"]
	German:div[aria-label="Weitere Optionen"]
	Italain:div[aria-label="Opzioni di azione"]
	Turkish :div[aria-label="Duzenle"]
	French: div[aria-label="Options d’action"]
	Polish : div[aria-label="Opcje działania"]

	1- Go to: https://www.facebook.com/{your_id_or_username}/allactivity/?category_key=LIKEDPOSTS&filter_hidden=ALL&filter_privacy=NONE
	You can use Filter to choose year or month.<br>
	or go to https://www.facebook.com/me/allactivity/?category_key=LIKEDPOSTS&filter_hidden=ALL&filter_privacy=NONE  ""@michelep"" <br>
			2- Open the console and run the following JavaScript code and wait:<br>

	<pre>setInterval(() => {
		for (const Button of document.querySelectorAll('div[aria-label="Action options"]')) {
			Button.click()
			for (const remove of document.querySelectorAll('div[role="menuitem"]')) {
				remove.click()
			}
		}
	}, 1000)


	 */
}
