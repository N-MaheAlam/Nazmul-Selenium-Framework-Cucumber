package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*-
 	This class describes about how page factory has to create. page factory is another way
 	of page object pattern but it is used widely as it is easy to understand
 */
public class Home_Page_Validation {

	// declare a WebDriver
	WebDriver d;

	// create a constructor which has a parameter of WebDriver
	public Home_Page_Validation(WebDriver d) {
		this.d = d;
		// to use page factory we need to declare this below line
		PageFactory.initElements(d, this);

	}

	// FindBy is a annotation where we declare the locators like xpath,css , id,
	// name
	// FindBy(locatorsName = "path value of that locator")
	@FindBy(css = ".navbar-collapse.collapse")
	// declare a WebElement with name;
	WebElement top_Nagivation;

	@FindBy(xpath = "//a[normalize-space()='Contact']")
	WebElement contact;

	@FindBy(css = "div[class='text-center'] h2") // this two lines are pattern to
	WebElement course_Title; // to create Page Facotry

	// for every FindBy element create a method which will return the WebElement
	// with the name that ewe have declare below each FindBy
	public WebElement get_top_Nagivation_01() {
		return top_Nagivation;
	}

	public WebElement get_Contact_02() {
		return contact;
	}

	public WebElement get_Course_Title_03() {
		return course_Title;
	}

}
