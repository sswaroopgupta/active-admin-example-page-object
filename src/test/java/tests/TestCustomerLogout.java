package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.driver.DriverFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestCustomerLogout {
    private static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void aNewlySignedUpCustomerShouldBeAbleToLogOut(){
        driver.get("http://localhost:8080");
        String customer = "Jane";

        HomePage homePage = new HomePage(driver)
                .signUp()
                .registerCustomerWith(customer, "jane.doe@example.com", "password")
                .LogOut();
        assertTrue(homePage.hasYouHaveBeenLoggedOut());

    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}