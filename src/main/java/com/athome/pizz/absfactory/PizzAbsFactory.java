package com.athome.pizz.absfactory;

import com.athome.pizz.factory.Pizz;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 10:48
 * @Describe
 */
public interface PizzAbsFactory {
    public Pizz createPizz(String orderType);
}
