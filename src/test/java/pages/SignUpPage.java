package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// Uses recommendations from https://github.com/SeleniumHQ/selenium/wiki/PageObjects
public class SignUpPage {

    private final WebDriver driver;
    @FindBy(how = How.NAME, name = "user[username]")
    private WebElement userName;
    @FindBy(how = How.NAME, name = "user[email]")
    private WebElement userEmail;
    @FindBy(how = How.NAME, name = "user[password]")
    private WebElement userPassword;
    @FindBy(how = How.NAME, name = "user[password_confirmation]")
    private WebElement confirm_password;
    @FindBy(how = How.NAME, name = "commit")
    private WebElement commit;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void enterCustomer(String customer) {
        userName.sendKeys(customer);
    }

    private void enterEmail(String email) {
        userEmail.sendKeys(email);
    }

    private void enterPassword(String password) {
        userPassword.sendKeys(password);
    }

    private void enterConfirmPassword(String confirmPassword) {
        confirm_password.sendKeys(confirmPassword);
    }

    private HomePage submit() {
        commit.click();
        return new HomePage(driver);
    }

    public HomePage registerCustomerWith(String customer, String email, String password) {
        enterCustomer(customer);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(password);
        return submit();
    }
}
