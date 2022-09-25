package com.waes.assigment.automation.frontend.test.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import com.waes.assigment.automation.frontend.configuration.PageObject.PageObject;
import com.waes.assigment.automation.frontend.test.AbstractComponent;

@PageObject
public class LoginPage extends AbstractComponent<LoginPage> {

    @FindBy(id = "login-username")
    private WebElement userInput;

    @FindBy(id = "login-password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Autowired
    HomePage homePage;

    @Autowired
    PlaylistPage playlistPage;

    public LoginPage login(String user, String password) {
        return this.typeUser(user)
            .typePassword(password)
            .clickLoginButton();
    }
    
    public LoginPage typeUser(String email) {
        typeData(userInput, email);
        return this;
    }

    public LoginPage typePassword(String password) {
        typeData(passwordInput, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(loginButton);
        return this;
    }

    public HomePage homePage() {
        return homePage;
    }

    public PlaylistPage playlistPage() {
        return playlistPage;
    }

    @Override
    protected List<WebElement> elementsToWait() {
        List<WebElement> elementToWait = new ArrayList<>();
        elementToWait.add(loginButton);
        return elementToWait;
    }

    @Override
    protected String getPageAddress() {
        return "";
    }
}
