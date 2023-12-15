package Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features="src/test/resources/",
                  glue="stepdefinitions",
                  tags="@wip"  )
public class TestRunner extends AbstractTestNGCucumberTests {

}
