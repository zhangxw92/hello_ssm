package com.athome.single;

/**
 * @Author zhangxw03
 * @Dat 2021-02-22 16:02
 * @Describe 静态变量块
 */
public class StaticSingle2 {
    private StaticSingle2() {
    }

    private static StaticSingle2 staicSingle2;

    static {
        staicSingle2 = new StaticSingle2();
    }

    public static StaticSingle2 getInstance() {
        return staicSingle2;
    }

    public static void main(String[] args) {
        StaticSingle2 staticSingle = StaticSingle2.getInstance();
        StaticSingle2 staticSingle2 = StaticSingle2.getInstance();
        System.out.println(staticSingle == staticSingle2);
        System.out.println(staticSingle.hashCode());
        System.out.println(staticSingle.hashCode() == staticSingle2.hashCode());
        //Runtime
    }
}
