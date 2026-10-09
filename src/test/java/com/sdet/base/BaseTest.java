package com.sdet.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import com.sdet.factory.DriverFactory;
import com.sdet.utils.ConfigReader;

public class BaseTest {
	protected WebDriver driver ;
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		ConfigReader.loadProperties();
		driver= DriverFactory.createNewDriver();
		driver.get(ConfigReader.getProperty("url"));
	}
	@AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
