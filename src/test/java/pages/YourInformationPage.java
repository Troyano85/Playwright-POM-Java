/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Page Object Model for Your Information
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

public class YourInformationPage extends BasePage {
    private final Locator firstnameInput;
    private final Locator lastnameInput;
    private final Locator zipcodeInput;
    private final Locator continueButton;
    private final Locator title;
    private final Locator cancelButton;
    private final Locator errorMessage;

    public YourInformationPage(Page page) {
        super(page);
        firstnameInput = page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("First Name"));
        lastnameInput = page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Last Name"));
        zipcodeInput = page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Zip/Postal Code"));
        continueButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Continue"));
        cancelButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Go back Cancel"));
        title = page.getByText("Checkout: Your Information");
        errorMessage = page.getByTestId("error");

    }

    @Override
    @Step("Verificando la UI de Your Information")
    public void verifyPage() {
        assertAll(
                ()-> assertThat(title).isVisible(),
                ()-> assertThat(firstnameInput).isVisible(),
                ()-> assertThat(lastnameInput).isVisible(),
                ()-> assertThat(zipcodeInput).isVisible(),
                ()-> assertThat(continueButton).isVisible(),
                ()-> assertThat(cancelButton).isVisible()
        );

    }
    @Step("Rellenando el formulario")
    public void fillForm(String firstname,String lastname,String zipcode){
        if(!firstname.isEmpty()){// si no quiero escribir firstname el paso un string ""
            Logs.info("Escribiendo el firstname");
            firstnameInput.fill(firstname);
        }
        if(!lastname.isEmpty()){// si no quiero escribir lastname el paso un string ""
            Logs.info("Escribiendo el lastname");
            lastnameInput.fill(lastname);
        }
        if(!zipcode.isEmpty()){// si no quiero escribir zipcode el paso un string ""
            Logs.info("Escribiendo el zipcode");
            zipcodeInput.fill(zipcode);
        }
        continueButton.click();
    }
    @Step("Verificando el mensaje de error")
    public void verifyErrorMessage(String errorText){
        Logs.info("Verificando el mensaje de error");
        assertAll(
                ()->assertThat(errorMessage).hasText(errorText),
                ()->assertThat(errorMessage).isVisible()
        );
    }
    @Step("Haciendo click en el boton cancel")
    public void clickCancelButton(){
        Logs.info("Haciendo click en el boton cancel");
        cancelButton.click();
    }
}
