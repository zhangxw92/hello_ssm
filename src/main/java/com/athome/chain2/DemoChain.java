package com.athome.chain2;

public abstract class DemoChain {
    protected DemoChain nextDemoChain;

    protected String name;

    public DemoChain(String name) {
        this.name = name;
    }

    public abstract void request(Integer request);

    protected void setNextDemoChain(DemoChain demoChain) {
        this.nextDemoChain = demoChain;
    }
}
