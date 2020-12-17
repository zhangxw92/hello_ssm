package com.athome.dbpool;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author zhangxw03
 * @Dat 2020-12-17 11:11
 * @Describe
 */
public class ConnecResource {

    private static String username;
    private static String password;
    private static String url;
    private static Connection connection;

    //@Test
    public static void load() {
        Properties p = new Properties();
        InputStream resourceAsStream = ConnecResource.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            p.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        username = p.getProperty("jdbc.username");
        password = p.getProperty("jdbc.password");
        url = p.getProperty("jdbc.url");

        System.out.println(username + " -- " + password + " -- " + url);
    }

    public static Connection getConnection() {
        //获取连接的时候先加载数据库连接配置
        load();
        //再获取连接
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        System.out.println(getConnection());
    }

}
