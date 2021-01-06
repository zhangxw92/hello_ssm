package com.athome.zk.lock;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zhangxw03
 * @Dat 2021-01-05 13:15
 * @Describe
 */
public class TestZKHightNatureLock {

    private volatile int size = 0;
    private static ZKHightNatureLock zkSimpleLock = new ZKHightNatureLock("/wang");
    private static CountDownLatch c = new CountDownLatch(10);

    public void add() {
        zkSimpleLock.acquireLock();
        try {
            size++;
        } finally {
            zkSimpleLock.releaseLock();
        }
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                add();
                c.countDown();
            }).start();
        }
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(size);
    }
}
