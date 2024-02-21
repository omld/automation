package com.qa.pom.factory;

import com.qa.pom.constants.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    public WebDriver initializeDriver (){

        Drivers  browser = Drivers.valueOf(System.getProperty("browser").toUpperCase());
        String browserVersion = System.getProperty("version");

        switch(browser) {
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").browserVersion(browserVersion).setup();
                WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case SAFARI -> {
                WebDriverManager.safaridriver().cachePath("Drivers").browserVersion(browserVersion).setup();
                WebDriver driver = new SafariDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case EDGE -> {
                WebDriverManager.edgedriver().cachePath("Drivers").browserVersion(browserVersion).setup();
                WebDriver driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            }
            default -> {
                WebDriverManager.chromedriver().cachePath("Drivers").browserVersion(browserVersion).setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            }
        }
    };

}
