package tests;

import hooks.TestHooks;
import org.testng.annotations.Test;
import pages.ServicesPage;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ServicesPageTest extends TestHooks {

    @Test
    public void testServicesMenu() throws InterruptedException {
        ServicesPage sp = new ServicesPage(driver);
        Thread.sleep(3000);

        // Open Services menu and get all submenu links
        sp.openServicesMenu();
        List<WebElement> links = sp.getAllServiceLinks();

        // Visit each link one by one in the same tab
        for (WebElement link : links) {
            String serviceName = link.getText().trim();

            link.click(); // opens in same tab
            Thread.sleep(3000); // wait for page to load

            System.out.println("Verified Service Page: " + serviceName + " | Title: " + driver.getTitle());

            // Navigate back to reopen dropdown before next click
            driver.navigate().back();
            Thread.sleep(2000);
            sp.openServicesMenu();
        }
    }
}
