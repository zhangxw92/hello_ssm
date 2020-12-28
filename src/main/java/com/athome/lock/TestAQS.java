package com.athome.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-25 16:00
 * @Describe
 */
public class TestAQS {

    public static void main(String[] args) {
        new Thread(() -> {
            TestAQS.test();
        }).start();
    }

    public static void test() {
        Lock lock = new ReentrantLock();

        lock.lock();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
    }
}
