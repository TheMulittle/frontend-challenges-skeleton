package com.waes.assigment.automation.frontend.test.pages;


import com.waes.assigment.automation.frontend.configuration.PageObject.PageObject;
import com.waes.assigment.automation.frontend.test.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

@PageObject
public class SignUpPage extends AbstractComponent {

    @FindBy(id = "username_input")
    private WebElement userNameField;

    @FindBy(id = "password_input")
    private WebElement passwordField;

    @FindBy(id =  "name_input")
    private WebElement nameField;

    @FindBy(id = "email_input")
    private WebElement emailField;

    @FindBy(id = "day_select")
    private WebElement dayDropdown;

    @FindBy(id =  "month_select")
    private WebElement monthDropdown;

    @FindBy(id = "year_select")
    private WebElement yearDropdown;

    @FindBy(id = "submit_button")
    private WebElement submitButton;

    public SignUpPage typeOnUserNameField(String text) {
        typeData(userNameField, text);
        return this;
    }

    public SignUpPage typeOnPasswordField(String text) {
        typeData(passwordField, text);
        return this;
    }

    public SignUpPage typeOnNameField(String text) {
        typeData(nameField, text);
        return this;
    }

    public SignUpPage typeOnEmailField(String text) {
        typeData(emailField, text);
        return this;
    }

    public SignUpPage selectDayOfBirth(String option) {
        if(!option.isEmpty())
            selectInDropdown(dayDropdown, option);
        return this;
    }

    public SignUpPage selectMonthOfBirth(String option) {
        if(!option.isEmpty())
            selectInDropdown(monthDropdown, option);
        return this;
    }

    public SignUpPage selectYearOfBirth(String option) {
        if(!option.isEmpty())
            selectInDropdown(yearDropdown, option);
        return this;
    }

    public SignUpPage clickOnSubmitButton() {
        click(submitButton);
        return this;
    }

    @Override
    protected List<WebElement> elementsToWait() {
        List<WebElement> elementsToWait = new ArrayList<>();
        elementsToWait.add(emailField);
        elementsToWait.add(dayDropdown);
        return elementsToWait;
    }
}
