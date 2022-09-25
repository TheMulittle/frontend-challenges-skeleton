package com.waes.assigment.automation.frontend.test.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import com.waes.assigment.automation.frontend.configuration.PageObject.PageObject;
import com.waes.assigment.automation.frontend.test.AbstractComponent;

@PageObject
public class HomePage extends AbstractComponent<HomePage> {
    public static final String PAGE_URL = "";

    @Autowired
    PlaylistPage playlistPage;

    @FindBy(linkText = "LOGIN WITH SPOTIFY")
    private WebElement loginWithSpotifyButton;

    public HomePage clickOnLoginWithSpotify() {
        click(loginWithSpotifyButton);
        return this;
    }

    public PlaylistPage playlistPage() {
        return playlistPage;
    }

    @Override
    protected List<WebElement> elementsToWait() {
        List<WebElement> elementToWait = new ArrayList<>();
        elementToWait.add(loginWithSpotifyButton);
        return elementToWait;
    }

    @Override
    protected String getPageAddress() {
        return PAGE_URL;
    }
}
