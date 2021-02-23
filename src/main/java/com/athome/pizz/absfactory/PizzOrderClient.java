package com.athome.pizz.absfactory;

import com.athome.pizz.factory.Pizz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 10:53
 * @Describe
 */
public class PizzOrderClient {
    private PizzAbsFactory pizzAbsFactory;

    public void setPizzAbsFactory(PizzAbsFactory pizzAbsFactory) {
        this.pizzAbsFactory = pizzAbsFactory;
    }

    public PizzOrderClient() {
        setPizzAbsFactory(new ChinesePizzAbsFactory());
        do {
            String type = getType();
            Pizz pizz = pizzAbsFactory.createPizz(type);
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

    public static void main(String[] args) {
        new PizzOrderClient();
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
