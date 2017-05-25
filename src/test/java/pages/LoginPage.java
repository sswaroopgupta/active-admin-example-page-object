package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(how = How.NAME, name = "login")
    private WebElement userName;
    @FindBy(how = How.NAME, name = "password")
    private WebElement userPassword;
    @FindBy(how = How.NAME, name = "commit")
    private WebElement commit;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void enterCustomerName(String customer) {
        userName.sendKeys(customer);
    }

    private void enterPassword(String password) {
        userPassword.sendKeys(password);
    }

    private HomePage submit() {
        commit.click();
        return new HomePage(driver);
    }

    public HomePage loginCustomerWith(String customer, String password) {
        enterCustomerName(customer);
        enterPassword(password);
        return submit();
    }

}
