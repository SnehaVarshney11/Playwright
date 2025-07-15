package Assertions;

import BasicOperations.BasicOp;
import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions extends BasicOp {

    @Test
    public void assertEquals() {
        openUrl("https://playwright.dev/java/");
        Assert.assertEquals(page.title(), "Playwright Java");
    }

    @Test
    public void assertNotEquals() {
        openUrl("https://playwright.dev/java/");
        Assert.assertNotEquals(page.title(), "Playwright");
    }

    @Test
    public void assertTrue() {
        openUrl("https://playwright.dev/java/");
        boolean verifyTitle = page.title().equals("Fast and reliable end-to-end testing for modern web apps | Playwright Java");
        Assert.assertTrue(verifyTitle);
    }

    @Test
    public void assertFalse() {
        openUrl("https://playwright.dev/java/");
        boolean verifyTitle = page.title().equals("Java");
        Assert.assertFalse(verifyTitle);
    }

    @Test
    public void assertNotNull() {
        openUrl("https://playwright.dev/java/");
        Locator heading = page.locator("h1");
        Assert.assertNotNull(heading);
        Assert.assertTrue(heading.isVisible(), "Heading should be visible");
    }

    @Test
    public void assertNull() {
        // Since Playwright locators never return null, simulate with a variable
        Object obj = null;
        Assert.assertNull(obj);
    }

    @Test
    public void assertSame() {
        openUrl("https://playwright.dev/java/");
        Locator firstHeading = page.locator("h1");
        Locator secondHeading = firstHeading;
        Assert.assertSame(firstHeading, secondHeading);
    }

    @Test
    public void assertNotSame() {
        openUrl("https://playwright.dev/java/");
        Locator firstHeading = page.locator("h1");
        Locator differentLocator = page.locator("p");
        Assert.assertNotSame(firstHeading, differentLocator);
    }

    @Test
    public void softAssertion() {
        SoftAssert softAssert = new SoftAssert();

        openUrl("https://playwright.dev/java/");
        softAssert.assertTrue(page.url().contains("playwright"), "URL check");
        softAssert.assertNotNull(page.locator("h1"), "Heading locator should not be null");
        softAssert.assertAll();
    }
}