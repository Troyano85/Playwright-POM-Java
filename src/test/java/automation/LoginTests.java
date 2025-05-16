/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Login Tests
 * Version: 1.0
 * */
package automation;

import annotations.Regression;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    public void setUp(Page page) {
        loginPage =new LoginPage(page);
        commonFlows.goToLoginPage(page);
    }

    @Test
    @Regression
    public void mensajeErrorTest() {
        loginPage.fillForm("locked_out_user","secret_sauce");
        loginPage.verifyErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    @Regression
    public void verificarPaginaLogintest() {
        loginPage.verifyPage();
    }
    @Test
    @Regression
    public void loginTest(){
       loginPage.fillForm("standard_user","secret_sauce");
    }
}
