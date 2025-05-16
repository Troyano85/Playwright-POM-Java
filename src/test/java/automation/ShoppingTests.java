/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Shopping Tests
 * Version: 1.0
 * */
package automation;

import annotations.Regression;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ShoppingPage;
import pages.TopBar;
import utilities.BaseTest;

public class ShoppingTests extends BaseTest {
    private ShoppingPage shoppingPage;
    private TopBar topBar;

    @BeforeEach
    public void setUp(Page page) {
        shoppingPage = new ShoppingPage(page);
        topBar = new TopBar(page);
        commonFlows.goToShoppingPage(page);
    }
    @Test
    @Regression
    public void verificarPaginaShoppingTest() {
       shoppingPage.verifyPage();
    }

    @Test
    @Regression
    public void precioTest() {
        shoppingPage.verifyItemPrice(2,"$15.99");
    }

    @Test
    @Regression
    public void addToCartTest() {
        shoppingPage.clickAddToCartButton();

        topBar.verifyItemCount(6);
    }
    @Test
    @Regression
    public void ordenarMenorMayorPreciotest() {
        shoppingPage.orderItems("lohi");
        shoppingPage.verifyItemPrices("$7.99","$49.99");
    }
    @Test
    @Regression
    public void ordenarMayorMenorTest() {
        shoppingPage.orderItems("hilo");
        shoppingPage.verifyItemPrices("$49.99","$7.99");
    }
    @Test
    @Regression
    public void ordenarMayorMenorNombretest(){
        shoppingPage.orderItems("za");
        shoppingPage.verifyItemNames("Test.allTheThings() T-Shirt (Red)","Sauce Labs Backpack");
    }
}
