package com.athome.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class TestHashMap {
    static Map<String, String> map = new HashMap<>();
    static CountDownLatch c = new CountDownLatch(1000);

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            final int a = i;
            new Thread(() -> {
                TestHashMap.test(String.valueOf(a));
                c.countDown();
            }).start();
        }

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(map.size());
    }

    public static void test(String k) {
        map.put(k, "");
    }
}
