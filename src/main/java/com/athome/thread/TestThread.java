package com.athome.thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-14 12:52
 * @Describe 生产者消费者模型01
 */
public class TestThread {

    private volatile int flag = 0;

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                test01();
            }, "线程01").start();

            new Thread(() -> {
                test02();
            }, "线程02").start();

            new Thread(() -> {
                test03();
            }, "线程03").start();
        }
    }


    private void test01() {
        synchronized (this) {
            while (flag == 0) {
                System.out.println(Thread.currentThread().getName() + "  :A");
                flag = 1;
                notifyAll();
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test02() {
        synchronized (this) {
            while (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "  B");
                flag = 2;
                notifyAll();
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test03() {
        synchronized (this) {
            while (flag == 2) {
                System.out.println(Thread.currentThread().getName() + "  ::C");
                flag = 0;
                notifyAll();
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
