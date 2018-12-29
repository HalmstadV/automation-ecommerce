import Pages.BoutiquePage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;


public class TrendyolTest extends BaseTest {


    @Test(priority = 1, sequential = true)
    public void Login() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = loginPage.Login();
        assertThat("Assertion of Login", homepage.getUserEmail(driver), containsString("pikdokenaral@gmail.com"));


    }

    @Test(priority = 2, sequential = true)
    public void VerifyBannerImages() {


        HomePage homePage = new HomePage(driver);
        homePage.printBannerImageInfo();


    }

    @Test(priority = 3, sequential = true)
    public void verifyBoutiqueImages() {


        HomePage homePage = new HomePage(driver);
        BoutiquePage boutiquePage = homePage.goToBoutiqueList();
        assertThat("Assertion of Boutique", boutiquePage.getUrl(), containsString("Butik/Liste"));
        boutiquePage.printProductImageInfo();
        boutiquePage.goToCart();
        assertThat("Assertion of Cart Product", boutiquePage.getUrl(), containsStringIgnoringCase("boutiqueId"));

    }

    @Test(priority = 4, sequential = true)
    public void addItemToCart() {
        CartPage cartPage = new CartPage(driver);
        cartPage.addToCart();

    }

    @AfterTest
    public void tearDown() {


        driver.manage().deleteAllCookies();
        driver.close();
    }


}
