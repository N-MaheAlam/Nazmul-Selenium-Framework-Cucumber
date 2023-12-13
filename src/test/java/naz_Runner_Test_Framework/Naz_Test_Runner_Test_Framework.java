package naz_Runner_Test_Framework;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/naz_Features_Test_Framework", glue = "naz_Step_Definition_Test_Framework"

)
public class Naz_Test_Runner_Test_Framework {

}
