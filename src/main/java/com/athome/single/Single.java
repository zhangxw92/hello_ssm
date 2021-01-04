package com.athome.single;

/**
 * @Author zhangxw03
 * @Dat 2021-01-04 15:51
 * @Describe
 */
public class Single {
    private static volatile Single instance;

    private Single() {
    }

    public static Single getInstance() {
        if (null == instance) {
            synchronized (Single.class) {
                if (null == instance) {
                    instance = new Single();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Single instance = Single.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
