package com.waes.assigment.automation.frontend.configuration;

import org.jbehave.core.io.StoryFinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;


public class CommonStory extends AbstractStory {

    @Override
    public ApplicationContext getAnnotatedApplicationContext() {
        return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
    }

    @Override
    public List<String> storyPaths() {
        List<String> paths = new StoryFinder().findPaths(
                codeLocationFromClass(this.getClass()), "**/stories/**/*.story", "");
        return paths;
    }
}
