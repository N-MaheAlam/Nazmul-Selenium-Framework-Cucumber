package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalPage {

	WebDriver d;

	public portalPage(WebDriver d) {
		this.d = d;
	}

	private By searchBox = By.xpath("//input[@name='query']");

	public WebElement getSearchBar() {
		return d.findElement(searchBox);
	}

}
