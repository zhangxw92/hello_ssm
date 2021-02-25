package com.athome.brige.impl;

/**
 * @Author zhangxw03
 * @Dat 2021-02-25 11:11
 * @Describe
 */
public abstract class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public abstract void open();
}
