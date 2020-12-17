package com.athome.dbpool;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zhangxw03
 * @Dat 2020-12-17 11:47
 * @Describe
 */
public class DataBaseConnecPoolImpl implements DataBaseConnectPool {

    //最大连接数
    private int maxsize;
    //最大允许空闲连接数
    private int idelsize;
    //等待时间
    private long waittime;
    //超时时间单位
    private TimeUnit timeUnit;
    //存放占用连接对象的队列
    private ArrayBlockingQueue<Connection> busy;
    //存放空闲连接对象队列
    private ArrayBlockingQueue<Connection> free;
    //busy队列元素个数
    private AtomicInteger atomicInteger = new AtomicInteger();
    //free队列元素个数
    private AtomicInteger atomicIntegerFree = new AtomicInteger();

    @Override
    public void init(int maxsize, int idelsize, long waittime, TimeUnit timeUnit) {
        maxsize = 5;
        idelsize = 2;
        waittime = 1;
        timeUnit = TimeUnit.SECONDS;

        busy = new ArrayBlockingQueue<Connection>(maxsize);
        free = new ArrayBlockingQueue<Connection>(idelsize);
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        //首先，如果空闲队列中有则返回
        if (atomicIntegerFree.get() > 0) {
            connection = free.poll();
            if (connection != null) {
                atomicIntegerFree.getAndDecrement();
                return connection;
            }
        }
        //其次，如果空闲队列中没有则新创建对象
        //需要判断当前的busy队列元素个数是否小于最大连接数，如果小于则创建，否则等待
        if (atomicInteger.getAndIncrement() <= maxsize) {
            connection = ConnecResource.getConnection();
            busy.offer(connection);
            return connection;
        }

        //最后，如果busy队列的元素个数已经等于最大连接数，则无法再创建连接，只能等待busy队列释放资源
        try {
            connection = free.poll(waittime, TimeUnit.SECONDS);
            if (connection != null) {
                atomicIntegerFree.getAndDecrement();
                busy.offer(connection);
                atomicInteger.getAndIncrement();
            } else {
                throw new RuntimeException("等待超时...");
            }
            return connection;
        } catch (InterruptedException e) {
            throw new RuntimeException("等待超时...");
        }
    }

    @Override
    public void close(Connection connection) {

        //从工作队列中删除这个连接
        boolean remove = busy.remove(connection);
        //如果删除失败
        if (!remove) {
            ConnecResource.close(connection);
            atomicInteger.getAndDecrement();
            return;
        }

        //删除成功的情况，再判断如果空闲队列小于最大空闲数
        if (atomicIntegerFree.getAndIncrement() < idelsize) {
            boolean offer = free.offer(connection);
            if (!offer) {
                ConnecResource.close(connection);
                atomicIntegerFree.getAndDecrement();
                return;
            }
            atomicInteger.getAndDecrement();
            return;
        } else {
            ConnecResource.close(connection);
            atomicInteger.getAndDecrement();
            return;
        }
    }
}
