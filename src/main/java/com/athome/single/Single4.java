package com.athome.single;

/**
 * @Author zhangxw03
 * @Dat 2021-01-04 15:51
 * @Describe
 */
public class Single4 {
    private static volatile Single4 instance;

    private Single4() {
    }

    public synchronized static Single4 getInstance() {

        return Single5.single4;
    }

    private static class Single5 {
        private static final Single4 single4 = new Single4();
    }
}
