package Locators;

import BasicOperations.BasicOp;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class Operators extends BasicOp {
    @Test
    public void checkLocators() {
        openUrl("https://www.saucedemo.com/");
        /* Login with username and password */
        page.getByPlaceholder("Username").fill("standard_user");
        page.getByPlaceholder("Password").fill("secret_sauce");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.waitForURL("**/inventory.html");

        /*------ Locator Operators -----*/
        Locator allProducts = page.locator(".inventory_item");

        // Matching inside a locator: prices inside products
        Locator pricesInsideProducts = allProducts.locator(".inventory_item_price");
        System.out.println("Prices count: " + pricesInsideProducts.count());

        // Matching two locators simultaneously (AND): products with "Sauce" and price "$29.99"
        Locator productsWithSauce = allProducts.filter(new Locator.FilterOptions().setHasText("Sauce"));
        Locator productsWithSauceAndPrice = productsWithSauce.filter(new Locator.FilterOptions()
                .setHas(page.locator(".inventory_item_price").filter(new Locator.FilterOptions().setHasText("$29.99"))));

        System.out.println("Products with 'Sauce' and price '$29.99': " + productsWithSauceAndPrice.count());


        // Matching one of two alternative locators (OR): products with "Backpack" or "Bike"
        Locator backpackOrBike = allProducts.filter(new Locator.FilterOptions()
                .setHas(page.locator(".inventory_item_name >> xpath=//*[contains(text(), 'Backpack') or contains(text(), 'Bike')]")));
        System.out.println("Products with 'Backpack' OR 'Bike': " + backpackOrBike.count());

        // Matching only visible elements (should be all)
        Locator visibleProducts = allProducts.filter(new Locator.FilterOptions().setVisible(true));
        System.out.println("Visible products count: " + visibleProducts.count());

    }
}
