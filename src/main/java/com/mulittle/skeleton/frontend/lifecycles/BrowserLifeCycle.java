package com.mulittle.skeleton.frontend.lifecycles;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mulittle.skeleton.frontend.configuration.PageObject.PageObjectBeanPostProcessor;

@Component
public class BrowserLifeCycle {

    @Autowired
    PageObjectBeanPostProcessor pageObjectBeanPostProcessor;

    @Autowired
    WebDriverProvider webDriverProvider;

    @BeforeStory
    public void startBrowser() {
        webDriverProvider.initialize();
        webDriverProvider.get().manage().window().maximize();

        for (Object page : pageObjectBeanPostProcessor.getPageObjects()) {
            PageFactory.initElements(webDriverProvider.get(), page);
        }
    }

    @AfterStory
    public void closeBrowser() {
        webDriverProvider.get().quit();
    }
}
