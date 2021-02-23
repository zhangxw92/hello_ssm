package com.athome.pizz.factory;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 9:50
 * @Describe
 */
public abstract class Pizz {
    public abstract void prepare();

    public void bake() {
        System.out.println("烘烤...");
    }

    public void cut() {
        System.out.println("切割...");
    }

    public void box() {
        System.out.println("打包...");
    }
}
