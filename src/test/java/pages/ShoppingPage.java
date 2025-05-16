/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Page Object Model for shopping
 * Version: 1.0
 * */
package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import utilities.BasePage;
import utilities.Logs;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ShoppingPage extends BasePage {
    private final Locator title;
    private final Locator inventoryList;
    private final Locator select;
    private final Locator itemImage;
    private final Locator itemName;
    private final Locator itemPrice;
    private final Locator addToCartButton;


    public ShoppingPage(Page page) {
        super(page);
        title = page.getByText("Products");
        inventoryList = page.getByTestId("inventory-list");
        select = page.getByTestId("product-sort-container");
        itemName = page.getByTestId("inventory-item-name");
        itemImage = page.locator(".inventory_item_img");
        itemPrice = page.getByTestId("inventory-item-price");
        addToCartButton = page.locator(".btn_inventory");

    }

    @Override
    @Step("verificando la pagina shopping")
    public void verifyPage() {
        Logs.info("verificando la pagina de shopping");
        assertAll(
                () -> assertThat(title).isVisible(),
                () -> assertThat(inventoryList).isVisible(),
                () -> assertThat(select)
        );
    }
    @Step("verificando el precio")
    public void verifyItemPrice(int index,String expected) {
        Logs.info("verificando el precio");
        assertThat(itemPrice.nth(index)).hasText(expected);
    }
    @Step("Haciendo click en todos los botones Add to cart")
    public void clickAddToCartButton(){
        Logs.info("Haciendo click en todos los botones Add to cart");
        final var list=addToCartButton.all();
        list.forEach(Locator::click);
    }
    @Step("Ordenando los Items")
    public void orderItems(String value){
        Logs.info("Ordenando los Items");
        select.selectOption(value);
    }
    @Step("Verificando el primer y ultimo precio")
    public void verifyItemPrices(String first,String last){
        Logs.info("Verificando el primer y ultimo precio");
        final var primerPrecio= itemPrice.first();
        final var segundoPrecio= itemPrice.last();

        assertAll(
                () -> assertThat(primerPrecio).hasText(first),
                () -> assertThat(segundoPrecio).hasText(last));
    }
    @Step("Verificando el primer y ultimo nombre")
    public void verifyItemNames(String first,String last){
        Logs.info("Verificando el primer y ultimo nombre");
        final var primerNombre= itemName.first();
        final var segundoNombre= itemName.last();

        assertAll(
                () -> assertThat(primerNombre).hasText(first),
                () -> assertThat(segundoNombre).hasText(last));

    }
    @Step("Haciendo click en la imagen según su index")
    public void clickImageByIndex(int index){
        Logs.info("Haciendo click en la imagen según su index");
        itemImage.nth(index).click();
    }

}
