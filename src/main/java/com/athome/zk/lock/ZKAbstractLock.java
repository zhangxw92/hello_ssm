package com.athome.zk.lock;

import org.I0Itec.zkclient.ZkClient;

/**
 * @Author zhangxw03
 * @Dat 2021-01-05 12:00
 * @Describe
 */
public abstract class ZKAbstractLock {
    protected static ZkClient zkClient = ZKUtil.getConnection();

    public void acquireLock() {
        String name = Thread.currentThread().getName();
        if (tryAcquire()) {
            System.out.println("+++++++++++++线程获取锁成功" + name);
        } else {
            //阻塞等待
            waitLock();
            //递归，重新获取锁
            acquireLock();
        }
    }

    public abstract boolean releaseLock();

    public abstract void waitLock();

    public abstract boolean tryAcquire();
}
