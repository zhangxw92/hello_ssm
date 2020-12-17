package com.athome.observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherData implements Subject {

    private String var1;
    private String var2;
    private String var3;

    private Set<Observer> observers;

    public WeatherData() {
        observers = new HashSet<>();
    }

    public void setData(String var1, String var2, String var3) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }


    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        //通知客户端修改数据
        for (Observer observer : observers) {
            observer.update(var1, var2, var3);
        }

    }
}











