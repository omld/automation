package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginStepsTest {

    private LoginPage loginPage;

    public LoginStepsTest(LoginPage loginPage) {
        this.loginPage=loginPage;
    }

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        this.loginPage.navigateToLoginPage();
    }

    @When("^I login with (\\w+) and (.+)$")
    public void iLoginWithUsernameAndPassword(String userName, String password) {
        this.loginPage
                .sendUserName(userName)
                .sendPassword(password)
                .clickLoginButton();

    }

    @Then("^I should see a flash message saying (.*)$")
    public void iShouldSeeAFlashMessageSayingMessage(String message) {
        this.loginPage.validateLoginMessage(message);
    }

}
