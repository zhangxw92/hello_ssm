package com.athome.factory;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
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

    @Test
    public void test() {
        DruidDataSource bean = SpringBeanFactory.getBean(DruidDataSource.class);
        System.out.println(bean);
    }
}
