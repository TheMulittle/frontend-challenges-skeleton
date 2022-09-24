package com.waes.assigment.automation.frontend.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.assigment.automation.frontend.test.pages.CommonPage;

@Component
public class BrowserSteps {

    @Autowired
    CommonPage commonPage;


    @Given("I close the browser")
    public void openBroswer() {
        commonPage.keepSession();
        commonPage.closeBrowser();
    }

    @When("I re-open the browser")
    public void reOpenBroswer() {
        commonPage.reopenBroswer();
    }
}
