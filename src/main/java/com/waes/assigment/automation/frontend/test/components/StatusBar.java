package com.waes.assigment.automation.frontend.test.components;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.waes.assigment.automation.frontend.configuration.PageObject.PageObject;
import com.waes.assigment.automation.frontend.test.AbstractComponent;

@PageObject
public class StatusBar extends AbstractComponent {

    @FindBy(css = "#status p")
    private WebElement statusLabel;

    @FindBy(css = "#status p a")
    private WebElement logoutLink;

    public String getStatusBarText() {
        return statusLabel.getText();
    }

    public boolean isLogoutLinkVisible() {
        return logoutLink.isDisplayed();
    }

    public StatusBar clickOnLogoutLink() {
        click(logoutLink);
        return this;
    }

    @Override
    protected List<WebElement> elementsToWait() {
        return null;
    }

    public boolean logoutIfLoggedIn() {
        try {
            clickOnLogoutLink();
            return true;
        } catch (NoSuchElementException e) {
            //User is already logged out
            return false;
        }
    }
}
