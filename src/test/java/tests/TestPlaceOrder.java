package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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

    @BeforeClass
    public static void openBrowser(){
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPlaceAnOrder(){
        driver.get("http://localhost:8080");
        String customer = "Aaron12";

        HomePage homePage = new HomePage(driver).signUp().registerCustomerWith(customer, "aaron12@example.com", "password");

        assertTrue(homePage.getGreeting().contains("Welcome " + customer + "! Not you?"));
        assertThat(homePage.numberOfAvailableProducts(), is(not(0)));

        assertThat( homePage.selectProduct("Beginning Ruby: From Novice to Professional")
                .addToCart()
                .checkoutNow()
                .getMessages(), hasItem("Thank you for your purchase! We will ship it shortly!")
        );
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
