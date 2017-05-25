package tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.driver.DriverFactory;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestCustomerSignUp {
    private static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAfterSignUpCustomerShouldSeeItemsForPurchase(){
        driver.get("http://localhost:8080");
        String customer = "John";

        HomePage homePage = new HomePage(driver).navigateToSignUpPage()
                .registerCustomerWith(customer, "john.doe@example.com", "password");

        assertTrue(homePage.getGreeting().contains("Welcome " + customer + "! Not you?"));
        assertThat(homePage.getMessages(), hasItem("Thank you for signing up! You are now logged in."));
        assertThat(homePage.numberOfAvailableProducts(), is(not(0)));

    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}