package tests;

import hooks.TestHooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import config.ConfigReader;

public class MyAccountPageTest extends TestHooks {

    @Test(priority = 1)
    public void verifyRegistration() {
    	driver.get("https://westfloridaahec.org/my-account/");
        MyAccountPage myAccount = new MyAccountPage(driver);

        myAccount.register(ConfigReader.getProperty("username"), ConfigReader.getProperty("testEmail"), ConfigReader.getProperty("testPassword"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("my-account"), "Registration failed!");
    }

    @Test(priority = 2)
    public void verifyLogin() {
        driver.get("https://westfloridaahec.org/my-account/");
        MyAccountPage myAccount = new MyAccountPage(driver);

        myAccount.login(ConfigReader.getProperty("testEmail"), ConfigReader.getProperty("testPassword"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("my-account"), "Login failed");
    }

    @Test(priority = 3)
    public void verifyForgotPassword() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url") + "/my-account/");
        MyAccountPage myAccount = new MyAccountPage(driver);
        myAccount.resetPassword(ConfigReader.getProperty("testEmail"));
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Password reset email"), "Forgot password failed");
    }
}
