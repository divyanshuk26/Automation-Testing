package tests;

import hooks.TestHooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestHooks {

    @Test(priority = 1)
    public void verifyHomePageSections() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProgramsMenuDisplayed(), "Programs menu missing");
        Assert.assertTrue(homePage.isservicesMenuDisplayed(), "Resources link missing");
        Assert.assertTrue(homePage.contactUsPageDisplayed(), "contactus page is not displayed");
    }

    @Test(priority = 2)
    public void verifySearchFunctionality() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String searchQuery = "Tobacco";
        homePage.searchFor(searchQuery);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("s=" + searchQuery), "Search not working. URL does not contain search query.");
    }
}