package com.athome.build;

/**
 * @Author zhangxw03
 * @Dat 2020-12-16 8:52
 * @Describe
 */
public class Client {

    public static void main(String[] args) {
        CarAbstractBuilder carAbstractBuilder = new BMWBuilder();

        CommonDirector commonDirector = new CommonDirector(carAbstractBuilder);

        Car build = commonDirector.build();
        System.out.println(build.getHead());
        System.out.println(build.getBody());
        System.out.println(build.getTail());
    }
}
