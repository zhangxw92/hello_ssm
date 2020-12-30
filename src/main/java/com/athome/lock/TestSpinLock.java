package com.athome.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author zhangxw03
 * @Dat 2020-12-30 11:37
 * @Describe 自旋锁demo
 */
public class TestSpinLock {
    private static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(thread.getName() + ",获取失败，自旋等待中");
        }
        System.out.println(thread.getName() + ",获取自旋锁成功");
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "，释放锁成功");
    }

    public static void main(String[] args) {
        TestSpinLock lock = new TestSpinLock();
        new Thread(() -> {
         lock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unLock();
        },"A").start();

        //等待线程A先执行
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unLock();
        },"B").start();
    }
}
