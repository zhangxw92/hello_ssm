package com.athome.chain;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 15:39
 * @Describe 有A B C三个程序员分别是低、中、高级别，
 * A处理不了交给B处理，B处理不了交给C处理
 */
public abstract class BaseChain {

    //bug的难度,1-A处理，2-B处理，3-C处理
    public Integer type;

    //链的名字
    public String name;

    //链的下一个
    public BaseChain baseChain;

    //提供set方法
    public void setName(String name) {
        this.name = name;
    }

    public void setBaseChain(BaseChain baseChain) {
        this.baseChain = baseChain;
    }

    //这个链能做什么事情
    public void doChain() {
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
