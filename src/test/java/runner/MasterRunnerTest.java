package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features.master", 
		glue = "stepdefs.master",
		plugin= {
				"pretty",
				"html:target/cucumber-reports-master",
				"json:target/cucumber-reports/Cucumber-master.json"
		}
		)
public class MasterRunnerTest extends AbstractTestNGCucumberTests {

}
