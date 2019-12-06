package mehmetgul.mylib;

public class WriteYourOwnXpathAndCssLocator {
/*
	XPath :
	You can check your xpath go to chrome console use method $x(" ")
	Select the unique attribute.
1-	//tagName[@attribute='value']      accept only given tagname with given attribute and given value.
	Example: //input[@value='Log In']
	$x("//input[@value='Log In'])
2-	//*[@value='Log In']   * means accept any tag name which have the tag with the given value

    //tagName[contains(@attribute,'value')]
    Example: <input name="username123">  xpath of this : //input[contains(@name,'username')]
    In above example name value is username123 but when we use contain we used only username.

we used below on header menu which is having common class. When we change the dashboard name to other menu names it works
 3- //*[normalize-space()='Dashboard' and @class='title-title-level-1']


	CSS Locator:
	You can check your CSS go to chrome console use method $(" ")
1-    tagName[attribute ='value'] or [attribute ='value'] or tagName#id or #tagname.classname
	Example: input[@value='Log In'] or [@value='Log In'] or  input#email or #email
2-	tagName[Attribute *='value']
	Example: <input name="username123">   input[name *='username']


		What is the difference between Relative and absolute xpath?
	Relative- Doesnot depend on parent nodes
	Parent/child- Absolute xpath –

	 How to traverse to sibling element using xpath?
	.//*[@id='tablist1-tab1']/following-sibling::li[2]


	How to traverse back to Parent element from Child element using Xpath?
	.//*[@id='tablist1-tab1']/parent::ul
	 How to identify element with Text based?
	 //*[text()=' Selenium ']  ->if there is gap in script you need to add that also.
 */



}
