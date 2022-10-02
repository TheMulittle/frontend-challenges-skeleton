package com.mulittle.skeleton.frontend.test.steps;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mulittle.skeleton.frontend.test.PasswordManager;
import com.mulittle.skeleton.frontend.test.pages.LoginPage;

@Component
public class LoginSteps {

    @Autowired
    LoginPage loginPage;

    @When("I login with {a|an} '$userType' user and its password")
    public void login(String userType) {
        String user = PasswordManager.getUserName(userType);
        String password = PasswordManager.getUserPassword(userType);
        loginPage.login(user, password)
                .playlistPage()
                .waitUntilPageIsLoaded();
    }
}
