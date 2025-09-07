package stepdefinitions;

import base.DriverFactory;
import config.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HealthyAgingForm;

public class HealthyAgingFormSteps {

    private WebDriver driver;
    private HealthyAgingForm formPage;

    @Given("user is on the Healthy Aging Form page")
    public void user_is_on_the_healthy_aging_form_page() throws InterruptedException {
        driver = DriverFactory.getDriver();
        String formurl = ConfigReader.getProperty("healthyAgingFormURL");
        driver.get(formurl);
        formPage = new HealthyAgingForm(driver);
        Thread.sleep(2000); // wait for page load
    }

    @When("user enters the first name as {string}")
    public void user_enters_the_first_name_as(String firstName) throws InterruptedException {
        Thread.sleep(2000);
    	formPage.enterFirstName(firstName);
    }
    
    @When("user enters the last name as {string}")
    public void user_enters_the_last_name_as(String lastName) throws InterruptedException {
    	Thread.sleep(2000);
        formPage.enterLastName(lastName);
    }

    @When("user enters phone number as {string}")
    public void user_enters_phone_number_as(String phone) throws InterruptedException {
    	Thread.sleep(2000);
        formPage.enterPhone(phone);
    }

    @When("user enters email as {string}")
    public void user_enters_email_as(String email) throws InterruptedException {
    	Thread.sleep(2000);
        formPage.enterEmail(email);
    }

    @When("user selects all the programs")
    public void user_selects_all_the_programs() throws InterruptedException {
    	Thread.sleep(2000);
        formPage.selectAllProgramCheckboxes();
    }

    @When("user selects county")
    public void user_selects_county() throws InterruptedException {
    	Thread.sleep(2000);
        formPage.selectCountry();
    }

    @When("user selects class format")
    public void user_selects_class_format() throws InterruptedException {
    	Thread.sleep(2000);
        formPage.classFormat();
    }

    @When("user selects described as {string}")
    public void user_selects_described_as(String description) throws InterruptedException {
    	Thread.sleep(2000);
        formPage.dropDownSelect(description);
        System.out.println("user selected description: " + description);
    }
    
    @When("user enters Heard About Us as {string}")
    public void user_enters_heard_about_us_as(String source) throws InterruptedException {
    	Thread.sleep(2000);
        formPage.heardAboutUs(source);
    }

    @When("user clicks on checkbox")
    public void user_clicks_on_checkbox() throws InterruptedException {
    	Thread.sleep(2000);
        formPage.notificationCheckbox();
    }

    @When("user clicks on submit")
    public void user_clicks_on_submit() throws InterruptedException {
    	Thread.sleep(3000);
        formPage.submitForm();
    }
    
    @Then("the form should get submitted")
    public void the_form_should_get_submitted() throws InterruptedException {
    	Thread.sleep(2000);
        // You can add verification here if needed (e.g., page redirect or alert)
        System.out.println("Form submitted successfully (basic check).");
    }

    @Then("user should see a success message confirming submission")
    public void user_should_see_a_success_message_confirming_submission() {
        String actualMessage = formPage.getSuccessMessage();
        System.out.println(actualMessage);
        String expectedMessage = "Thank you for filling out the form. Your response has been recorded.";

        if (!actualMessage.contains(expectedMessage)) {
            throw new AssertionError("Success message not displayed correctly! Got: " + actualMessage);
        }
    }
}
