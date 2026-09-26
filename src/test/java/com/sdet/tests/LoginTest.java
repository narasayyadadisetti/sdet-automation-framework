package com.sdet.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void openApplication() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}