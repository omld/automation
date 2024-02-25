package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue ={"stepDefinitions"},
                 monochrome = true,
                plugin ={"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
