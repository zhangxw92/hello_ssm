package com.athome.pizz.factory;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 9:48
 * @Describe 工厂方法模式创建披萨
 */
public class PizzChineseFactory extends PizzFactory {

    @Override
    protected Pizz createPizz(String orderType) {
        Pizz pizz = null;
        if ("a".equals(orderType)) {
            pizz = new ChineseAPizz();
        } else if ("b".equals(orderType)) {
            pizz = new ChineseBPizz();
        }
        return pizz;
    }

    public static void main(String[] args) {
        new PizzChineseFactory();
    }
}
