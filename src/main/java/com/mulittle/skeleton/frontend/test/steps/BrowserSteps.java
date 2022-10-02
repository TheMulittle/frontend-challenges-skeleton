package com.mulittle.skeleton.frontend.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.web.selenium.WebDriverProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BrowserSteps {

    @Autowired
    WebDriverProvider webDriverProvider;

    @Given("I am not authenticated")
    public void eraseAuthentication() {
        webDriverProvider.get().manage().deleteAllCookies();
    }

    @Given("I am authenticated")
    public void authenticate() {
        
    }
}
