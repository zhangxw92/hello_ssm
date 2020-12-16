package com.athome.build;

/**
 * @Author zhangxw03
 * @Dat 2020-12-16 8:48
 * @Describe 造一辆宝马
 */
public class BMWBuilder extends CarAbstractBuilder {

    public BMWBuilder() {
        super();
    }

    @Override
    protected void build01() {
        car.setHead("车胎");
        System.out.println("车胎");
    }

    @Override
    protected void build02() {
        car.setBody("车身");
        System.out.println("车身");
    }

    @Override
    protected void build03() {
        car.setTail("发动机");
        System.out.println("发动机");
    }
}
