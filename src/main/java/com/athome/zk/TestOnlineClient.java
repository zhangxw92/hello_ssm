package com.athome.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * @Author zhangxw03
 * @Dat 2020-12-21 10:14
 * @Describe 服务器动态上下线client
 */
public class TestOnlineClient {
    private static String connect = "39.102.61.252:2181";
    private static int tickTime = 200000;
    private ZooKeeper zk = null;
    private static String rootNode = "/Server";

    //客户端获取zk链接、获取zk的服务器列表并且监听
    public void getConnection() throws IOException {
        zk = new ZooKeeper(connect, tickTime, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getServerList(1);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getServerList(int i) throws KeeperException, InterruptedException {
        List<String> children = zk.getChildren(rootNode, true);
        for (String child : children) {
            System.out.println(i + "  服务器节点：" + child + "主机ip:" + zk.getData(rootNode + "/" + child, false, null).toString());
        }

    }

    public void business() throws InterruptedException {
        System.out.println("客户端开始工作。。。。");

        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        TestOnlineClient t = new TestOnlineClient();
        t.getConnection();
        t.getServerList(0);
    }
}
