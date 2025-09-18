package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"stepDefinitions"},
        monochrome=true,
        plugin={"pretty","html:target/HtmlReports/reports.html","junit:target/JUnitReports/reports.html", "json:target/JSonReports/cucumber.json"}
       // tags="@regression or @smoke"
)

public class TestRunnerCreateUser {
}
