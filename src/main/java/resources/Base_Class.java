package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*-
 	I need to declare that which browser I will use in my test execution. So instead of 
 	invoking my browser every time I will use some steps by which I will call my browser
 	easily without hard code.
 	
 	
 */
public class Base_Class {

	// Declare a WebDriver variable & "import org.openqa.selenium.WebDriver;"
	public WebDriver d;

	// Declare a Properties type variable & "import java.util.Properties;"
	public Properties prop;

	// A method which will return a WebDriver and would through an IOException
	public WebDriver initialize_WebDriver() throws IOException {

		// initiate "prop" variable
		prop = new Properties();

		// Declare a FileInputStream type file
		// "(FileInputStream)" is used to read any file in byte format and "FileReader"
		// is
		// character based which is used to read character files.
		FileInputStream fls = new FileInputStream(
				/*- this is the path where the file is located. In this file I just add
				 * "browser = chrome" */
				/*-"Users/nazmulmahealam/eclipse-workspace/RobustFramework" this is 
				 * default path for this machine and for other machine we can get the 
				 * default path by adding System.getProperty("user.dir") then the rest
				 * path "/src/main/java/resources/data.properties"
				
				*/
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");

		// now in prop variable load the "fls" FileInputStream File
		prop.load(fls);

		// A String variable "browserName" where we stored the value of "browser" which
		// is chrome. Go and check in file

		String browserName = prop.getProperty("browser");

		// Print the browser name in console whenever I call the method
		System.out.println(browserName);

		// if the browser name is chrome then set its property in one argument
		// put "webdriver.chrome.driver" and in other argument , put location
		// of the chrome driver not chrome browser.
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/chromedriver");

			// This ChromeOptions here is for, too run chrome without executing
			// which will be hidden.
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				// run the chorme in headless mode I mean without executing run
				options.addArguments("headless");
			}

			// Initiate WebDriver as ChromeDriver
			d = new ChromeDriver(options); // this will work with head or headless both
			// import org.openqa.selenium.chrome.ChromeDriver; to fix the error

			// When the driver will lunch , make sure the window of chrome driver is in
			// full screen.
			d.manage().window().maximize();
		} // if ends

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.drive",
					"/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/geckodriver");

			// Initiate WebDriver as FirefoxDriver
			d = new FirefoxDriver();
			// import org.openqa.selenium.firefox.FirefoxDriver; to fix the error

			// When the driver will lunch , make sure the window of fire fox driver is in
			// full screen.
			d.manage().window().maximize();
		} // else if ends

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/msedgedriver");

			//// Initiate WebDriver as EdgeDriver
			d = new EdgeDriver();
			// import org.openqa.selenium.edge.EdgeDriver;

			// When the driver will lunch , make sure the window of Edge Driver is in
			// full screen.
			d.manage().window().maximize();
		} // else if ends

		// after selection of the driver then, driver will wait at least 10 seconds to
		// load
		// elements in a web page
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return d;
	} // "initialize_WebDriver" method ends

	public String getScreenShotPath(String testCaseName, WebDriver d) throws IOException {

		// take screen shot of driver d
		TakesScreenshot ts = (TakesScreenshot) d;

		// get the screen shot as a file
		File source = ts.getScreenshotAs(OutputType.FILE);

		// a destination file where we will store the screen shot
		String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";

		// copy the screen shot to store from source to destination
		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;

		/*-
		  this getScreenShotPath() method is so powerful that it captures screen shot
		  places into that path (destinationFile) and return that path
		 */
	}

}
