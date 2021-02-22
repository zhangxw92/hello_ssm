package com.athome.single;

/**
 * @Author zhangxw03
 * @Dat 2021-02-22 16:02
 * @Describe 静态变量的方式，优点：书写简单，避免了对象创建多线程竞争的问题；缺点不是懒加载，可能造成内存浪费的问题
 */
public class StaticSingle {
    private StaticSingle() {
    }

    private final static StaticSingle staicSingle = new StaticSingle();

    public static StaticSingle getInstance() {
        return staicSingle;
    }

    public static void main(String[] args) {
        StaticSingle staticSingle = StaticSingle.getInstance();
        StaticSingle staticSingle2 = StaticSingle.getInstance();
        System.out.println(staticSingle == staticSingle2);
    }
}
