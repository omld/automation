package base;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriverWait wait;

    public BasePage() {
    }

    protected void logCurrentThread() {
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected void navigateToUrl(String url) {
        getDriver().get(url);
    }

    protected void sendText(By by, String textToBeSent) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToBeSent);
    }

    protected void clickToElement(By by) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected String getTextFromElement(By by) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }
}
