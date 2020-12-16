package com.athome.observer;

public class BaiduObserver implements Observer {

    @Override
    public void update(String var1, String var2, String var3) {
        System.out.println("百度：湿度 =" + var1);
        System.out.println("百度：干度 =" + var2);
        System.out.println("百度：热度 =" + var3);
    }
}
