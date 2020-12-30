package com.athome.basic;

/**
 * @Author zhangxw03
 * @Dat 2020-12-30 14:27
 * @Describe 测试传值、传引用的区别
 */
public class TestJava {
    public static void main(String[] args) {
//        User a = new User();
//        a.setAge(10);
        String a = "world";
        System.out.println(a);
        change(a);
        System.out.println(a);

    }

    //传值
    public static void change(int a) {
        a = a + 2;
    }

    //传引用
    public static void change(User user) {
        user.setAge(20);
    }

    //用final修饰的特殊类
    public static void change(String str) {
        str = str + "hell";
    }
}
