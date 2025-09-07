package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ServicesPage {
    private WebDriver driver;

    public ServicesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Services menu locator
    private By servicesMenu = By.xpath("//*[@id=\"menu-item-331\"]/a/span[1]");  
    // All sub-menu links under Services
    private By serviceLinks = By.xpath("//*[@id=\"menu-item-331\"]//ul//li//a");

    // Method to open the Services menu
    public void openServicesMenu() {
        driver.findElement(servicesMenu).click();
    }

    // Get all sub-menu items as a list
    public List<WebElement> getAllServiceLinks() {
        return driver.findElements(serviceLinks);
    }

    // Generic method to navigate to a submenu by visible text
    public boolean goToServicePage(String serviceName) throws InterruptedException {
        openServicesMenu();
        List<WebElement> links = getAllServiceLinks();
        for (WebElement link : links) {
            if (link.getText().contains(serviceName)) {
                link.click();
                Thread.sleep(2000); // wait for page to load
                return driver.getTitle().contains(serviceName);
            }
        }
        return false; // service not found
    }
}
