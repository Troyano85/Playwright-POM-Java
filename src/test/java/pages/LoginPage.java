/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Page Object Model for Login
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

public class LoginPage extends BasePage {

    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator errorMessage;
    private final Locator title;

    public LoginPage(Page page) {
        super(page);
        usernameInput = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"));
        passwordInput = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        errorMessage = page.getByTestId("error");
        title = page.getByText("Swag Labs");

    }
    @Step("Verificando la pagina de login")
    @Override
    public void verifyPage() {
        Logs.info("Verificando la pagina de login");

        assertAll(
                () -> assertThat(usernameInput).isVisible(),
                () -> assertThat(passwordInput).isVisible(),
                () -> assertThat(loginButton).isVisible(),
                () -> assertThat(title).isVisible()
        );
    }
    @Step("Rellenando el formulario de login")
    public void fillForm(String username, String password){
        Logs.info("Escribiendo el username");
        usernameInput.fill(username);

        Logs.info("Escribiendo el password");
        passwordInput.fill(password);

        Logs.info("Haciendo click en login");
        loginButton.click();
    }
    @Step("Verificando el mensaje de error")
    public void verifyErrorMessage(String texto){
        Logs.info("Verificando el mensaje de error");
        assertAll(
                () ->assertThat(errorMessage).isVisible(),
                () ->assertThat(errorMessage).hasText(texto)
        );
    }

}
