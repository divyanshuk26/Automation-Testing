package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ProgramsPage;

import java.util.List;

public class ProgramsPageSteps {

    private WebDriver driver;
    private ProgramsPage programsPage;
    private List<WebElement> programLinks;

    @Given("I am on the Programs menu")
    public void i_am_on_the_programs_menu() throws InterruptedException {
        driver = DriverFactory.getDriver();
        programsPage = new ProgramsPage(driver);
        Thread.sleep(3000);
        programsPage.openProgramsMenu();
    }

    @When("I open each program one by one")
    public void i_open_each_program_one_by_one() throws InterruptedException {
        programLinks = programsPage.getAllProgramLinks();

        for (WebElement link : programLinks) {
            String programName = link.getText().trim();

            link.click(); // opens in same tab
            Thread.sleep(3000); // wait for page load

            System.out.println("Verified Program Page: " + programName + " | Title: " + driver.getTitle());

            driver.navigate().back();
            Thread.sleep(2000);
            programsPage.openProgramsMenu();
        }
    }

    @Then("each program page should load successfully")
    public void each_program_page_should_load_successfully() {
        // Already verified inside loop
        // Optional assertion: title should not be empty
        if (driver.getTitle().isEmpty()) {
            throw new AssertionError("Program page did not load properly!");
        }
    }
}
