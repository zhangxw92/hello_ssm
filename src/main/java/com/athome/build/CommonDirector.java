package com.athome.build;

/**
 * @Author zhangxw03
 * @Dat 2020-12-16 8:50
 * @Describe 指挥者
 */
public class CommonDirector {

    private CarAbstractBuilder carAbstractBuilder;

    public CommonDirector(CarAbstractBuilder carAbstractBuilder) {
        this.carAbstractBuilder = carAbstractBuilder;
    }

    public Car build() {
        carAbstractBuilder.build01();
        carAbstractBuilder.build02();
        carAbstractBuilder.build03();
        return carAbstractBuilder.build();
    }
}
