package com.athome.chain;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 15:55
 * @Describe
 */
public class PersonBChainImpl extends BaseChain {

    @Override
    public void doChain() {
        if (type == 2) {
            System.out.println(name + "已经处理");
        } else {
            baseChain.doChain();
        }
    }
}
