package kurtgeiger;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.tests"},features = "src/test/java/kurtgeiger/kurtgeiger.feature", format = {"pretty",
        "json:target/cucumber-reports/cucumber.json"})
public class KurtgeigerTests {
}
