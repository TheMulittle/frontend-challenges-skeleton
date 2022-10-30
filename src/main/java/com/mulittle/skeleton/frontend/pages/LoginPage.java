package com.mulittle.skeleton.frontend.pages;


import java.util.ArrayList;
import java.util.List;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mulittle.skeleton.frontend.AbstractComponent;
import com.mulittle.skeleton.frontend.configuration.spring.PageObject;

@PageObject
public class LoginPage extends AbstractComponent<LoginPage> {

    @FindBy(id = "login-username")
    private WebElement userInput;

    @FindBy(id = "login-password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    private final HomePage homePage;

    private final PlaylistPage playlistPage;

    public LoginPage(WebDriverProvider webDriverProvider, HomePage homePage, PlaylistPage playlistPage) {
        super(webDriverProvider, "");
        this.homePage = homePage;
        this.playlistPage = playlistPage;
    }

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
}
