package com.qa.pom.base;

import com.qa.pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private  ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    @BeforeMethod
    public void startDriver(){
        setDriver(new DriverManager().initializeDriver());
    }

    @AfterMethod
    public void quitDriver() {
        getDriver().quit();
    }
    protected WebDriver getDriver() {
        return this.driver.get();
    }
}
