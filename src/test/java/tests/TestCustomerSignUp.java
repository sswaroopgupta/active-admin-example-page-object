package tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SignUpPage;
import utils.driver.DriverFactory;

import static org.hamcrest.core.Is.is;
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

        HomePage homePage = new HomePage(driver).signUp().registerCustomerWith(customer, "john.doe@example.com", "password");

        assertTrue(homePage.hasThankYouMessageForSigningup());
        assertTrue(homePage.getGreeting().contains("Welcome " + customer + "! Not you?"));
        assertTrue(homePage.IsLogoutDisplayed());
        assertThat(homePage.numberOfAvailableProducts(), is(not(0)));

    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}