package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.SignUpPage;

public class HeaderComponent {
    private final WebDriver webDriver;
    @FindBy(how = How.LINK_TEXT, linkText = "Sign up")
    private WebElement signup;

    @FindBy(how = How.LINK_TEXT, linkText = "Log out")
    private WebElement logout;

    @FindBy(how = How.LINK_TEXT, linkText = "Log in")
    private WebElement login;

    @FindBy(how = How.LINK_TEXT, linkText = "Administration interface")
    private WebElement administratorInterface;

    @FindBy(how = How.XPATH, xpath = "//a[text()='Administration interface']/ancestor::div")
    private WebElement authenticationBanner;

    public HeaderComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public SignUpPage signUp() {
        signup.click();
        return new SignUpPage(webDriver);
    }

    public void logOut() {
        logout.click();
    }

    public String getGreeting() {
        return authenticationBanner.getText();
    }

    public void waitForOptionToBeAvailable(String option) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, 300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(option)));
    }

    public LoginPage logIn() {
        login.click();
        return new LoginPage(webDriver);
    }
}
