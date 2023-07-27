package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                glue = {"stepDefinitions","hooks"},
                dryRun = false,
                monochrome = true,
                publish = true,
                tags = "@LoginLogoutLogin",
                plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"}
)
public class TestRunner {
}
