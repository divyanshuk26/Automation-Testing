package tests;

import hooks.TestHooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HealthyAgingForm;
import config.ConfigReader;

public class HealthyAgingFormTest extends TestHooks {

    @Test
    public void verifyHealthyAgingFormSubmission() throws InterruptedException {
        // Step 1: URL config.properties 
        String formurl = ConfigReader.getProperty("healthyAgingFormURL");
        driver.get(formurl);

        // Step 2: HealthyAgingForm obj
        HealthyAgingForm formPage = new HealthyAgingForm(driver);
        Thread.sleep(5000);

        // Step 3: Form fill 				
        formPage.enterFirstName(ConfigReader.getProperty("firstName"));
        Thread.sleep(1000);
        formPage.enterLastName(ConfigReader.getProperty("lastName"));
        Thread.sleep(1000);
        formPage.enterEmail(ConfigReader.getProperty("email"));
        Thread.sleep(1000);
        formPage.enterPhone(ConfigReader.getProperty("phone"));
        Thread.sleep(1000);
        formPage.selectAllProgramCheckboxes();
        Thread.sleep(1000);
        formPage.selectCountry();
        Thread.sleep(1000);
        formPage.classFormat();
        Thread.sleep(1000);
        formPage.dropDownSelect();
        Thread.sleep(1000);
        formPage.aboutUsDescription();
        Thread.sleep(1000);
        formPage.notificationCheckbox();
        Thread.sleep(1000);
       // verify
        String actualMessage = formPage.getSuccessMessage();
        System.out.println(actualMessage);
        String expectedMessage = "Please note: Our programs are designed to serve adults 60 and over in the Northwest Florida region.";
        Thread.sleep(1000);
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Success message not displayed correctly!");
    }
}
