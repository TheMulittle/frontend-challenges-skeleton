package com.waes.assigment.automation.frontend.test.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import com.waes.assigment.automation.frontend.configuration.PageObject.PageObject;
import com.waes.assigment.automation.frontend.test.AbstractComponent;

@PageObject
public class CommonPage extends AbstractComponent {

    Set<Cookie> allCookies;

    public void keepSession() {
       allCookies = getCookies();
    }

    public void reopenBroswer() {
        reopenBroswer(allCookies);
    }

    @Override
    protected List<WebElement> elementsToWait() {
        List<WebElement> elementsToWait = new ArrayList<>();
        return elementsToWait;
    }
}
