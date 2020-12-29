package com.athome.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @Author zhangxw03
 * @Dat 2020-12-29 11:18
 * @Describe
 */
public class TestList {
    //static List<Integer> list = new ArrayList();
    static CopyOnWriteArrayList list = new CopyOnWriteArrayList();
    static CountDownLatch c = new CountDownLatch(1000);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                TestList.test();
                c.countDown();
            }).start();
        }
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    public static void test() {
        list.add(1);
    }
}
