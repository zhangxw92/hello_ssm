package com.athome.thread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-14 13:56
 * @Describe
 */
public class TestThread3 {
    BlockingQueue blockingQueue = new ArrayBlockingQueue(1);

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                test01();
            }, "线程01").start();

            new Thread(() -> {
                test02();
            }, "线程02").start();
        }
    }

    private void test01() {
        try {
            blockingQueue.put(1);
            System.out.println(Thread.currentThread().getName() + "  :A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void test02() {
        try {
            System.out.println(Thread.currentThread().getName() + "  :B");
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
