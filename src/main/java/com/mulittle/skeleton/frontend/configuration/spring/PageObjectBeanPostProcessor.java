package com.mulittle.skeleton.frontend.configuration.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class PageObjectBeanPostProcessor implements BeanPostProcessor {

    private List<Object> pageObjects = new LinkedList<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean.getClass().isAnnotationPresent(PageObject.class)) {
            pageObjects.add(bean);
        }

        return bean;
    }

    /*@Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }*/

    public List<Object> getPageObjects() {
        return pageObjects;
    }
}
