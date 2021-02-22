package com.athome.factory;

public abstract class Pizz {

    protected abstract void prepare();

    protected void bake() {
        System.out.println("披萨烘烤");
    }

    protected void cut() {
        System.out.println("披萨切割");
    }

    protected void box() {
        System.out.println("披萨打包");
    }
}
