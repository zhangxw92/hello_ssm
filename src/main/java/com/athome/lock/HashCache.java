package com.athome.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-30 12:40
 * @Describe 缓存,需要达到的要求读读共享，写写互斥，读写互斥
 */
public class HashCache {
    private static volatile Map<String, Object> cache = new HashMap<>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String k, Object v) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + "：开始写");
        try {
            cache.put(k, v);
        } finally {
            System.out.println(Thread.currentThread().getName() + "：写成功");
            writeLock.unlock();
        }
    }

    public Object get(String k) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + "：开始读");
        try {
            return cache.get(k);
        } finally {
            System.out.println(Thread.currentThread().getName() + "：读成功");
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        HashCache cache = new HashCache();
        //开启1000个线程写
        for (int i = 0; i < 1000; i++) {
            final int t = i;
            new Thread(() -> {
                cache.put(String.valueOf(t), Integer.valueOf(t));
            }, String.valueOf(i)).start();
        }

        //开启500个线程读
        for (int i = 0; i < 500; i++) {
            final int t = i;
            new Thread(() -> {
                cache.get(String.valueOf(t));
            }, String.valueOf(i)).start();
        }
    }
}
