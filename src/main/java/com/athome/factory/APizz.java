package com.athome.factory;

public class APizz extends Pizz {
    @Override
    protected void prepare() {
        System.out.println("准备A披萨的原材料");
    }
}
