package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_Page {

	WebDriver d;

	public LogIn_Page(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	private @FindBy(css = "#user_email") WebElement email;

	private @FindBy(xpath = "//input[@type='password']") WebElement passWord;

	private @FindBy(css = "input[value='Log In']") WebElement log_In;

	private @FindBy(xpath = "//a[contains(text(),'Forgot Password?')]") WebElement forgotPass;

	public WebElement get_Email_01() {
		return email;
	}

	public WebElement get_Password_02() {
		return passWord;
	}

	public WebElement click_Log_In_03() {
		return log_In;
	}

	public ForgotPasswordPage getForgotPassword() {
		forgotPass.click();
		return new ForgotPasswordPage(d);
	}

}
