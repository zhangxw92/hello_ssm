package com.athome.build;

/**
 * @Author zhangxw03
 * @Dat 2020-12-16 8:40
 * @Describe 抽象构造接口
 */
public abstract class CarAbstractBuilder {

    //车胎
    protected abstract void build01();

    //车体
    protected abstract void build02();

    //发动机
    protected abstract void build03();

    public Car build() {
        build01();
        build02();
        build03();
        return new Car();
    }
}
