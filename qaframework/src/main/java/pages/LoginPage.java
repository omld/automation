package pages;

import base.BasePage;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private final By userNameBy = By.id("username");
    private final By passwordBy = By.id("password");
    private final By loginButtonBy = By.cssSelector("button[type='submit'");
    private final String loginUrl = "https://the-internet.herokuapp.com/login";
    private final By loginMessageBy = By.id("flash");

    public LoginPage() {
        super();
    }

    public LoginPage sendUserName(String userName) {
        sendText(this.userNameBy,userName);
        return this;
    }

    public void clickLoginButton () {
        clickToElement(this.loginButtonBy);
    }

    public LoginPage sendPassword (String passWord) {
        sendText(this.passwordBy,passWord);
        return this;
    }
    public void navigateToLoginPage() {
        navigateToUrl(this.loginUrl);
    }

    public void validateLoginMessage(String message) {
        Assert.assertTrue(getTextFromElement(this.loginMessageBy).contains(message));
    }
}
