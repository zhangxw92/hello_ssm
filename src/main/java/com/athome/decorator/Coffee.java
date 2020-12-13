package com.athome.decorator;

/***
 * 各种饮料抽象出一个中间层
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
