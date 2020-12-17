package com.athome.dbpool;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhangxw03
 * @Dat 2020-12-17 11:42
 * @Describe 简易数据库连接池
 */
public interface DataBaseConnectPool {

    public void init(int maxsize, int idelsize, long waittime, TimeUnit timeUnit);

    public Connection getConnection();

    public void close(Connection connection);

}
