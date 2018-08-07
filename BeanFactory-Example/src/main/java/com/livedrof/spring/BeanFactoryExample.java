package com.livedrof.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryExample {
    public static void main(String args[]) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(""));

    }
}
