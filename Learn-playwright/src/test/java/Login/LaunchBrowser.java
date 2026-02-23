package Login;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {

    public static void main(String args[]) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate("https://ecommerce-playground.lambdatest.io/index.php");
            Locator myAccount = page.locator("//a[contains(., 'My account')][@role='button']");
            myAccount.hover();
            page.locator("//a[contains(., 'Login')]").click();
            assertThat(page).hasTitle("Account Login");
            page.getByPlaceholder("E-Mail Address").fill("varshneysneha1109@gmail.com"); // clears existing text and fills instantly (recommended)
            //page.getByPlaceholder("E-Mail Address").type("varshneysneha1109@gmail.com"); --> type character by character
            page.getByPlaceholder("Password").fill("Test@1234");
            page.locator("//input[@value='Login']").click();
            assertThat(page).hasTitle("My Account");
            page.close();

        }
    }

}