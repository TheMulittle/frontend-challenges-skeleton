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
public class PlaylistPage extends AbstractComponent<PlaylistPage> {
    @FindBy(css = ".SpotifyButton")
    private WebElement reorderButton;

    @FindBy(css = ".Tile")
    private List<WebElement> playlists;

    @Autowired
    public PlaylistPage(WebDriverProvider webDriverProvider) {
        super(webDriverProvider, "/playlist");
    }

    public PlaylistPage clickNthTile(int n) {
        clickNthElement(playlists, n);
        return this;
    }

    @Override
    protected List<WebElement> elementsToWait() {
        List<WebElement> elementToWait = new ArrayList<>();
        elementToWait.add(reorderButton);
        return elementToWait;
    }
}
