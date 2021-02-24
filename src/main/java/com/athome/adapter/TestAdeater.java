package com.athome.adapter;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 17:18
 * @Describe
 */
public class TestAdeater {

    public static void main(String[] args) {

        AbsHttpService absHttpService = new AbsHttpService() {
            @Override
            public boolean send() {
                System.out.println("测试接口适配器...");
                return super.send();
            }
        };

        absHttpService.send();
    }
}
