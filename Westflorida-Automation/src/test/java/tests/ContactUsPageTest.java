package tests;

import hooks.TestHooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsPageTest extends TestHooks {

	@Test
	public void verifyContactUsPage() {
		// Step 1: ContactUsPage object
		ContactUsPage contactUsPage = new ContactUsPage(driver);

		// Step 2: "Contact Us" page navigate
		contactUsPage.navigateToContactUsPage();

		// Step 3: Title verify
		String actualTitle = contactUsPage.getPageTitle();
		String expectedTitle = "CONTACT US - West Florida Area Health Education Center, Inc";
		Assert.assertEquals(actualTitle, expectedTitle, "Page title not matched!");

		// Step 4: Phone number visible
		Assert.assertTrue(contactUsPage.isPhoneNumberDisplayed(), "Phone number not displayed");

		// Step 5: Address visible
		Assert.assertTrue(contactUsPage.isAddressDisplayed(), "Address not displayed");

		// Step 6: Email visible
		Assert.assertTrue(contactUsPage.isEmailDisplayed(), "Email not displayed");

	}
}
