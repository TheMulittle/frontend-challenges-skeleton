package com.mulittle.skeleton.frontend.configuration;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.WebDriverHtmlOutput;
import org.springframework.context.ApplicationContext;

public abstract class AbstractStory extends JUnitStories {

    ApplicationContext applicationContext;

    public AbstractStory() {
        configuredEmbedder().embedderControls()
                            .doGenerateViewAfterStories(true)
                            .doIgnoreFailureInStories(true)
                            .doIgnoreFailureInView(false)
                            .doVerboseFailures(true)
                            .useStoryTimeoutInSecs(60);
    }

    @Override
    public Configuration configuration() {
        //applicationContext = 

        return new MostUsefulConfiguration()
                    .useStoryReporterBuilder(new StoryReporterBuilder()
                            .withDefaultFormats()
                            .withFormats(Format.ANSI_CONSOLE, Format.STATS, WebDriverHtmlOutput.WEB_DRIVER_HTML))
                    .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(), getAnnotatedApplicationContext());
    }

    public abstract ApplicationContext getAnnotatedApplicationContext();
}
