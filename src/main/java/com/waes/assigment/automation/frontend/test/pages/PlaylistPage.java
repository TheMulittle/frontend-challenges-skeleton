package com.waes.assigment.automation.frontend.test.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.waes.assigment.automation.frontend.configuration.PageObject.PageObject;
import com.waes.assigment.automation.frontend.test.AbstractComponent;

@PageObject
public class PlaylistPage extends AbstractComponent<PlaylistPage> {

    public static final String PAGE_URL = "/playlist";

    @FindBy(css = ".SpotifyButton")
    private WebElement reorderButton;

    @FindBy(css = ".Tile")
    private List<WebElement> playlists;

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

    @Override
    protected String getPageAddress() {
        return PAGE_URL;
    }
}
