
package com.sdet.stepdefinitions;

import org.testng.Assert;

import com.sdet.hooks.Hooks;
import com.sdet.pages.HomePage;
import com.sdet.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDefinitions {

    private HomePage homePage;
    private LoginPage loginPage;

    @Given("the user opens the application")
    public void theUserOpensTheApplication() {
        Assert.assertNotNull(Hooks.driver,
                "WebDriver was not initialized by the Cucumber Before hook");

        homePage = new HomePage(Hooks.driver);
    }

    @When("the user clicks the Signup Login link")
    public void theUserClicksTheSignupLoginLink() {
        homePage.clickSignupLogin();
        loginPage = new LoginPage(Hooks.driver);
    }

    @Then("the login page should be displayed")
    public void theLoginPageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "Login page heading was not displayed");
    }
}
