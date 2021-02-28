package com.athome.chain2;

public class DemoImplChain extends DemoChain {

    public DemoImplChain(String name) {
        super(name);
    }

    @Override
    public void request(Integer request) {
        if (request < 100) {
            System.out.println("该任务被" + name + "执行");
        } else {
            nextDemoChain.request(request);
        }
    }
}
