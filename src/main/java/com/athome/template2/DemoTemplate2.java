package com.athome.template2;

public class DemoTemplate2 extends DemoTemplate {
    @Override
    protected void add() {
        System.out.println("添加一些原材料么...");
    }

    @Override
    protected boolean panduan() {
        return false;
    }
}
