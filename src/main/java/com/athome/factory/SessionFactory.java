package com.athome.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author zhangxw03
 * @Dat 2020-11-24 13:49
 * @Describe
 */
public class SessionFactory {

    public static SqlSession getSqlSession() throws IOException {
        String url = "applicationContext.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(url);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return sessionFactory.openSession();
    }
}
