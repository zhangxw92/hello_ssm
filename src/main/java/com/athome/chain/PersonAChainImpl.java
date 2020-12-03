package com.athome.chain;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 15:49
 * @Describe
 */
public class PersonAChainImpl extends BaseChain {

    @Override
    public void doChain() {
        if (type == 1) {
            System.out.println(name + "已经处理");
        } else {
            baseChain.doChain();
        }
    }


}
