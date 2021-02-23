package com.athome.pizz.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 9:48
 * @Describe 工厂方法模式创建披萨
 */
public abstract class PizzFactory {

    protected abstract Pizz createPizz(String orderType);

    public PizzFactory() {
        Pizz pizz = null;
        String orderType = "";
        do {
            orderType = getType();
            pizz = createPizz(orderType);
            if (pizz != null) {
                pizz.prepare();
                pizz.bake();
                pizz.cut();
                pizz.box();
            } else {
                System.out.println("披萨订购失败");
                break;
            }
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
