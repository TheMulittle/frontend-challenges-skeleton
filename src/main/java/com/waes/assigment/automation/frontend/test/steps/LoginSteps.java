package com.waes.assigment.automation.frontend.test.steps;

import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.assigment.automation.frontend.test.pages.LoginPage;

@Component
public class LoginSteps {

    @Autowired
    LoginPage loginPage;

    @When("I try to Log In")
    public void login() {
        loginPage.clickOnLoginButton();
    }

    @When("fill the Login page with following information: $informationTable")
    public void loginPage(@Named("$informationTable") ExamplesTable informationTable) {
        Map<String, String> informationToFill = informationTable.getRowsAsParameters(true).get(0).values();
        loginPage.typeOnUserNameField(informationToFill.get("userName"))
                .typeOnPasswordField(informationToFill.get("password"));
    }

    @Then("I should see the Login page")
    @Alias("I should see that I am still in the Login page")
    public void shouldSeeTheLoginPage() {
        loginPage.waitUntilPageIsLoaded();
        Assert.assertThat(loginPage.getCurrentUrl(), is("https://waesworks.bitbucket.io/app/login"));
    }
}
