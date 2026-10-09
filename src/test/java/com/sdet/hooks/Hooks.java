package com.sdet.hooks;

import org.openqa.selenium.WebDriver;

import com.sdet.factory.DriverFactory;
import com.sdet.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        ConfigReader.loadProperties();
        driver = DriverFactory.createNewDriver();
        driver.get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}