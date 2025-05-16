/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Footer Tests
 * Version: 1.0
 * */
package automation;

import annotations.Regression;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Footer;
import utilities.BaseTest;

public class FooterTests extends BaseTest {
    private  Footer footer;
    @BeforeEach
    public void setUp(Page page) {
        footer = new Footer(page);
        commonFlows.goToShoppingPage(page);
    }

    @Test
    @Regression
    public void redesSocialesTest() {

        footer.verifyLinks(
                "https://twitter.com/saucelabs",
                "https://www.facebook.com/saucelabs",
                "https://www.linkedin.com/company/sauce-labs/"
        );
    }
}
