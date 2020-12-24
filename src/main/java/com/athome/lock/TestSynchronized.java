package com.athome.lock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-23 11:20
 * @Describe
 */
public class TestSynchronized {

    public int a = 0;

    public static void main(String[] args) {
        TestSynchronized t = new TestSynchronized();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                t.hell();
            }, "A").start();

            new Thread(() -> {
                t.hell();
            }, "B").start();

            new Thread(() -> {
                t.hell();
            }, "C").start();

            new Thread(() -> {
                t.hell();
            }, "D").start();
        }
    }

    public void hell() {
        synchronized (this) {
            a += 1;
            System.out.println(Thread.currentThread().getName() + "--" + a);
        }
    }
}
