package org.ramp.demo;

	import org.junit.runner.RunWith;
	import cucumber.api.CucumberOptions;
	import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber-report.json" },
			glue = "org.ramp.demo",
			features = "src\\resources\\testcase\\Events.feature"

	)

	public class RunTest {

	}

