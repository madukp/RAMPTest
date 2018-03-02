package org.ramp.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetUp {
	private static WebDriver driver;
	private static String baseUrl = PropertyFile.readProperty("baseURL");
	private static String driverPath = PropertyFile.readProperty("chrome.driver.path");
	private static String username = PropertyFile.readProperty("username");
	private static String password = PropertyFile.readProperty("password");

	public static void setupDriver() {

		// System.setProperty("webdriver.gecko.driver",driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		// driver.get(baseUrl);
		driver.get("http://" + username + ":" +password+"@"+baseUrl );
		driver.manage().window().maximize();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		driver.close();
		driver.quit();
	}

	public static void pauseDriver(int i) {
		
			driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
			//driver.wait(i);
		
	}

}
