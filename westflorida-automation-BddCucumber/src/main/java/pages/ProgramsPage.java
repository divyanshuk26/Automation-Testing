package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProgramsPage {
    private WebDriver driver;

    public ProgramsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Programs menu locator
    private By programsMenu = By.cssSelector("#menu-item-264 > a");
    // All sub-menu links under Programs
    private By programLinks = By.xpath("//*[@id='menu-item-264']//ul/li/a");

    // Method to open the Programs menu
    public void openProgramsMenu() {
        driver.findElement(programsMenu).click();
    }

    // Get all sub-menu items as a list
    public List<WebElement> getAllProgramLinks() {
        return driver.findElements(programLinks);
    }

    // Generic method to navigate to a submenu by visible text
    public boolean goToProgramPage(String programName) throws InterruptedException {
        openProgramsMenu();
        List<WebElement> links = getAllProgramLinks();
        for (WebElement link : links) {
            if (link.getText().contains(programName)) {
                link.click();
                Thread.sleep(2000); // wait for page to load
                return driver.getTitle().contains(programName);
            }
        }
        return false; // program not found
    }
}
