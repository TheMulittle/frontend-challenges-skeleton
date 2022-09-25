package com.waes.assigment.automation.frontend.test.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.assigment.automation.frontend.test.pages.PlaylistPage;

@Component
public class PlaylistSteps {

    @Autowired
    PlaylistPage playlistPage;

    @When("I click on Tile number $tileNumber")
    public void clickInSignUpLink(int tileNumber) {
        playlistPage.clickNthTile(tileNumber);
    }

    @When("I navigate to Playlist page")
    public void navigateTo() {
        playlistPage.goToPage();
    }

    @Then("I land in the Playlist page")
    public void assertPlaylistPage() {
        Assert.assertTrue("Page does not match playlist page", playlistPage.isCurrentPage());
    }
}
