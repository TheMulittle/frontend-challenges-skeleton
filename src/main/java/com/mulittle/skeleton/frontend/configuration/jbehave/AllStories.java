package com.mulittle.skeleton.frontend.configuration.jbehave;

import org.jbehave.core.io.StoryFinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mulittle.skeleton.frontend.configuration.spring.ProjectConfiguration;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;


public class AllStories extends AbstractStory {

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
