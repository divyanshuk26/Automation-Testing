package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {

    private WebDriver driver;
    private HomePage homePage;

    @Given("I am on the Home Page")
    public void i_am_on_the_home_page() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }

    @Then("the Programs menu should be displayed")
    public void the_programs_menu_should_be_displayed() {
        Assert.assertTrue(homePage.isProgramsMenuDisplayed(), "Programs menu missing");
    }

    @Then("the Services menu should be displayed")
    public void the_services_menu_should_be_displayed() {
        Assert.assertTrue(homePage.isservicesMenuDisplayed(), "Services menu missing");
    }

    @Then("the Contact Us page link should be displayed")
    public void the_contact_us_page_link_should_be_displayed() {
        Assert.assertTrue(homePage.contactUsPageDisplayed(), " Contact Us page link missing");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        homePage.searchFor(query);
    }

    @Then("the search results page URL should contain {string}")
    public void the_search_results_page_url_should_contain(String query) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("s=" + query), " Search not working. URL does not contain search query.");
    }
}
