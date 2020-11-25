package com.athome;

import com.athome.dao.BlogDao;
import com.athome.factory.SessionFactory;
import com.athome.factory.SpringBeanFactory;
import com.athome.service.BlogService;
import com.athome.service.impl.BlogServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author zhangxw03
 * @Dat 2020-11-24 13:53
 * @Describe
 */

public class test {

    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BlogDao blogDao = ct.getBean("blogDao", BlogDao.class);
//        System.out.println(blogDao);
        BlogServiceImpl blogServiceImpl = ct.getBean("blogServiceImpl", BlogServiceImpl.class);
        System.out.println(blogServiceImpl);
//        DruidDataSource dataSource = ct.getBean("dataSource", DruidDataSource.class);
//        System.out.println(dataSource);
    }

    @Test
    public void test() throws IOException {
        SqlSession sqlSession = SessionFactory.getSqlSession();
        BlogDao mapper = sqlSession.getMapper(BlogDao.class);
    }


    @Test
    public void test2() throws IOException {
        BlogService blogService = SpringBeanFactory.getBean(BlogService.class);
        blogService.getBlog(1);
    }
}
