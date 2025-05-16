/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: your Information Tests
 * Version: 1.0
 * */
package automation;

import annotations.Regression;
import com.microsoft.playwright.Page;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.YourCartPage;
import pages.YourInformationPage;
import utilities.BaseTest;

public class YourInformationTests extends BaseTest {
    private YourInformationPage yourInformationPage;
    private YourCartPage yourCartPage;
    private User user;

    @BeforeEach
    public void setup(Page page){
        yourInformationPage = new YourInformationPage(page);
        yourCartPage = new YourCartPage(page);
        commonFlows.goToYourInformation(page);
        user = User.generarUsuario();
    }
    @Test
    @Regression
    public void verificarPaginatest(){
        yourInformationPage.verifyPage();
    }
    @Test
    @Regression
    public void backToYourCartTest(){
         yourInformationPage.clickCancelButton();

         yourCartPage.verifyPage();
    }
    @Test
    @Regression
    public void faltaFirstNameTest(){
        yourInformationPage.fillForm("",user.lastname(), user.zipcode());
        yourInformationPage.verifyErrorMessage("Error: First Name is required");
    }
    @Test
    @Regression
    public void faltaLastNameTest(){
        yourInformationPage.fillForm(user.firstname(), "", user.zipcode());
        yourInformationPage.verifyErrorMessage("Error: Last Name is required");
    }
    @Test
    @Regression
    public void faltaZipCodeTest(){
        yourInformationPage.fillForm(user.firstname(), user.lastname(), "");
        yourInformationPage.verifyErrorMessage("Error: Postal Code is required");
    }
}
