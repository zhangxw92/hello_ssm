package com.athome.chain;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 15:58
 * @Describe
 */
public class TestChain {

    public static void main(String[] args) {

        PersonAChainImpl A = new PersonAChainImpl();
        PersonBChainImpl B = new PersonBChainImpl();
        PersonCCahinImpl C = new PersonCCahinImpl();

        A.setName("程序员A");
        B.setName("程序员B");
        C.setName("程序员C");

        A.setType(3);
        B.setType(3);
        C.setType(3);

        A.setBaseChain(B);
        B.setBaseChain(C);

        A.doChain();


    }

}
