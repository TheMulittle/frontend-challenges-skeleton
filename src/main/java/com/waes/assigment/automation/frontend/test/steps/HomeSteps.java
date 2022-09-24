package com.waes.assigment.automation.frontend.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.assigment.automation.frontend.test.pages.HomePage;

@Component
public class HomeSteps {

    @Autowired
    HomePage homePage;

    @Given("I navigate to the Home page")
    @When("I navigate to the Home page")
    public void navigateToHomePage() {
        homePage.navigateTo();
    }

    @Given("I navigate to the Sign Up page")
    public void navigateToSignUpPage() {
        homePage.navigateTo()
                .clickOnSignUpLink()
                .waitUntilPageIsLoaded();
    }


    @When("I click in the Sign Up link")
    public void clickInSignUpLink() {
        homePage.clickOnSignUpLink()
                .waitUntilPageIsLoaded();
    }

    @When("I click in the Login link")
    public void clickInLoginLink() {
        homePage.clickOnLoginLink()
                .waitUntilPageIsLoaded();
    }
}
