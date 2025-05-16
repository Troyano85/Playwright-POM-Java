package utilities;

import com.microsoft.playwright.Page;
import pages.LoginPage;
import pages.ShoppingPage;
import pages.TopBar;
import pages.YourCartPage;

public class CommonFlows {
    public void goToLoginPage(Page page){
        Logs.info("Navegando a la pagina");
        page.navigate("/");
    }
    public void goToShoppingPage(Page page){
        goToLoginPage(page);
        new LoginPage(page).fillForm("standard_user","secret_sauce");
    }
    public void openBurgerMenu(Page page){
        goToShoppingPage(page);
        new TopBar(page).clickBurgerMenuButton();
    }
    public void goToItemDetail(Page page ,int index){
        goToShoppingPage(page);
        new ShoppingPage(page).clickImageByIndex(index);
    }
    public void goToYourCart(Page page){
        goToShoppingPage(page);
        new TopBar(page).clickCheckoutButton();
    }
    public void goToYourInformation(Page page){
        goToYourCart(page);
        new YourCartPage(page).clickCheckoutButton();
    }
}
