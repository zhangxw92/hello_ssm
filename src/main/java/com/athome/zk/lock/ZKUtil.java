package com.athome.zk.lock;

import org.I0Itec.zkclient.ZkClient;

/**
 * @Author zhangxw03
 * @Dat 2021-01-05 11:23
 * @Describe
 */
public class ZKUtil {
    private static String connect = "39.102.61.252:2181";

    public static ZkClient getConnection() {
        ZkClient zkClient = new ZkClient(connect);
        return zkClient;
    }
}
