package com.athome.zk.lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.apache.zookeeper.Watcher;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zhangxw03
 * @Dat 2021-01-05 12:45
 * @Describe
 */
public class ZKSimpleLock extends ZKAbstractLock {
    private static final String myLock = "/myLock";
    private static CountDownLatch countDownLatch;

    @Override
    public boolean tryAcquire() {
        if (null == zkClient) {
            return false;
        }

        try {
            zkClient.createEphemeral(myLock);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean releaseLock() {
        zkClient.delete(myLock);
        String name = Thread.currentThread().getName();
        System.out.println("----------线程释放锁成功" + name);
        return true;
    }

    @Override
    public void waitLock() {
        String name = Thread.currentThread().getName();
        System.out.println("************线程获取锁失败阻塞等待中" + name);

        IZkDataListener iZkDataListener = new IZkDataListener() {

            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("数据内容发生了变化");
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("节点数量发生了变化");
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };

        //创建zk监听
        zkClient.subscribeDataChanges(myLock, iZkDataListener);
        //这个节点存在的情况下先阻塞当前线程
        if (zkClient.exists(myLock)) {
            try {
                countDownLatch = new CountDownLatch(1);
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果这个节点不存则取消监听
        zkClient.unsubscribeDataChanges(myLock, iZkDataListener);
    }

}
