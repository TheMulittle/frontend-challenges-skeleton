package com.waes.assigment.automation.frontend.test.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.waes.assigment.automation.frontend.configuration.PageObject.PageObject;
import com.waes.assigment.automation.frontend.test.AbstractComponent;

@PageObject
public class LoginPage extends AbstractComponent {

    @FindBy(id = "username_input")
    private WebElement userNameField;

    @FindBy(id = "password_input")
    private WebElement passwordField;

    @FindBy(id = "login_button")
    private WebElement loginButton;

    @FindBy(xpath = "//h1[text()='Log In']")
    private WebElement loginTitle;

    public LoginPage typeOnUserNameField(String text) {
        typeData(userNameField, text);
        return this;
    }

    public LoginPage typeOnPasswordField(String text) {
        typeData(passwordField, text);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return this;
    }

    @Override
    protected List<WebElement> elementsToWait() {
        List<WebElement> elementsToWait = new ArrayList<>();
        elementsToWait.add(loginTitle);
        return elementsToWait;
    }
}
