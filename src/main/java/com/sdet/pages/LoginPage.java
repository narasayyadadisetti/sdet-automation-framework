package com.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	   private By emailField =
	            By.cssSelector("input[data-qa='login-email']");

	    private By passwordField =
	            By.cssSelector("input[data-qa='login-password']");

	    private By loginButton =
	            By.cssSelector("button[data-qa='login-button']");
	    
	    private By loginPageHeading =
	            By.xpath("//h2[normalize-space()='Login to your account']");
	    
	    private By loginErrorMessage =
	            By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
	  
	    public LoginPage(WebDriver driver) {
	        super(driver);
		}

		public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	    
	    public boolean isLoginPageDisplayed() {
	        return driver.findElement(loginPageHeading).isDisplayed();
	    }
	    
	    public boolean isLoginErrorDisplayed() {
	        return driver.findElement(loginErrorMessage).isDisplayed();
	    }
}
