package com.athome.zk;

import com.sun.corba.se.impl.encoding.IDLJavaSerializationInputStream;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestZkClient {

    /*
    OPEN_ACL_UNSAFE  : 完全开放的ACL，任何连接的客户端都可以操作该属性znode
    CREATOR_ALL_ACL : 只有创建者才有ACL权限
    READ_ACL_UNSAFE：只能读取ACL
     */
    private static String connect = "39.102.61.252:2181";
    private static int tickTime = 200000;
    private ZooKeeper zk = null;

    @Before
    public void init() throws IOException {
        zk = new ZooKeeper(connect, tickTime, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getType() + "---------" + event.getPath());

//                try {
//                    List<String> children = zk.getChildren("/", true);
//                    for (String child : children) {
//                        System.out.println(child);
//                    }

//                } catch (KeeperException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }

    @Test
    public void test4() throws KeeperException, InterruptedException {
        Stat exists = zk.exists("/sanguo", false);
        System.out.println(exists);
        System.out.println(exists != null ? "存在" : "不存在");
    }

    @Test
    public void test3() throws KeeperException, InterruptedException {
        List<String> children = zk.getChildren("/sanguo", true);

        for (String child : children) {
            System.out.println(child);
        }
    }

    @Test
    public void test2() throws KeeperException, InterruptedException {
        String result = zk.create("/school/xueyuan", "计算机应用".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println(result);
    }

    @Test
    public void test() throws KeeperException, InterruptedException {
        String result = zk.create("/school", "清华大学".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println(result);
    }

}
