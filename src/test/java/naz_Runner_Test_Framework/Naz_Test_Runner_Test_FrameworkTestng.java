package naz_Runner_Test_Framework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
// we don't need the above Runner as we are now running our cucumber with testng 

/*
 * To run the code in JUnit cucumber we imported 
 * "import io.cucumber.junit.CucumberOptions;"
 * 
 * To run the code in TestNG we need to import
 * "import io.cucumber.testng.CucumberOptions;"
 * 
 * and  extend AbstractTestNGCucumberTests
 * and remove @RunWith(Cucumber.class) from runner class for testNG
 */

@CucumberOptions(features = "src/test/java/naz_Features_Test_Framework", glue = "naz_Step_Definition_Test_Framework"

)
public class Naz_Test_Runner_Test_FrameworkTestng extends AbstractTestNGCucumberTests {

}
