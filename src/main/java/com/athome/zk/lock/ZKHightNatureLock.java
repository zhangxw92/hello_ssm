package com.athome.zk.lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class ZKHightNatureLock extends ZKAbstractLock {
    private static String rootNode = "/root_node";
    private static ZkClient zkClient = ZKUtil.getConnection();
    private static final String ceshi = "/ceshi";
    private static ThreadLocal<String> currentNode = new ThreadLocal<>();
    private static ThreadLocal<String> beforeNode = new ThreadLocal<>();
    private static CountDownLatch countDownLatch;

    public ZKHightNatureLock() {
        if (!zkClient.exists(ceshi)) {
            zkClient.createPersistent(ceshi);
        }
    }

    public ZKHightNatureLock(String rootNode) {
        this.rootNode = rootNode;
        //如果根节点不存在先创建根节点
        if (!zkClient.exists(rootNode)) {
            zkClient.createPersistent(rootNode);
        }
    }

    @Override
    public boolean releaseLock() {
        if (null != zkClient) {
            System.out.println("--释放锁zk节点：" + currentNode.get());
            boolean delete = zkClient.delete(currentNode.get());
            if (delete) {
                System.out.println("--释放锁zk节点：" + currentNode.get() + "|释放锁成功");
            } else {
                System.out.println("--释放锁zk节点：" + currentNode.get() + "|释放锁失败");
            }
            currentNode.remove();
            return true;
        }
        return false;
    }

    @Override
    public void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };
        zkClient.subscribeDataChanges(beforeNode.get(), iZkDataListener);

        if (zkClient.exists(beforeNode.get())) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        zkClient.unsubscribeDataChanges(beforeNode.get(), iZkDataListener);
    }

    @Override
    public boolean tryAcquire() {
        //创建带序号的临时节点
        String ephemeralSequential = zkClient.createEphemeralSequential(rootNode + ceshi, UUID.randomUUID().toString());
        currentNode.set(ephemeralSequential);
        List<String> childrens = zkClient.getChildren(rootNode);
        //对查出来的集合从小到大排序
        Collections.sort(childrens);
        //如果新创建的节点和zk中取出来的第一个节点相等，表示这个节点获取到了锁
        if (ephemeralSequential.equals(rootNode + "/" + childrens.get(0))) {
            return true;
        } else {
            //获取当前节点的位置;childrens取出来的是不带/ 的集合，因此这里要+1
            String substring = ephemeralSequential.substring(rootNode.length() + 1);
            int i = childrens.indexOf(ephemeralSequential.substring(rootNode.length() + 1));
            //获取当前节点生成的序号，用序号-1的方式获取前一个节点
            String s = childrens.get(i - 1);
            System.out.println("获取锁失败，监听他的前一个节点：" + "/" + s);
            beforeNode.set("/" + s);
            //获取锁失败，当前线程准备监听前一个节点
            return false;
        }
    }

    @Test
    public void aa() {
//        if (!zkClient.exists(rootNode)) {
//            zkClient.createPersistent(rootNode);
//        }
        //创建带序号的临时节点
        String ephemeralSequential = zkClient.createEphemeralSequential(ceshi, "111");
        System.out.println(ephemeralSequential);
        Object o = zkClient.readData(ephemeralSequential);
        System.out.println("--------" + o.toString());
        //  /ceshi0000000064
        ephemeralSequential.substring(ceshi.length());

    }


}
