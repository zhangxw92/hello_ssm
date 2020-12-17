package com.athome.observer;

public interface Subject {

    //注册客户端
    public void registerObserver(Observer observer);

    //删除客户端
    public void removeObserver(Observer observer);

    //通知客户端
    public void notifyObservers();

}
