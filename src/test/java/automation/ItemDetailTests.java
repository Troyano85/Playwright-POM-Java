/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Item Detail Tests
 * Version: 1.0
 * */
package automation;

import annotations.Regression;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ItemDetailPage;
import pages.ShoppingPage;
import utilities.BaseTest;


public class ItemDetailTests extends BaseTest {
    private ItemDetailPage itemDetailPage;
    private ShoppingPage shoppingPage;
    @BeforeEach
    public void setUp(Page page) {
        itemDetailPage = new ItemDetailPage(page);
        commonFlows.goToItemDetail(page, 0);
        shoppingPage = new ShoppingPage(page);
    }

    @Test
    @Regression
    public void verificandoDetalleItemTest() {
        itemDetailPage.verifyPage();
    }

    @Test
    @Regression
    public void blackToProductTest() {

        itemDetailPage.clickBackToProducts();

        shoppingPage.verifyPage();
    }
}
