package com.athome.chain;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 15:57
 * @Describe
 */
public class PersonCCahinImpl extends BaseChain {

    @Override
    public void doChain() {
        if (type == 3) {
            System.out.println(name + "已经处理");
        } else {
            System.out.println("超出程序员的解决范围，需向领导汇报...");
        }
    }
}
