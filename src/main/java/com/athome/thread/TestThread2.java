package com.athome.thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-14 13:33
 * @Describe 生产者消费者模型02
 */
public class TestThread2 {
    private volatile int flag = 0;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

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
        lock.lock();
        try {
            while (flag == 0) {
                System.out.println(Thread.currentThread().getName() + "  :A");
                flag = 1;
                condition2.signal();
            }
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void test02() {
        lock.lock();
        try {
            while (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "  :B");
                flag = 2;
                condition3.signal();
            }
            condition2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void test03() {
        lock.lock();
        try {
            while (flag == 2) {
                System.out.println(Thread.currentThread().getName() + "  :C");
                flag = 0;
                condition1.signal();
            }
            condition3.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
