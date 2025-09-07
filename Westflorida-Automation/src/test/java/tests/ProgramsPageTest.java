package tests;

import hooks.TestHooks;
import org.testng.annotations.Test;
import pages.ProgramsPage;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProgramsPageTest extends TestHooks {

    @Test
    public void testPrograms() throws InterruptedException {
        ProgramsPage pp = new ProgramsPage(driver);
        Thread.sleep(3000);

        // Open Programs menu and get all submenu links
        pp.openProgramsMenu();
        List<WebElement> links = pp.getAllProgramLinks();

        // Visit each link one by one in the same tab
        for (WebElement link : links) {
            String programName = link.getText().trim();

            link.click(); // opens in same tab
            Thread.sleep(3000); 

            System.out.println("Verified Program Page: " + programName + " | Title: " + driver.getTitle());

            // Navigate back to reopen dropdown before next click
            driver.navigate().back();
            Thread.sleep(2000);
            pp.openProgramsMenu();
        }
    }
}
