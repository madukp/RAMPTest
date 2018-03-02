package level1.ebay.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SetUp {
WebDriver  driver;
String baseUrl = PropertyFile.readProperty("baseURL");
String driverPath = PropertyFile.readProperty("firefox.driver.path");


public void setupDriver(){
	
System.setProperty("webdriver.gecko.driver",driverPath);
driver = new  FirefoxDriver();
driver.get(baseUrl);

}

public void quitDriver(){
	driver.close();
	driver.quit();
}

}
