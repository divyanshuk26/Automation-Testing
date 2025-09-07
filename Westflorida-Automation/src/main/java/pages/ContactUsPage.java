package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;

    // Constructor
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By contactUsMenu = By.cssSelector("#menu-item-209 a span");
    private By phoneNumber = By.cssSelector("a[href*='tel']");
    private By address = By.cssSelector("div.fusion-text.fusion-text-2 p");
    private By email = By.cssSelector("a[href*='mailto']");

//    // Contact Form Locators
//    private By nameField = By.id("contact_name");    
//    private By emailField = By.id("contact_email");    
//    private By messageField = By.id("contact_message");
    private By submitButton = By.cssSelector("button[type='submit']");

    // ---------- Page Actions ----------
    public void navigateToContactUsPage() {
        driver.findElement(contactUsMenu).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isPhoneNumberDisplayed() {
        return !driver.findElements(phoneNumber).isEmpty();
    }

    public boolean isAddressDisplayed() {
        return !driver.findElements(address).isEmpty();
    }

    public boolean isEmailDisplayed() {
        return !driver.findElements(email).isEmpty();
    }

//    // ---------- Contact Form Actions ----------
//    public void enterName(String name) {
//        driver.findElement(nameField).sendKeys(name);
//    }
//
//    public void enterEmail(String emailText) {
//        driver.findElement(emailField).sendKeys(emailText);
//    }
//
//    public void enterMessage(String message) {
//        driver.findElement(messageField).sendKeys(message);
//    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}
