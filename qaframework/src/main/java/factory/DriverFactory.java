package factory;

import constants.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null){
            webDriver.set(initializeDriver());
        }
        return webDriver.get();
    }
    private static WebDriver initializeDriver (){
        WebDriver driver = null;

        Drivers  browser = Drivers.valueOf(System.getProperty("browser").toUpperCase());
        String browserVersion = System.getProperty("version");

        switch(browser) {
            case FIREFOX -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                WebDriverManager.firefoxdriver().cachePath("Drivers").browserVersion(browserVersion).setup();
                driver = new FirefoxDriver(firefoxOptions);
            }
            case SAFARI -> {
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                WebDriverManager.safaridriver().cachePath("Drivers").browserVersion(browserVersion).setup();
                driver = new SafariDriver(safariOptions);
            }
            case EDGE -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                WebDriverManager.chromedriver().cachePath("Drivers").browserVersion(browserVersion).setup();
                driver = new EdgeDriver(edgeOptions);
            }
            default -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver(chromeOptions);
            }
        }
        //maximize window once driver us setup
        driver.manage().window().maximize();
        return driver;
    };

    public static void  quitDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }
}
