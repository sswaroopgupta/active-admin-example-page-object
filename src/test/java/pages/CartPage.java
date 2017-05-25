package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.components.HeaderComponent;

import java.util.List;

// Uses recommendations from https://github.com/SeleniumHQ/selenium/wiki/PageObjects
public class CartPage {
    private final WebDriver webDriver;
    @FindBy(how = How.XPATH, xpath = "//input[@value='Checkout Now!']")
    private WebElement checkoutNow;
    private HeaderComponent header;
    @FindBy(how = How.XPATH, xpath = "//table/tbody/tr")
    public List<WebElement> products;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        header = new HeaderComponent(webDriver);
    }

    public HomePage checkoutNow() {
        this.checkoutNow.click();
        return new HomePage(webDriver);
    }

    public int getCartItemCount() {
        return products.size()-2;
    }

    public HomePage logOut() {
        header.logOut();
        return new HomePage(webDriver);
    }
}
