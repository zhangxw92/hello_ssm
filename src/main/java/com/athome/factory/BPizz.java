package com.athome.factory;

public class BPizz extends Pizz {
    @Override
    protected void prepare() {
        System.out.println("准备B披萨的原材料");
    }
}
