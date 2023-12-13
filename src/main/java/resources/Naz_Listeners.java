package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Naz_Listeners extends Base_Class implements ITestListener {

	ExtentTest test;

	// ----------------This line for parallel test only-------------

	/*-when the parallel tests happen, all the test will run together which will not be 
	Thread safe. to make it happen we use this below ThreadLocal which will indicate 
	or take only "ExtentTest" generic type
	*/
	ThreadLocal<ExtentTest> createTest = new ThreadLocal<ExtentTest>();
	// ----------------------parallel ends--------------------
	ExtentReports extent = ExtentReporterNG.getReport();

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());

		// ----------------This line for parallel test only-------------
		createTest.set(test);
		// ------------------parallel ends ------

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// ----------------This line for parallel test only-------------

		createTest.get().log(Status.PASS, "Test is passed ");
		// ----------------This line for parallel test ends-------------

		/*-
		 * This line is for sequential tests
		test.log(Status.PASS, "Test has passed");
		
		*/
	}

	@Override
	public void onTestFailure(ITestResult result) {

		/*-
		// it will show the failure cause in console for seqential test
		
		test.fail(result.getThrowable());
		
		*/
		// ----------------This line for parallel test only-------------
		createTest.get().fail(result.getThrowable());
		// ----------------parallel ends------------
		WebDriver d = null;
		String testMethodname = result.getMethod().getMethodName();
		try {
			d = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("d").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		try {
			// ------------- parallel test running and taking screenshot

			createTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodname, d),
					result.getMethod().getMethodName());

		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
