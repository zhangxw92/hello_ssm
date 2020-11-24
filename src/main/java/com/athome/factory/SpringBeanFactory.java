package com.athome.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhangxw03
 * @Dat 2020-11-24 17:17
 * @Describe
 */
public class SpringBeanFactory {

    public static <T> T getBean(Class<T> clazz) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        return applicationContext.getBean((Class<T>) clazz);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object dataSource = applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }
}
