package com.athome.zk.lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class ZKHightNatureLock extends ZKAbstractLock {
    private static String rootNode = "/root_node";
    private static ZkClient zkClient = ZKUtil.getConnection();
    private static final String ceshi = "/ceshi";
    private static ThreadLocal<String> currentNode = new ThreadLocal<>();
    private static ThreadLocal<String> beforeNode = new ThreadLocal<>();

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
            boolean delete = zkClient.delete(currentNode.get());
            if (delete) {
                System.out.println(Thread.currentThread().getName() + "释放锁成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "释放锁失败");
            }
            currentNode.remove();
            return true;
        }
        return false;
    }

    @Override
    public void waitLock() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                countDownLatch.countDown();
            }
        };
        zkClient.subscribeDataChanges(beforeNode.get(), iZkDataListener);

        if (zkClient.exists(beforeNode.get())) {
            try {
                System.out.println(Thread.currentThread().getName() + "进入等待中");
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
        if (currentNode.get() == null) {
            currentNode.set(zkClient.createEphemeralSequential(rootNode + ceshi, UUID.randomUUID().toString()));
        }

        List<String> childrens = zkClient.getChildren(rootNode);
        //对查出来的集合从小到大排序
        Collections.sort(childrens);
        //如果新创建的节点和zk中取出来的第一个节点相等，表示这个节点获取到了锁
        if (currentNode.get().equals(rootNode + "/" + childrens.get(0))) {
            return true;
        } else {
            //获取当前节点的位置;childrens取出来的是不带/ 的集合，因此这里要+1
            int i = childrens.indexOf(currentNode.get().substring(rootNode.length() + 1));
            //获取当前节点生成的序号，用序号-1的方式获取前一个节点
            String s = childrens.get(i - 1);
            beforeNode.set(rootNode + "/" + s);
            //获取锁失败，当前线程准备监听前一个节点
            return false;
        }
    }

}
