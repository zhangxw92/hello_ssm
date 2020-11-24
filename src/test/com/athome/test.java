package com.athome;

import com.athome.dao.BlogDao;
import com.athome.factory.SessionFactory;
import com.athome.factory.SpringBeanFactory;
import com.athome.service.BlogService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author zhangxw03
 * @Dat 2020-11-24 13:53
 * @Describe
 */

public class test {

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
