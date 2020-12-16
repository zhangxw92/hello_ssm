package com.athome.observer;

public class TenxunObserver implements Observer {

    @Override
    public void update(String var1, String var2, String var3) {
        System.out.println("腾讯：湿度 " + var1);
        System.out.println("腾讯：干度 " + var2);
        System.out.println("腾讯：热度 " + var3);
    }
}
