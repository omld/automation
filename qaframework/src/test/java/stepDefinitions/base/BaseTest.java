package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static factory.DriverFactory.getDriver;
import static factory.DriverFactory.quitDriver;

public class BaseTest {

    @Before
    public void  initDriver(){
        getDriver();
    }

    @After
    public void sutDown() {
        quitDriver();
    }

}
