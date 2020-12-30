package com.athome.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author zhangxw03
 * @Dat 2020-12-30 13:15
 * @Describe
 */
public class TestCyclicbarrier {
    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(10, new Thread(() -> {
            System.out.println("轮到我执行了");
        }));

        for (int i = 1; i < 11; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始执行");
                try {
                    //对传进去的第一个参数做--操作，如果计数器不等于0，那么阻塞线程，当等于0的时候，执行自己定义的线程
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
