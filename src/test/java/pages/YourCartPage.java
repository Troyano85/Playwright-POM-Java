/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Page Object Model for Your Cart
 * Version: 1.0
 * */
package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import utilities.BasePage;
import utilities.Logs;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class YourCartPage extends BasePage {
    private final Locator checkoutButton;
    private final Locator continueShoppingButton;
    private final Locator title;
    private final Locator itemContainer;
    public YourCartPage(Page page) {
        super(page);
        checkoutButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Checkout"));
        continueShoppingButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Go back Continue Shopping"));
        title = page.getByText("Your Cart");
        itemContainer = page.getByTestId("cart-list");
    }

    @Override
    @Step("Verificando la UI de your cart")
    public void verifyPage() {
        Logs.info("Verificando la UI de your cart");
        assertAll(
                ()->assertThat(checkoutButton).isVisible(),
                ()->assertThat(continueShoppingButton).isVisible(),
                ()->assertThat(title).isVisible(),
                ()->assertThat(itemContainer).isVisible()
        );
    }
    @Step("Haciendo click en el boton verde checkout")
    public void clickCheckoutButton(){
        Logs.info("Haciendo click en el boton verde checkout");
        checkoutButton.click();}
    }
