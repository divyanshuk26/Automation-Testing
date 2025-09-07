package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;

    // Registration locators
    private By regUsername =  By.id("reg_username");
    private By regEmail = By.id("reg_email");
    private By regPassword = By.id("reg_password");
    private By registerBtn = By.name("register");

    // Login locators
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.name("login");

    // Forgot password locators
    private By lostPasswordLink = By.linkText("Lost your password?");
    private By resetEmail = By.id("user_login");
    private By resetBtn = By.cssSelector("button.woocommerce-Button");
    //private By verifyReset = By.xpath("//*[@id=\"post-381\"]/div/div/div/div");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Register
    public void register(String username, String email, String pass) {
    	driver.findElement(regUsername).sendKeys(username);
    	driver.findElement(regEmail).sendKeys(email);
        driver.findElement(regPassword).sendKeys(pass);
        driver.findElement(registerBtn).click();
    }

     //Login
    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    // Forgot Password
    public void resetPassword(String email) throws InterruptedException {
        driver.findElement(lostPasswordLink).click();
        driver.findElement(resetEmail).sendKeys(email);
        Thread.sleep(20000);
        driver.findElement(resetBtn).click();
    }
}
