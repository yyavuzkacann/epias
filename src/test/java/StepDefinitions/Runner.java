package StepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:target/HtmlReports"})
public class Runner {
}
