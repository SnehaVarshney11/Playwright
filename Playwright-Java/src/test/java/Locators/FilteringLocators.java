package Locators;

import BasicOperations.BasicOp;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class FilteringLocators extends BasicOp {
    @Test
    public void checkLocators() {
        openUrl("https://www.saucedemo.com/");
        /* Login with username and password */
        page.getByPlaceholder("Username").fill("standard_user");
        page.getByPlaceholder("Password").fill("secret_sauce");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.waitForURL("**/inventory.html");

        /*----- Filtering Locators -----*/
        Locator allProducts = page.locator(".inventory_item");
        // Filter by text: products with "Sauce Labs Backpack"
        Locator backpackProducts = allProducts.filter(new Locator.FilterOptions().setHasText("Sauce Labs Backpack"));

        // Filter by NOT having text: products without "Sauce Labs Backpack"
        Locator notBackpackProducts = allProducts.filter(new Locator.FilterOptions().setHasNotText("Sauce Labs Backpack"));

        // Filter by child/descendant: products that have price element
        Locator productsWithPrice = allProducts.filter(new Locator.FilterOptions().setHas(page.locator(".inventory_item_price")));

        // Filter by NOT having child/descendant: products without description (should be 0)
        Locator productsWithoutDesc = allProducts.filter(new Locator.FilterOptions().setHasNot(page.locator(".inventory_item_desc")));

        System.out.println("All products count: " + allProducts.count());
        System.out.println("Products with 'Sauce Labs Backpack': " + backpackProducts.count());
        System.out.println("Products without 'Sauce Labs Backpack': " + notBackpackProducts.count());
        System.out.println("Products with price element: " + productsWithPrice.count());
        System.out.println("Products without description: " + productsWithoutDesc.count());
    }
}
