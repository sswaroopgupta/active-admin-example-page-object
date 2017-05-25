package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.components.HeaderComponent;

import java.util.ArrayList;
import java.util.List;

// Uses recommendations from https://github.com/SeleniumHQ/selenium/wiki/PageObjects
public class HomePage {
    private final WebDriver webDriver;
    private HeaderComponent header;

    @FindBy(how = How.CLASS_NAME, className = "product")
    private List<WebElement> products;

    @FindBy(how = How.XPATH, xpath = "//div[@id = 'flash_notice']")
    private List<WebElement> flashNotices;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        header = new HeaderComponent(webDriver);
    }

    public SignUpPage navigateToSignUpPage() {
        return header.signUp();
    }

    public LoginPage navigateToLoginPage() {
        return header.logIn();
    }

    public HomePage logOut() {
        header.logOut();
        return this;
    }

    public String getGreeting() {
        return header.getGreeting();
    }

    public HomePage waitForOptionToBeAvailable(String option) {
        header.waitForOptionToBeAvailable(option);
        return this;
    }

    public int numberOfAvailableProducts() {
        return products.size();
    }

    public ProductPage selectProduct(String product){
        webDriver.findElement(By.linkText(product)).click();
        return new ProductPage(webDriver);
    }

    public List<String> getMessages(){
        List<String> messages = new ArrayList<>();
        for(WebElement flashNotice:flashNotices){
            messages.add(flashNotice.getText());
        }
        return messages;
    }

}
