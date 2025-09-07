package hooks;

import base.DriverFactory;
import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestHooks {

    @Before
    public void setUp() {
        ConfigReader.loadConfig();
        DriverFactory.getDriver(); // Driver launch
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(); // Driver quit
    }
}
