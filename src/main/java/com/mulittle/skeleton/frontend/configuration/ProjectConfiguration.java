package com.mulittle.skeleton.frontend.configuration;

import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
@ComponentScan({"com.mulittle.skeleton.frontend"})
public class ProjectConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public WebDriverProvider webDriverProvider() {
        WebDriverManager.chromedriver().cachePath(System.getProperty("user.dir")).avoidOutputTree().setup();
        WebDriverProvider webDriverProvider = new PropertyWebDriverProvider();
        System.setProperty("browser", "chrome");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        return webDriverProvider;
    }

    @Bean
    public WebDriverScreenshotOnFailure screenshotOnFailure() {
        return new WebDriverScreenshotOnFailure(webDriverProvider());
    }
}
