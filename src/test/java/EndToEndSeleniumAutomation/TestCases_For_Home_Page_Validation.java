package EndToEndSeleniumAutomation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Home_Page_Validation;
import resources.Base_Class;

public class TestCases_For_Home_Page_Validation extends Base_Class {

	// Here I extends TestCases_For_Home_Page_Validation from Base_Class to invoke
	// the method
	// initialize_WebDriver() from Base_Class

	// declaring a class variable which is WebDriver type
	public WebDriver d;

	@BeforeTest
	public void init_Driver() throws IOException {

		d = initialize_WebDriver();
		d.get(prop.getProperty("url"));
	}

	@Test
	public void home_Bar_And_Title_Validate() throws IOException {

		Home_Page_Validation hv = new Home_Page_Validation(d);

		System.out.println(hv.get_top_Nagivation_01().getText());

		Assert.assertEquals(hv.get_Contact_02().getText(), "CONTACT");
		Assert.assertEquals(hv.get_Course_Title_03().getText(), "FEATURED COURSES");
	}

	@AfterTest
	public void close_Browser() {
		d.close();
	}
}
