package com.athome.chain2;

public class DemoImpl2Chain extends DemoChain {

    public DemoImpl2Chain(String name) {
        super(name);
    }

    @Override
    public void request(Integer request) {
        if (request < 500) {
            System.out.println("该任务被" + name + "执行");
        } else {
            nextDemoChain.request(request);
        }
    }
}
