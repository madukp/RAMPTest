package org.ramp.demo;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.ramp.pageobj.AltimeterHomePage;
import org.ramp.pageobj.MulticasetPlusEventsTab;
import org.ramp.setup.SetUp;

public class TestRunner extends SetUp {

	AltimeterHomePage home;

	public void openRamp() {
		SetUp.setupDriver();
		// setup.pauseDriver(3000);
	}

	public void validateLicenseInfo() {
		home = new AltimeterHomePage();
		home.clickAltimterTab();
		home.verifyLicenseInfo();
	}

	// TBD
	public void validateSenderStatus() {

	}

	public void createEvent() {
		MulticasetPlusEventsTab event = new MulticasetPlusEventsTab();
		event.navigatetoEvents();
		event.createEventFlow();

	}

	public void viewEvent() {
		MulticasetPlusEventsTab event = new MulticasetPlusEventsTab();
		//event.navigatetoEvents();
		event.viewEvent();

	}
	
	
	
	@Test
	public void testsequence() {
		BasicConfigurator.configure();
		openRamp();
		createEvent();
		viewEvent();

	}

}
