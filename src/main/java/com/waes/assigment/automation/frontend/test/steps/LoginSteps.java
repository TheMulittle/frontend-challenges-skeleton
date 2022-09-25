package com.waes.assigment.automation.frontend.test.steps;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.assigment.automation.frontend.test.pages.LoginPage;

@Component
public class LoginSteps {

    @Autowired
    LoginPage loginPage;

    @When("I login with user '$user' and its password")
    public void login(String user) {
        loginPage.login(user, "")
                .playlistPage()
                .waitUntilPageIsLoaded();
    }
}
