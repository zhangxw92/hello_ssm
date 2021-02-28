package com.athome.chain2;

public class Client {
    public static void main(String[] args) {
        DemoChain demoChain = new DemoImplChain("实例1");

        DemoChain demoChain2 = new DemoImpl2Chain("实例2");

        DemoChain demoChain3 = new DemoImpl3Chain("实例3");

        demoChain.setNextDemoChain(demoChain2);
        demoChain2.setNextDemoChain(demoChain3);
        demoChain3.setNextDemoChain(demoChain);
        demoChain.request(55);
    }
}
