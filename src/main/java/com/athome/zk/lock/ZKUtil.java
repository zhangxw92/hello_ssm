package com.athome.zk.lock;

import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void test() {
        ZkClient connection = ZKUtil.getConnection();

        List<String> children = connection.getChildren("/lock");
        for (String child : children) {
            System.out.println(child);
        }

    }

}
