package com.sdet.tests;

import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sdet.base.BaseTest;
import com.sdet.pages.HomePage;
import com.sdet.pages.LoginPage;

public class LoginTest extends BaseTest{	
	
	
	@Test(dataProvider="validLoginData",groups = {"smoke"})
	public void verifyLoginPage(String email,String password) {

	    HomePage homePage = new HomePage(driver);

	    homePage.clickSignupLogin();

	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterEmail(email);
	    loginPage.enterPassword(password);
	    loginPage.clickLogin();
	    
	    Assert.assertTrue(loginPage.isLoginErrorDisplayed());
	}
	
	
	@Test(dataProvider ="invalidLoginData" ,groups =  {"regression"})
	public void loginWithInvalidCredentials(String email,String password) {

	    HomePage homePage = new HomePage(driver);

	    homePage.clickSignupLogin();

	    LoginPage loginPage = new LoginPage(driver);

	    loginPage.enterEmail(email);
	    loginPage.enterPassword(password);
	    loginPage.clickLogin();

	    Assert.assertTrue(loginPage.isLoginErrorDisplayed());
	}
	

	@DataProvider(name = "invalidLoginData")
	public Object[][] invalidLoginData() {

	    return new Object[][] {
	        {"invalid@test.com", "wrongpassword"},
	        {"test@test.com", "wrongpassword123"}
	    };
	}
	
	@DataProvider(name = "validLoginData")
	public Object[][] validLoginData() {
	    return new Object[][] {
	        {"your-email@example.com", "your-password"}
	    };
	}
}