package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// Uses recommendations from https://github.com/SeleniumHQ/selenium/wiki/PageObjects
public class HomePage {
    private final WebDriver webDriver;
    @FindBy(how = How.LINK_TEXT, linkText = "Sign up")
    private WebElement signup;

    @FindBy(how = How.LINK_TEXT, linkText = "Log in")
    private WebElement login;

    @FindBy(how = How.LINK_TEXT, linkText = "Log out")
    private WebElement logout;

    @FindBy(how = How.LINK_TEXT, linkText = "Administration interface")
    private WebElement administratorInterface;

    @FindBy(how = How.XPATH, xpath = "//a[text()='Administration interface']/ancestor::div")
    private WebElement authenticationBanner;

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
    }

    public SignUpPage signUp() {
        signup.click();
        return new SignUpPage(webDriver);
    }

    public HomePage LogOut() {
        logout.click();
        return this;
    }

    public String getGreeting() {
        return authenticationBanner.getText();
    }

    public boolean IsLogoutDisplayed() {
        return logout.isDisplayed();
    }

    public boolean IsLoginDisplayed() {
        return login.isDisplayed();
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
