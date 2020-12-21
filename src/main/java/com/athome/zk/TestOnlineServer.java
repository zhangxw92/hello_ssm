package com.athome.zk;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author zhangxw03
 * @Dat 2020-12-21 10:13
 * @Describe 服务器动态上下线server
 */
public class TestOnlineServer {
    private static String connect = "39.102.61.252:2181";
    private static int tickTime = 200000;
    private ZooKeeper zk = null;
    private static String rootNode = "/Server";
    String hostAddress;

    //获取zk链接
    @Before
    public void getConnection() throws IOException {
        zk = new ZooKeeper(connect, tickTime, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    //注册主机信息
    public void registerHost(String host) throws KeeperException, InterruptedException {
        String node = zk.create
                (rootNode + "/Server6",
                        host.getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.EPHEMERAL);
    }


    public String getHost() throws UnknownHostException {
        String hostName = "";
        InetAddress localHost = InetAddress.getLocalHost();
        if (null != localHost) {
            hostAddress = localHost.getHostAddress();
            hostName = localHost.getHostName();
            System.out.println(hostAddress + "--" + hostName);
        }
        return hostAddress;
    }

    public void business() throws InterruptedException {
        System.out.println("服务端开始工作：ip=" + hostAddress);

        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void test() throws InterruptedException, KeeperException {
        zk.delete(rootNode + "/Server4", 0);
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        TestOnlineServer t = new TestOnlineServer();
        t.getConnection();
        t.registerHost(t.getHost());
        t.business();
        System.out.println("Hello World");
    }
}
