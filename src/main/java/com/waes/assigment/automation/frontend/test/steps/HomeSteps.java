package com.waes.assigment.automation.frontend.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.assigment.automation.frontend.test.pages.HomePage;

@Component
public class HomeSteps {

    @Autowired
    HomePage homePage;

    @Given("I am in the Home page")
    public void navigateToHomePage() {
        homePage.goToPage()
            .waitUntilPageIsLoaded();
    }

    @When("I click in the Login button")
    public void login() {
        homePage.clickOnLoginWithSpotify();
    }

    @Then("I land in the Home page")
    public void shouldSeeTheLoginPage() {
        Assert.assertTrue("The current page is not Home page", homePage.isCurrentPage());
        homePage.waitUntilPageIsLoaded();
    }
}
