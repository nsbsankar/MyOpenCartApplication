package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;


public class MyHooks {

    WebDriver driver;
    @Before
    public void setUp() {
        Properties properties = ConfigReader.intializeProperties();
        System.out.println(properties.getProperty("Browser"));
        driver = DriverFactory.intializeBrowser(properties.getProperty("Browser"));
        driver.get(properties.getProperty("URL"));
    }

    @After
    public void tearDown(Scenario scenario) {
        String scenarioName = scenario.getName().replace(" ","_");

        if(scenario.isFailed()){
            byte[] srcScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenShot,"image/png",scenarioName);
        }

        driver.quit();
    }
}
