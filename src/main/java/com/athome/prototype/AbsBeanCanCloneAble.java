package com.athome.prototype;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 13:28
 * @Describe
 */
public abstract class AbsBeanCanCloneAble<T> implements Cloneable {

    public T clone() {
        T t = null;
        try {
            t = (T) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return t;
    }
}
