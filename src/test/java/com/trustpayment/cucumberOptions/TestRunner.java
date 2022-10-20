package com.trustpayment.cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/org/example/features",
        glue = "org.example.stepDefinitions",tags="@SmokeTest and @RegTest")

public class TestRunner extends AbstractTestNGCucumberTests {
}


