package com.mulittle.skeleton.frontend.pages;


import java.util.ArrayList;
import java.util.List;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import com.mulittle.skeleton.frontend.AbstractComponent;
import com.mulittle.skeleton.frontend.configuration.spring.PageObject;

@PageObject
public class HomePage extends AbstractComponent<HomePage> {

    PlaylistPage playlistPage;

    @FindBy(linkText = "LOGIN WITH SPOTIFY")
    private WebElement loginWithSpotifyButton;

    @Autowired
    public HomePage(WebDriverProvider webDriverProvider, PlaylistPage playlistPage) {
        super(webDriverProvider, "");
        this.playlistPage = playlistPage;
    }

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
}
