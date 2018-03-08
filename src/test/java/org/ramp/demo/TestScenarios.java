package org.ramp.demo;

import org.ramp.pageobj.MulticasetPlusEventsTab;
import org.ramp.setup.SetUp;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TestScenarios extends SetUp {

	MulticasetPlusEventsTab event = new MulticasetPlusEventsTab();

	@Given("^user navigated to RAMP-Altimeter$")
	public void user_navigated_to_RAMP_Altimeter() {
		try {
			setupDriver();
		} catch (Exception ex) {
		}

	}

	@Then("^user create an event$")
	public void user_create_an_event() {
		try {
			event.navigatetoEvents();
			event.createEventFlow();
		} catch (Exception ex) {
		}

	}

}
