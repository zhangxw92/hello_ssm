package com.athome.single;

/**
 * @Author zhangxw03
 * @Dat 2021-01-04 15:51
 * @Describe
 */
public class Single3 {
    private static Single3 instance;

    private Single3() {
    }

    public static Single3 getInstance() {
        if (null == instance) {
            instance = new Single3();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Single3 instance = Single3.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
