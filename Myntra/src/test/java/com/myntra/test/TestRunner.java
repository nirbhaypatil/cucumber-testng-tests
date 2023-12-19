package com.myntra.test;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/resources/Features",glue = "com.jarvis.stepdefinations",dryRun = false)//tags="@Regrassion"

public class TestRunner {

}
