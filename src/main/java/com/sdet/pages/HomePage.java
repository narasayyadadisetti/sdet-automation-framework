package com.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	private By signupLoginButton = By.linkText("Signup / Login");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickSignupLogin() {
		driver.findElement(signupLoginButton).click();
	}

}
