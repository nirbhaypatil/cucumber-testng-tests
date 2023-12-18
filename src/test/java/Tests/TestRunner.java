package Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = "stepdefinitions",
        tags = "@wip",
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        })
public class TestRunner extends AbstractTestNGCucumberTests {

}
