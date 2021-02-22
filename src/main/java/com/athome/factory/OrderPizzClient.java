package com.athome.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 思想就是将披萨的制作全部放在自己类中，通过这个客户端进行调用
 */
public class OrderPizzClient {

    public OrderPizzClient() throws Exception {
        String orderType;
        Pizz pizz;
        do {
            orderType = getOrderType();
            if ("a".equals(orderType)) {
                pizz = new APizz();
            } else if ("b".equals(orderType)) {
                pizz = new BPizz();
            } else {
                break;
            }
            pizz.prepare();
            pizz.bake();
            pizz.cut();
            pizz.box();
        } while (true);
    }

    public String getOrderType() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入披萨种类：");
        String s = bufferedReader.readLine();
        return s;
    }

    public static void main(String[] args) throws Exception {
        OrderPizzClient orderPizzClient = new OrderPizzClient();
    }

}
