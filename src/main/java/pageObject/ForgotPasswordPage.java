package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

	WebDriver d;

	public ForgotPasswordPage(WebDriver driver) {
		this.d = driver;
	}

	By email = By.xpath("//input[@id='user_email']");
	By sendMe = By.cssSelector(
			"section:nth-child(2) div.main-hero " + "form:nth-child(2) div.form-group.text-center:nth-child(3) > "
					+ "input.btn.btn-primary.btn-md.login-button");

	public WebElement sendEmail() {
		return d.findElement(email);
	}

	public WebElement sendMeInstruction() {
		return d.findElement(sendMe);
	}
}
