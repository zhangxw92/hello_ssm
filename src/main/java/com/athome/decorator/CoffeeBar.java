package com.athome.decorator;

public class CoffeeBar {

    //现在是要购买一杯A咖啡+牛奶+巧克力
    public static void main(String[] args) {

        //装饰者模式就是先创建被装饰的对象，然后用装饰器装饰装饰对象

        //1、创建被装饰对象一杯A咖啡
        Drink order = new CoffeeA();
        System.out.println("一杯A咖啡,价格： " + order.cost());
        System.out.println("一杯A咖啡,描述： " + order.getDescripe());

        //2、创建牛奶
        order = new Milk(order);
        System.out.println("一杯A咖啡+牛奶,价格： " + order.cost());
        System.out.println("一杯A咖啡+牛奶,描述： " + order.getDescripe());

        //3、创建巧克力
        order = new Chocolate(order);
        System.out.println("一杯A咖啡+牛奶+巧克力,价格： " + order.cost());
        System.out.println("一杯A咖啡+牛奶+巧克力,描述： " + order.getDescripe());
    }
}
