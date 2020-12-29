package com.athome.collection;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-29 11:57
 * @Describe
 */
public class TestCopyOnWriteArrayList<E> {

    private final Lock lock = new ReentrantLock();
    private Object[] elemenData;

    public Object[] getArray() {
        return elemenData;
    }

    public void setArray(Object[] objects) {
        elemenData = objects;
    }

    public void add(E e) {
        Lock lock = this.lock;
        lock.lock();
        try {
            Object[] array = getArray();
            int length = array.length;
            Object[] objects = Arrays.copyOf(array, length + 1);
            objects[length] = e;
            setArray(objects);
        } finally {
            lock.unlock();
        }
    }
}
