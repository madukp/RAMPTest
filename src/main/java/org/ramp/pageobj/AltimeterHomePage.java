package org.ramp.pageobj;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ramp.setup.SetUp;

public class AltimeterHomePage extends SetUp {

	private WebElement altimeterTab;
	private WebElement licenseDetails;
	private String licenseDetailstext;
	private WebDriver driver;
	final static Logger logger = Logger.getLogger(AltimeterHomePage.class);
	// click on the tab "Altimter"

	public void AltimeterHomePage() {

	}

	public void clickAltimterTab() {
		altimeterTab = SetUp.getDriver().findElement(By.xpath(".//*[@id='alApp']"));
		// driver.findElement(By.xpath(".//*[@id='alApp']"));

		if (altimeterTab.isDisplayed()) {
			logger.info("altimeterTab is displayed");
		}
		altimeterTab.click();
	}

	/*
	 * verify license info and log the status. if it is expired mentioned in the
	 * log, still continue with limited features.
	 */

	public void verifyLicenseInfo() {
		licenseDetails = SetUp.getDriver().findElement(By.xpath("html/body/div[1]/center[2]/div/ul/li[1]"));
		licenseDetailstext = licenseDetails.getText();
		if (licenseDetailstext.contains("No valid Altimeter license found")) {
			System.out.println("*********************************************");
			logger.warn("License expired version. Running with limitted conditions");
			System.out.println("*********************************************");
		} else {
			logger.info("Valid License founded");

		}
	}

}
