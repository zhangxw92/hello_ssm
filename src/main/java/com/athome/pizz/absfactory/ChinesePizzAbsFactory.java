package com.athome.pizz.absfactory;

import com.athome.pizz.factory.ChineseAPizz;
import com.athome.pizz.factory.ChineseBPizz;
import com.athome.pizz.factory.Pizz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 10:48
 * @Describe
 */
public class ChinesePizzAbsFactory implements PizzAbsFactory {
    @Override
    public Pizz createPizz(String orderType) {
        Pizz pizz = null;
        if ("a".equals(orderType)) {
            pizz = new ChineseAPizz();
        } else if ("b".equals(orderType)) {
            pizz = new ChineseBPizz();
        }
        return pizz;
    }
}
