package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.components.HeaderComponent;

import java.util.List;

// Uses recommendations from https://github.com/SeleniumHQ/selenium/wiki/PageObjects
public class HomePage {
    private final WebDriver webDriver;
    private HeaderComponent header;

    @FindBy(how = How.CLASS_NAME, className = "product")
    private List<WebElement> products;

    @FindBy(how = How.XPATH, xpath = "//div[@id = 'flash_notice' and text() = 'Thank you for signing up! You are now logged in.']")
    private WebElement thankYouForSigningUp;

    @FindBy(how = How.XPATH, xpath = "//div[@id = 'flash_notice' and text() = 'Thank you for your purchase! We will ship it shortly!']")
    private WebElement thankYouMessageForPurchase;

    @FindBy(how = How.XPATH, xpath = "//div[@id = 'flash_notice' and text() = 'You have been logged out.']")
    private WebElement youHaveBeenLoggedOut;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        header = new HeaderComponent(webDriver);
    }

    public SignUpPage signUp() {
        return header.signUp();
    }

    public HomePage logOut() {
        header.logOut();
        return this;
    }

    public String getGreeting() {
        return header.getGreeting();
    }

    public boolean IsLogoutDisplayed() {
        return header.IsLogoutDisplayed();
    }

    public boolean IsLoginDisplayed() {
        return header.IsLoginDisplayed();
    }

    public int numberOfAvailableProducts() {
        return products.size();
    }

    public ProductPage selectProduct(String product){
        webDriver.findElement(By.linkText(product)).click();
        return new ProductPage(webDriver);
    }

    public boolean hasThankYouMessageForSigningup() {
        return thankYouForSigningUp.isDisplayed();
    }

    public boolean hasYouHaveBeenLoggedOut() {
        return youHaveBeenLoggedOut.isDisplayed();
    }

    public boolean hasThankYouMessageForPurchase() {
        return thankYouMessageForPurchase.isDisplayed();
    }
}
