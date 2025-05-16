/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Page Object Model for footer
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

public class Footer extends BasePage {
    private final Locator twitterButton;
    private final Locator facebookButton;
    private final Locator linkedinButton;

    public Footer(Page page) {
        super(page);
        twitterButton=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Twitter"));
        facebookButton= page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Facebook"));
        linkedinButton= page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LinkedIn"));

    }
    @Override
    public void verifyPage() {

    }
    @Step("Verificando los hipervinculos")
    public void verifyLinks(String twitterLink, String facebookLink, String linkedinLink){
        Logs.info("Verificando los hipervinculos");
        assertAll(
                () -> assertThat(twitterButton).isVisible(),
                () -> assertThat(twitterButton).isEnabled(),
                () -> assertThat(twitterButton)
                        .hasAttribute("href",twitterLink),
                () -> assertThat(facebookButton).isVisible(),
                () -> assertThat(facebookButton).isEnabled(),
                () -> assertThat(facebookButton)
                        .hasAttribute("href",facebookLink),
                () -> assertThat(linkedinButton).isVisible(),
                () -> assertThat(linkedinButton).isEnabled(),
                () -> assertThat(linkedinButton)
                        .hasAttribute("href",linkedinLink)
        );

    }
}
