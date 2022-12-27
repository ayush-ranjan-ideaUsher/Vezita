package Stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "Stepdefinitions" }, plugin = { "pretty",
		"html:target/Reports/HTMLReport/firstReport.html", "pretty", "json:target/Reports/JSONReport/firstReport.json",
		"pretty", "junit:target/Reports/JunitReport/firstReport.xml" }, dryRun = true)
public class VezitaRunnerClass {

}
