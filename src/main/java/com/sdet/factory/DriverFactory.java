package com.sdet.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.sdet.utils.ConfigReader;

public class DriverFactory {
    static String  browser = ConfigReader.getProperty("browser");
	public static WebDriver createNewDriver() {
		switch (browser.toLowerCase()) {

        case "chrome":
            return new ChromeDriver();

        case "firefox":
            return new FirefoxDriver();

        case "edge":
            return new EdgeDriver();

        default:
            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
    }
	}	
}
