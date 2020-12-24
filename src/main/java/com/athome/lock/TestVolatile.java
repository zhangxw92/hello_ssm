package com.athome.lock;

/**
 * @Author zhangxw03
 * @Dat 2020-12-24 13:32
 * @Describe
 */
public class TestVolatile {

    private static volatile TestVolatile instance = null;

    private TestVolatile() {

    }

    public static TestVolatile getInstance() {

        if (instance == null) {
            synchronized (TestVolatile.class) {
                if (instance == null) {
                    instance = new TestVolatile();
                }
            }
        }
        return instance;
    }

}
