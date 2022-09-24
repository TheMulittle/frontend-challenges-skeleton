package com.waes.assigment.automation.frontend.test.steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.assigment.automation.frontend.test.pages.ProfilePage;

@Component
public class ProfileSteps {

    @Autowired
    ProfilePage profilePage;

    @Then("I should see the New Profile page")
    public void shouldSeeNewProfilePage() {
        profilePage.waitUntilPageIsLoaded();
        Assert.assertThat(profilePage.getCurrentUrl(), is("https://waesworks.bitbucket.io/app/newUser"));
    }

    @Then("I should see the Profile page")
    public void shouldSeeProfilePage() {
        profilePage.waitUntilPageIsLoaded();
        Assert.assertThat(profilePage.getCurrentUrl(), is("https://waesworks.bitbucket.io/app/profile"));
    }

    @Then("I should see the following profile message: $message")
    public void shouldSeeMessage(@Named("message") String message) {
        Assert.assertThat(profilePage.getProfileMessage(), containsString(message));
    }
}
