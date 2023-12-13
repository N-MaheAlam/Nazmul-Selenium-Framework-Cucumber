package EndToEndSeleniumAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPasswordPage;
import pageObject.LogIn_Page;
import pageObject.landingPage;
import resources.Base_Class;

/*-
 	
 */
public class TestCases_Class extends Base_Class {

	// "Base_Class" as this TestCases_Class extends "Base_Class" , TestCases_Class
	// can use the public methods of TestCases_Class
	// Before starting the test I want to call "initialize_WebDriver" from
	// to initiate the driver
	// in which "Url" I am testing, get that title of that web page

	public WebDriver d;
	final Logger log = (Logger) LogManager.getLogger(TestCases_Class.class.getName());

	@BeforeTest
	public void init_Driver() throws IOException {
		d = initialize_WebDriver();

	}

	// This Test method "homePageAmazon_01" will get data from "getData()" method
	// below
	@Test(dataProvider = "getData")

	// This test will receive 03 arguments & may through and exception
	public void homePageAmazon_01(String userName, String password, String text)
			throws IOException, InterruptedException {

		d.get("http://www.qaclickacademy.com/");
		log.info("Driver Initiated");
		// creating "landingPage" object
		landingPage lang_page = new landingPage(d);

		// this line is to close the pop up message in home page
		if (lang_page.closePomptUpSize() > 0) {
			lang_page.closePomptUp().click();
		}

		// when we call this method , this automatically
		// goes to the login page as we defined in
		// "go_Sign_In_01" method and putting this in a
		// "LogIn_Page" variable as the method returns a
		// "LogIn_Page" type.
		LogIn_Page logInPage = lang_page.go_Sign_In_01();

		// creating "LogIn_Page" object

		//// now, call the methods(get_Email_01(),get_Password_02,click_Log_In_03)
		// of "LogIn_Page" through the object "logInPage" and send userName,
		// password and click on element using one by one method respectively
		logInPage.get_Email_01().sendKeys(userName);// 1st Argument
		logInPage.get_Password_02().sendKeys(password);// 2nd Argument
		logInPage.click_Log_In_03().click();

		System.out.println(text);// 3rd Argument
		Thread.sleep(2000);

		ForgotPasswordPage fp = logInPage.getForgotPassword();
		fp.sendEmail().sendKeys("SDNDSD");
		Thread.sleep(1500);
		fp.sendMeInstruction().click();

	}

	/*- 
	  In this multidimensional array we have 2 rows and 3 columns. each 
	  row has mail, pass, text. When we called this method's data in "homePageAmazon_01" test 
	  for these data same test "homePageAmazon_01" will run for two times. not in parallel but one 
	  // one after. 
	 */
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];

		data[0][0] = "nazmul@gmail.com";
		data[0][1] = "12345";
		data[0][2] = "Passed";

		/*-
		data[1][0] = "mahe@gmail.com";
		data[1][1] = "38485";
		data[1][2] = "PASSED";
		*/

		return data;
	}

	// close the browser after test

	@AfterTest
	public void close_Browser() {
		d.close();
	}

	/*-
	This whole program is about to create a selenium robust framwork 
	ERROR:-
		-> Null Pointer Exception when, there is no life in any object
		-> Element is not click able
		-> No Such element
		-> FILE not found when, there is a path mistake
		-> ArrayIndexOutOfBound  when , the array size is smaller than values
		
	Assert: -
		-> When I want to compare between 2 values , one may be my created and another 
		   I took from the test cases , those time use "Asserts.assertEquals()"
		   
		-> When I want something to be true those time use "Assert.assertTrue()"
		
		-> When I want something to be false those time use "Assert.assertFalse()"
	*/
} // class ends
