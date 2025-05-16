/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Burger Menu Tests
 * Version: 1.0
 * */
package automation;

import annotations.Regression;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.BurgerMenu;
import pages.LoginPage;
import utilities.BaseTest;


public class BurgerMenuTests extends BaseTest {
    private BurgerMenu burgerMenu;
    private LoginPage loginPage;
    @BeforeEach
    public void setUp(Page page) {
        burgerMenu = new BurgerMenu(page);
        loginPage = new LoginPage(page);
        commonFlows.openBurgerMenu(page);
    }
    @Test
    @Regression
    public void verificandoBurgerMenuTest(){
        burgerMenu.verifyPage();
    }
    @Test
    @Regression
    public void logoutTest(){
        burgerMenu.clickLogout();

        loginPage.verifyPage();
    }

    @Test
    @Regression
    public void aboutButtonTest() {
        burgerMenu.verifyAboutLink("https://saucelabs.com/");
    }
}
