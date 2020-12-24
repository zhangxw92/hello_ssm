package com.athome.lock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-24 13:35
 * @Describe
 */
public class Test1 {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                TestVolatile instance = TestVolatile.getInstance();
            }).start();
        }
    }
}
