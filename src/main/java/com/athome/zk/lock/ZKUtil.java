package com.athome.zk.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.I0Itec.zkclient.serialize.ZkSerializer;
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
        //设置序列化
        zkClient.setZkSerializer(new MyZKSerializer());
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

    public static void main(String[] args) {
//        String a = "/ceshi0000000016";
//        String ceshi = "/ceshi";
//        System.out.println(ceshi.length());
//        //0000000064
//        //截取字符串包括前一位
//        //System.out.println(a.substring("/ceshi".length()-1));
//        //包括前一位，不包括后一位
//        System.out.println(a.substring(ceshi.length()));
//
//        Integer integer = Integer.valueOf("0000000016");
//        System.out.println(integer);
    }
}
