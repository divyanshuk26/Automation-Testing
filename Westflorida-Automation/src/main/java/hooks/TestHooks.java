package hooks;

import base.BaseTest;
import config.ConfigReader;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestHooks extends BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        // config file 
        ConfigReader.loadConfig();
    }

    @BeforeMethod
    public void beforeTest() {
        // Driver setup before every test
        setUp();
    }

    @AfterMethod
    public void afterTest() {
        // Driver quit after every test
        if (driver != null) {
            driver.quit();
        }
    }
}
