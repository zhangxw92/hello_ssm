package com.athome.pizz.absfactory;

import com.athome.pizz.factory.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 10:48
 * @Describe
 */
public class JanpanPizzAbsFactory implements PizzAbsFactory {
    @Override
    public Pizz createPizz(String orderType) {
        Pizz pizz = null;
        if ("a".equals(orderType)) {
            pizz = new JanpanAPizz();
        } else if ("b".equals(orderType)) {
            pizz = new JanpanBPizz();
        }
        return pizz;
    }
}
