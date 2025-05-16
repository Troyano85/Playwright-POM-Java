/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Page Object Model for top bar
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

public class TopBar extends BasePage {
    private final Locator itemCounter;
    private final Locator burgerMenuButton;
    private final Locator checkoutButton;

    public TopBar(Page page) {
        super(page);
        itemCounter = page.getByTestId("shopping-cart-badge");
        burgerMenuButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Open Menu"));
        checkoutButton = page.getByTestId("shopping-cart-link");
    }

    @Override
    public void verifyPage() {
    }
    @Step("Verificando la cantidad de items")
    public void verifyItemCount(int expectedCount){
        Logs.info("Verificando la cantidad de items");
        assertThat(itemCounter).hasText(String.valueOf(expectedCount));
    }
    @Step("Haciendo click en el boton burger menu")
    public void clickBurgerMenuButton(){
        Logs.info("Haciendo click en el boton burger menu");
        burgerMenuButton.click();
    }
    @Step("Haciendo click en el boton checkout")
    public void clickCheckoutButton(){
        Logs.info("Haciendo click en el boton checkout");
        checkoutButton.click();
    }

}
