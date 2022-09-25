package com.waes.assigment.automation.frontend.test;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public abstract class AbstractComponent<T extends AbstractComponent> {

    @Value("${DEFAULT_TIMEOUT_IN_SECONDS:10}")
    int DEFAULT_TIMEOUT_IN_SECONDS;

    @Autowired
    WebDriverProvider webDriverProvider;
    
    private static final String BASE_URL = "http://localhost:3000";

    public String getCurrentUrl() {
        return webDriverProvider.get().getCurrentUrl();
    }

    public void navigateToUrl(String url) {
        webDriverProvider.get().get(url);
    }

    public T goToPage() {
        navigateToUrl(BASE_URL + getPageAddress());
        return (T) this;
    }

    public Boolean isCurrentPage() {
        return getCurrentUrl().equals(BASE_URL + getPageAddress());
    }

    protected WebElement click(WebElement element) {
        scrollToElement(element).click();
        return element;
    }

    protected WebElement clickNthElement(List<WebElement> elements, int n) {
        return click(elements.get(n - 1));
    }

    protected WebElement typeData(WebElement element, String informationToType) {
        scrollToElement(element);
        element.clear();
        element.sendKeys(informationToType);
        return element;
    }

    protected WebElement scrollToElement(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) (webDriverProvider.get());
            js.executeScript("arguments[0].scrollIntoView(true)", element);
            return element;
    }


    protected WebElement selectInDropdown(WebElement dropdown, String option) {
        new Select(dropdown).selectByVisibleText(option);
        return dropdown;
    }

    public  void closeBrowser() {
        webDriverProvider.get().close();
    }

    public void reopenBroswer(Set<Cookie> allCookies) {
        for(Cookie cookie : allCookies)
        {
            webDriverProvider.get().manage().addCookie(cookie);
        }
        webDriverProvider.initialize();
        webDriverProvider.get().manage().window().maximize();
    }

    public Set<Cookie> getCookies() {
        return webDriverProvider.get().manage().getCookies();
    }

    public AbstractComponent waitUntilPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsToWait()));
        return this;
    }

    protected abstract List<WebElement> elementsToWait();

    protected abstract String getPageAddress();
}
