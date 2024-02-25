package pages;

import base.BasePage;
import components.Button;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private final By userNameBy = By.id("username");
    private final By passwordBy = By.id("password");
    private final By loginButtonBy = By.cssSelector("button[type='submit'");
    private final String loginUrl = "https://the-internet.herokuapp.com/login";
    private final By loginMessageBy = By.id("flash");

    private Button loginButton;

    public LoginPage(Button loginButton) {
        super();
        this.loginButton = loginButton;
    }

    public LoginPage sendUserName(String userName) {
        sendText(this.userNameBy, userName);
        return this;
    }

    public void clickLoginButton() {
        loginButton.setButtonBy(this.loginButtonBy);
//        loginButton.clickOnButton(this.loginButtonBy);
        loginButton.clickOnButton();
//        clickToElement(this.loginButtonBy);
    }

    public LoginPage sendPassword(String passWord) {
        sendText(this.passwordBy, passWord);
        return this;
    }

    public void navigateToLoginPage() {
        navigateToUrl(this.loginUrl);
    }

    public void validateLoginMessage(String message) {
        Assert.assertTrue(getTextFromElement(this.loginMessageBy).contains(message));
    }
}
