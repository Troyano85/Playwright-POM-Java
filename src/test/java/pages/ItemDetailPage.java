/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Page Object Model for item Detail
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

public class ItemDetailPage extends BasePage {
    private final Locator itemName;
    private final Locator itemDescription;
    private final Locator itemPrice;
    private final Locator itemImage;
    private final Locator addToCartButton;
    private final Locator backToProductsButton;

    public ItemDetailPage(Page page) {
        super(page);
        itemName = page.getByTestId("inventory-item-name");
        itemDescription = page.getByTestId("inventory-item-desc");
        itemPrice = page.getByTestId("inventory-item-price");
        itemImage = page.getByTestId("item-sauce-labs-backpack-img");
        addToCartButton = page.locator(".btn_inventory");
        backToProductsButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go back Back to products"));
    }

    @Override
    @Step("Verificando pagina item detalles")
    public void verifyPage() {
        Logs.info("Verificando pagina item detalles");
        assertAll(
                () -> assertThat(itemName).isVisible(),
                () -> assertThat(itemDescription).isVisible(),
                () -> assertThat(itemPrice).isVisible(),
                () -> assertThat(itemImage).isVisible(),
                () -> assertThat(addToCartButton).isVisible(),
                () -> assertThat(backToProductsButton).isVisible()
        );
    }
    @Step("Haciendo click en el boton back to products")
    public void clickBackToProducts(){
        Logs.info("Haciendo click en el boton back to products");
        backToProductsButton.click();
    }

}
