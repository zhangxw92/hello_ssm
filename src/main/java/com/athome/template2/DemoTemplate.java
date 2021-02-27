package com.athome.template2;

public abstract class DemoTemplate {

    public void make() {
        select();
        if (panduan()) {
            add();
        }
        boil();
        eat();
    }


    protected void select() {
        System.out.println("挑拣材料...");
    }

    protected abstract void add();

    protected void boil() {
        System.out.println("煮熟了再吃...");
    }

    protected void eat() {
        System.out.println("开始吃...");
    }

    protected boolean panduan() {
        return true;
    }
}
