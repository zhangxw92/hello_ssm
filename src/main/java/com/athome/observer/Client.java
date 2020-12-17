package com.athome.observer;

public class Client {

    public static void main(String[] args) {

        WeatherData subject = new WeatherData();
        subject.registerObserver(new BaiduObserver());
        subject.registerObserver(new TenxunObserver());

        subject.setData("22", "33", "55");

        subject.notifyObservers();
    }
}
