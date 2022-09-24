package com.waes.assigment.automation.frontend.test.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.waes.assigment.automation.frontend.configuration.PageObject.PageObject;
import com.waes.assigment.automation.frontend.test.AbstractComponent;

@PageObject
public class ProfilePage extends AbstractComponent {

    @FindBy(xpath = "//h1[text() = 'Your Profile']")
    private WebElement profileTitle;

    @FindBy(css = "section > p:nth-of-type(1)")
    private WebElement profileMessage;

    @FindBy(css = "section > p:nth-of-type(2)")
    private WebElement superPower;

    public String getProfileMessage() {
        return profileMessage.getText().replace("\n", "");
    }

    public String getSuperPower() {
        return superPower.getText().replace("\n", "");
    }

    @Override
    protected List<WebElement> elementsToWait() {
        List<WebElement> elementsToWait = new ArrayList<>();
        elementsToWait.add(profileTitle);
        return elementsToWait;
    }
}
