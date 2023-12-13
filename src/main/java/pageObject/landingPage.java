package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*- 
 		This class is an example of "Page Object pattern". In page object we
 		have two classes , one where we write variables such as web elements
 		and methods for each web element. The other one is "test class" where 
 		we invoke those web element methods from page object repository class
 		and use those methods to perform different functions like clicking,
 		sending value to a text book, getting button text etc. This is a 
 		page object repository class
 		
 		RULES TO WRITE PAGE OBJECT: 
 		1) a public web driver
 		2) constructor with the web driver variable
 		3) use "By" type (its a variable type like int, String) from
 		   selenium annotations to store the web elements such as locators 
 		   which are xpath, name, id, cssSelector.
 		4) create method for each variable which returns that variable.
 */

public class landingPage {

	// a public web driver
	// when declaring WebDriver "d", it might through an exception
	// now "import org.openqa.selenium.WebDriver;" this , then the
	// read line will go.
	public WebDriver d;

	// constructor which has a parameter of WebDriver
	public landingPage(WebDriver d) {
		this.d = d;
	}

	// [variables are private their accessory methods are
	// public to achieve the encapsulation ]
	// By type variable. In selenium,
	// we did "---driverName.findElement(By.locatorName("Path").methodName--";
	// Here storing in a variable ---"By.locatorName("Path")---"
	private By sign_In = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
	private By alert_Close = By.cssSelector("body > div:nth-child(36) > div:nth-child(2)"
			+ " > div:nth-child(1) > div:nth-child(1) > " + "div:nth-child(1) > span:nth-child(2) > div:nth-child(1)"
			+ " > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) " + "> button:nth-child(1)");

	private By closePopUp = By.xpath("//button[contains(text(),'NO THANKS')]");

	// A method which will return a Web Element. In Selenium
	// "---driverName.findElement(By.locatorName("Path").methodName--" I used
	// Now, driverName.findElement(Above variable name) such as
	// "--driverName.findElement(sign_In)---" this will be returned by method.
	// "import org.openqa.selenium.WebElement;" for WebElement

	// This method is modified according to lecture 207 as we need to click login
	// button every time to land login
	// page we just clicked the login button and created object of login page inside
	// this method and returned it
	// as we have to perform the email giving , password giving after landing login
	// page, through this method
	// we have just landed
	public LogIn_Page go_Sign_In_01() {
		d.findElement(sign_In).click();
		LogIn_Page logInPage = new LogIn_Page(d);
		return logInPage;

	}

	public WebElement alert_Close_02() {
		return d.findElement(alert_Close);
	}

	// is there any pop up messages more than 1, just getting total
	// number of pop
	public int closePomptUpSize() {
		return d.findElements(closePopUp).size();
	}

	public WebElement closePomptUp() {
		return d.findElement(closePopUp);
	}

}
