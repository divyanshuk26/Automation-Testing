package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HealthyAgingForm {
    private WebDriver driver;

    // ---------- Constructor ----------
    public HealthyAgingForm(WebDriver driver) {
        this.driver = driver;
    }

    // ---------- Locators ----------
    private By firstName = By.cssSelector("#cog-input-auto-0");
    private By lastName = By.id("cog-input-auto-1");
    private By emailField = By.id("cog-2");
    private By phoneField = By.id("cog-1");

    private By programCheckboxes = By.xpath("//*[@id='post-500']/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]//span[@class='el-checkbox__input']");
    private By countryCheckbox = By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[2]/div[1]/div[1]/div/label[1]/span[1]/span");

    private By classFormatInPerson = By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[5]/fieldset/div[1]/div[1]/div/label[1]/span[1]/span");
    private By dropDown = By.xpath("//*[@id=\"cog-6\"]");

    private By aboutUs = By.cssSelector("#cog-7");
    private By notifiedCheckbox = By.cssSelector("#post-500 > div > div.fusion-fullwidth.fullwidth-box.fusion-builder-row-1.about-content.nonhundred-percent-fullwidth.non-hundred-percent-height-scrolling > div > div.fusion-layout-column.fusion_builder_column.fusion-builder-column-0.fusion_builder_column_3_5.\\33 _5.fusion-three-fifth.fusion-column-first > div > form > div > div > div.cog-body > div > div:nth-child(8) > div > div.cog-checkable.cog-input.cog-checkable--inline > label > span.el-checkbox__input");

    private By submitButton = By.cssSelector("#post-500 > div > div.fusion-fullwidth.fullwidth-box.fusion-builder-row-1.about-content.nonhundred-percent-fullwidth.non-hundred-percent-height-scrolling > div > div.fusion-layout-column.fusion_builder_column.fusion-builder-column-0.fusion_builder_column_3_5.\\33 _5.fusion-three-fifth.fusion-column-first > div > form > div > div > div.cog-body > div > div.cog-page__navigation > button");
    private By successMessage = By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div[1]/div/div[1]");

    // ---------- Page Actions ----------

    public void enterFirstName(String name) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(name);
    }

    public void enterLastName(String name) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void selectAllProgramCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(programCheckboxes);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.getAttribute("class").contains("is-checked")) {
                checkbox.click();
            }
        }
    }

    public void selectCountry() {
        driver.findElement(countryCheckbox).click();
    }

    public void classFormat() {
        driver.findElement(classFormatInPerson).click();
    }

    public void dropDownSelect(String description) {
        WebElement input = driver.findElement(dropDown);
        input.click();                     // open dropdown
        input.sendKeys(description);       // type the description
        input.sendKeys(Keys.ENTER);        // select option
    }


    // 🔹 Updated to accept dynamic description
//    public void aboutUsDescription(String description) {
//        WebElement desc = driver.findElement(aboutUs);
//        desc.clear();
//        desc.sendKeys(description);
 //   }

    // 🔹 New method: Heard About Us field
    public void heardAboutUs(String source) {
        WebElement heardInput = driver.findElement(aboutUs);
        heardInput.clear();
        heardInput.sendKeys(source);
    }

    public void notificationCheckbox() {
        driver.findElement(notifiedCheckbox).click();
    }

    // 🔹 Renamed to match step definition
    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
