package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactUsPage;

public class ContactUsSteps {

    private WebDriver driver;
    private ContactUsPage contactUsPage;

    @Given("I am on the Contact Us page")
    public void i_am_on_the_contact_us_page() {
        driver = DriverFactory.getDriver();
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.navigateToContactUsPage();
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        String actualTitle = contactUsPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title not matched!");
    }

    @Then("the phone number should be displayed")
    public void the_phone_number_should_be_displayed() {
        Assert.assertTrue(contactUsPage.isPhoneNumberDisplayed(), "Phone number not displayed!");
    }

    @Then("the address should be displayed")
    public void the_address_should_be_displayed() {
        Assert.assertTrue(contactUsPage.isAddressDisplayed(), "Address not displayed!");
    }

    @Then("the email should be displayed")
    public void the_email_should_be_displayed() {
        Assert.assertTrue(contactUsPage.isEmailDisplayed(), "Email not displayed!");
    }
}
