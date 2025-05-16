/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Page Object Model for burger menu
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

public class BurgerMenu extends BasePage {
    private final Locator allItemsButton;
    private final Locator aboutButton;
    private final Locator logoutButton;
    private final Locator resetAppStateButton;

    public BurgerMenu(Page page) {
        super(page);
        allItemsButton = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("All Items"));
        aboutButton = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("About") );
        logoutButton = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Logout"));
        resetAppStateButton = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Reset App State"));
    }

    @Override
    @Step("Verificando los elementos del burger menú")
    public void verifyPage() {
        Logs.info("Verificando los elementos del burger menú");
        assertAll(
                ()->assertThat(allItemsButton).isVisible(),
                ()->assertThat(aboutButton).isVisible(),
                ()->assertThat(logoutButton).isVisible(),
                ()->assertThat(resetAppStateButton).isVisible()
        );
    }
    @Step("Haciendo click en logout")
    public void clickLogout (){
        Logs.info("Haciendo click en logout");
        logoutButton.click();
    }
    @Step("Verificando el hipervinculo externo")
    public void verifyAboutLink(String link){
        Logs.info("Verificando el hipervinculo externo");
        assertAll(
                () -> assertThat(aboutButton).isVisible(),
                () -> assertThat(aboutButton).isEnabled(),
                () -> assertThat(aboutButton).hasAttribute("href",link)
        );
    }
}
