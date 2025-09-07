package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // Locators for web elements
    private By programsMenu = By.cssSelector("#menu-item-264 > a");
    private By servicesMenu = By.cssSelector("#menu-item-331 > a > span.menu-text");
    private By contactUsPage = By.cssSelector("#menu-item-209 > a > span");
    private By searchBar = By.cssSelector("input[name='s']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // New method to check if Programs menu is displayed
    public boolean isProgramsMenuDisplayed() {
        return driver.findElement(programsMenu).isDisplayed();
    }

    // New method to check if Resources link is displayed
    public boolean isservicesMenuDisplayed() {
        return driver.findElement(servicesMenu).isDisplayed();
    }
    
    public boolean contactUsPageDisplayed() {
    	return driver.findElement(contactUsPage).isDisplayed();
    }

    // Method to search for a query
    public void searchFor(String query) {
        WebElement searchInput = driver.findElement(searchBar);
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.submit(); // submit() method bhi enter dabane ka kaam karta hai
    }
}