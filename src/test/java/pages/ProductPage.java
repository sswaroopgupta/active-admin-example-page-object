package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// Uses recommendations from https://github.com/SeleniumHQ/selenium/wiki/PageObjects
public class ProductPage {
    private final WebDriver webDriver;
    @FindBy(how = How.LINK_TEXT, linkText = "Add to Card")
    private WebElement addToCart;

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public CartPage addToCart() {
        this.addToCart.click();
        return new CartPage(webDriver);
    }
}
