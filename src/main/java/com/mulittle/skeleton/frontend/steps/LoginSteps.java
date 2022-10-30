package com.mulittle.skeleton.frontend.steps;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mulittle.skeleton.frontend.pages.LoginPage;
import com.mulittle.skeleton.frontend.services.PasswordManagerService;

@Component
public class LoginSteps {

    @Autowired
    LoginPage loginPage;

    @When("I login with {a|an} '$userType' user and its password")
    public void login(String userType) {
        String user = PasswordManagerService.getUserName(userType);
        String password = PasswordManagerService.getUserPassword(userType);
        loginPage.login(user, password)
                .playlistPage()
                .waitUntilPageIsLoaded();
    }
}
