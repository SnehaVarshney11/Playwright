package Locators;

import BasicOperations.BasicOp;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatingElements extends BasicOp {
    @Test
    public void checkLocators() {
        openUrl("https://www.saucedemo.com/");
        // Locate by role: Button with name "Login"
        Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));

        // Locate by label: Input labeled "Username"
        Locator usernameInput = page.getByLabel("Username");

        // Locate by placeholder: Input with placeholder "Password"
        Locator passwordInput = page.getByPlaceholder("Password");

        // Locate by text: Exact text "Accepted usernames are:"
        Locator acceptedUsernamesText = page.getByText("Accepted usernames are:");

        // Locate by alt text: The "Swag Labs" logo image has alt text "Swag Labs"
        Locator swagLogo = page.getByAltText("Swag Labs");

        // Locate by title: The login button has a title attribute "Login button"
        Locator loginButtonByTitle = page.getByTitle("Login button");

        // Locate by test id: The username input has data-test="username"
        Locator usernameTestId = page.getByTestId("username");

        // Locate by CSS selector: The login form container div with class "login_wrapper"
        Locator loginWrapper = page.locator("div.login_wrapper");

        // Locate by XPath: The "Password for all users" text element
        Locator passwordInfo = page.locator("//div[text()='Password for all users:']");

        // Print results
        System.out.println("Login button visible? " + loginButton.isVisible());
        System.out.println("Username input count: " + usernameInput.count());
        System.out.println("Password input count: " + passwordInput.count());
        System.out.println("Accepted usernames text count: " + acceptedUsernamesText.count());
        System.out.println("Swag Labs logo count: " + swagLogo.count());
        System.out.println("Login button by title visible? " + loginButtonByTitle.isVisible());
        System.out.println("Username input by test id count: " + usernameTestId.count());
        System.out.println("Login wrapper count: " + loginWrapper.count());
        System.out.println("Password info text count: " + passwordInfo.count());
    }
}
