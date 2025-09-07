package stepdefinitions;

import base.DriverFactory;
import config.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;

public class MyAccountSteps {

    private WebDriver driver;
    private MyAccountPage myAccount;

    @Given("I am on the My Account page")
    public void i_am_on_the_my_account_page() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("url") + "/my-account/");
        myAccount = new MyAccountPage(driver);
    }

    @When("I register with valid details")
    public void i_register_with_valid_details() throws InterruptedException {
        myAccount.register(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("testEmail"),
                ConfigReader.getProperty("testPassword")
        );
    }

    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("my-account")) {
            throw new AssertionError("Registration failed!");
        }
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() throws InterruptedException {
        myAccount.login(
                ConfigReader.getProperty("testEmail"),
                ConfigReader.getProperty("testPassword")
        );
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("my-account")) {
            throw new AssertionError("Login failed!");
        }
    }

    @When("I request a password reset")
    public void i_request_a_password_reset() throws InterruptedException {
        myAccount.resetPassword(ConfigReader.getProperty("testEmail"));
    }

    @Then("I should receive a reset confirmation")
    public void i_should_receive_a_reset_confirmation() {
        String pageSource = driver.getPageSource();
        if (!pageSource.contains("Password reset email")) {
            throw new AssertionError("Forgot password failed!");
        }
    }
}
