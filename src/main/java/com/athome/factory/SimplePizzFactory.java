package com.athome.factory;

/**
 * 简单工厂模式是将对象的创建交给工厂来生产，使用端只需要告诉我要生产什么样的披萨
 */
public class SimplePizzFactory {

    public Pizz createPizz(String orderType) {
        Pizz pizz = null;
        if ("a".equals(orderType)) {
            pizz = new APizz();
        } else if ("b".equals(orderType)) {
            pizz = new BPizz();
        }
        return pizz;
    }

    public static Pizz createPizz2(String orderType) {
        Pizz pizz = null;
        if ("a".equals(orderType)) {
            pizz = new APizz();
        } else if ("b".equals(orderType)) {
            pizz = new BPizz();
        }
        return pizz;
    }
}
