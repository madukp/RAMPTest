package org.ramp.pageobj;

import org.openqa.selenium.support.ui.Select;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ramp.setup.Common;
import org.ramp.setup.SetUp;

public class MulticasetPlusEventsTab extends SetUp {

	private WebElement multicast;
	private WebElement events;
	private WebElement createEvent;
	private WebElement eventName;
	private WebElement eventStartTime;
	private WebElement eventEndTime;
	private WebElement selectSenders;
	private WebElement senderCheckBox;
	private WebElement closeSenders;
	private Select selectMulticastChannel;
	private WebElement contnetServerURL;
	private WebElement eventSave;
	final static Logger logger = Logger.getLogger(AltimeterHomePage.class);

	public void navigatetoEvents() {
		multicast = SetUp.getDriver().findElement(By.xpath(".//*[@id='mpApp']"));
		multicast.click();
		events = SetUp.getDriver().findElement(By.xpath(".//*[@id='eventsTab']/a"));
		events.click();
	}

	public void createEventFlow() {
		WebDriverWait wait = new WebDriverWait(SetUp.getDriver(), 10000);
		Common commonPara = new Common();
		String startTime = commonPara.getCurrentTime();
		String endtTime = commonPara.getLaterTimeStamp(1);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//img[@class='listAction'][@src='images/create.svg']")));
		createEvent = SetUp.getDriver().findElement(By.xpath(".//img[@class='listAction'][@src='images/create.svg']"));
		createEvent.click();
		// Fill events details in popup
		SetUp.pauseDriver(5);
		eventName = SetUp.getDriver().findElement(By.xpath(".//*[@id='multicastEventName']"));
		eventName.sendKeys("TestEv2");
		eventStartTime = SetUp.getDriver().findElement(By.xpath(".//*[@id='startTime']"));
		eventStartTime.sendKeys(startTime);
		eventEndTime = SetUp.getDriver().findElement(By.xpath(".//*[@id='endTime']"));
		eventEndTime.sendKeys(endtTime);
		selectSenders = SetUp.getDriver().findElement(By.xpath("//span[@id='selectedAgents']/preceding-sibling::*[1]"));
		selectSenders.click();
		senderCheckBox = SetUp.getDriver().findElement(By.xpath(".//*[@id='chkbx000']"));
		senderCheckBox.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//div[@id='rr_details0']/*[2]//div[@class='rr_modalRow']//button[@id='rr_close']")));		
		closeSenders = SetUp.getDriver().findElement(By.xpath("(//*[@id='rr_close'])[2]"));
		closeSenders.click();
		selectMulticastChannel = new Select(SetUp.getDriver().findElement(By.xpath(".//*[@id='multicastChannelID']")));
		selectMulticastChannel.selectByVisibleText("Channel 1");
		contnetServerURL = SetUp.getDriver().findElement(By.xpath(".//*[@id='sourceUrl']"));
		contnetServerURL.sendKeys("https://mnmedias.api.telequebec.tv/m3u8/29880.m3u8");
		eventSave = SetUp.getDriver().findElement(By.xpath(".//*[@id='createevent']"));
		eventSave.click();
	       // Switching to Alert   This segment is not working yet..      
        Alert alert = SetUp.getDriver().switchTo().alert();	
        alert.accept();
 /*
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Keyboard kb = ((RemoteWebDriver) SetUp.getDriver()).getKeyboard();
		kb.pressKey(Keys.RETURN);
        */
        
        
	}
	

}
