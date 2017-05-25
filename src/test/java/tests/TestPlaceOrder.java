package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import utils.driver.DriverFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestPlaceOrder {
    private static WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeClass
    public static void openBrowser(){
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPlaceAnOrder(){
        driver.get("http://localhost:8080");
        String customer = "ScroogeMcduck";

        homePage = new HomePage(driver)
                .navigateToLoginPage()
                .loginCustomerWith(customer, "password");

        ensureLoginIsSuccessful(customer);

        cartPage = addProductToCart("Beginning Ruby: From Novice to Professional");
        homePage = cartPage.checkoutNow();

        assertThat(homePage.getMessages(), hasItem("Thank you for your purchase! We will ship it shortly!"));
        homePage.logOut();
    }

    private CartPage addProductToCart(String product) {
        CartPage cartPage = homePage.selectProduct(product)
                .addToCart();
        return cartPage;
    }

    private void ensureLoginIsSuccessful(String customer) {
        assertTrue(homePage.getGreeting().contains("Welcome " + customer + "! Not you?"));
        assertThat(homePage.numberOfAvailableProducts(), is(not(0)));
    }

    @Test
    public void testCartRetainsItemsOnLogout(){
        driver.get("http://localhost:8080");
        String customer = "ScroogeMcduck";

        homePage = new HomePage(driver)
                .navigateToLoginPage()
                .loginCustomerWith(customer, "password");

        ensureLoginIsSuccessful(customer);

        cartPage = addProductToCart("Beginning Ruby: From Novice to Professional");
        homePage = cartPage.logOut();

        homePage.navigateToLoginPage()
                .loginCustomerWith(customer, "password");

        ensureLoginIsSuccessful(customer);

        cartPage = addProductToCart("The Well-Grounded Rubyist");
        homePage = cartPage.checkoutNow();

        assertThat( homePage.getMessages(), hasItem("Thank you for your purchase! We will ship it shortly!"));
        homePage.logOut();
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
