package naz_Step_Definition_Test_Framework;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LogIn_Page;
import pageObject.landingPage;
import pageObject.portalPage;
import resources.Base_Class;

public class Naz_Step_Definition_Class extends Base_Class {

	@Given("Initiate the browser with chrome")
	public void initiate_the_browser_with_chrome() throws IOException {

		// Calling this method from Base_Class to initiate browser
		d = initialize_WebDriver();
	}

	@And("Navigate to {string} web site")
	public void navigate_to_web_site(String string) {
		d.get(string);
	}

	@And("Click to the log in page to log in")
	public void click_to_the_log_in_page_to_log_in() {
		landingPage lang_page = new landingPage(d);

		if (lang_page.closePomptUpSize() > 0) {
			lang_page.closePomptUp().click();
		}
		lang_page.go_Sign_In_01();
	}

	@When("^Enter (.+) and (.+)$")
	public void enter_and(String string, String string2) {
		LogIn_Page log_in = new LogIn_Page(d);
		log_in.get_Email_01().sendKeys(string);
		log_in.get_Password_02().sendKeys(string2);
		log_in.click_Log_In_03().click();
	}

	@Then("Verify the log in successfulness")
	public void verify_the_log_in_successfulness() {

		portalPage portalpage = new portalPage(d);

		portalpage.getSearchBar().sendKeys("Nazmul");

	}

	@And("^close browser$")
	public void close_browser() throws Throwable {
		d.quit();
	}

}
