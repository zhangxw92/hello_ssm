package com.athome.zk.lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZKHightNatureLock extends ZKAbstractLock {
    private static final String rootNode = "/myLock";
    private static ZkClient zkClient = ZKUtil.getConnection();
    private static final String ceshi = "ceshi";
    private volatile String currentNode;
    private volatile String beforeNode;
    private static CountDownLatch countDownLatch;

    public ZKHightNatureLock() {
        //如果根节点不存在先创建根节点
        if (!zkClient.exists(rootNode)) {
            zkClient.createPersistent(rootNode);
        }
    }

    @Override
    public boolean releaseLock() {
        if (null != zkClient) {
            zkClient.delete(currentNode);
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

        zkClient.subscribeDataChanges(beforeNode, iZkDataListener);

        if (zkClient.exists(beforeNode)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        zkClient.unsubscribeDataChanges(beforeNode, iZkDataListener);
    }

    @Override
    public boolean tryAcquire() {
        //创建带序号的临时节点
        currentNode = zkClient.createEphemeralSequential(ceshi, 1);
        System.out.println(currentNode);


        return false;
    }

    @Test
    public void aa() {
        if (!zkClient.exists(rootNode)) {
            zkClient.createPersistent(rootNode);
        }
        //创建带序号的临时节点
        currentNode = zkClient.createEphemeralSequential(rootNode + "/" + ceshi, 1);
        System.out.println(currentNode);

        List<String> children = zkClient.getChildren(rootNode);
        System.out.println(children.toString());

        Collections.sort(children);

        if (currentNode.equals(children.get(0))) {
            System.out.println("创建的第一个临时顺序节点为：" + currentNode);
        } else {
            int length = rootNode.length();
            System.out.println("length=" + length);

            int i = Collections.binarySearch(children, currentNode.substring(length + 1));
            System.out.println("i=" + i);
            //如果不是第一个节点，获取当前节点的前一个节点

        }
    }
}
