package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// Uses recommendations from https://github.com/SeleniumHQ/selenium/wiki/PageObjects
public class CartPage {
    private final WebDriver webDriver;
    @FindBy(how = How.XPATH, xpath = "//input[@value='Checkout Now!']")
    private WebElement checkoutNow;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public HomePage checkoutNow() {
        this.checkoutNow.click();
        return new HomePage(webDriver);
    }
}
