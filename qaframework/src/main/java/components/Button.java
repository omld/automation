package components;

import base.BasePage;
import org.openqa.selenium.By;

public class Button extends BasePage {

//    private By buttonBy = By.cssSelector("button[type='submit'");
    private By buttonBy = By.cssSelector("");

    public By getButtonBy() {
        return buttonBy;
    }
    public void setButtonBy(By buttonBy) {
        this.buttonBy = buttonBy;
    }
    public Button() {
        super();
    }

    public void clickOnButton (By by) {
        clickToElement(by);
    }
    public void clickOnButton () {
        clickToElement(this.buttonBy);
    }
}
