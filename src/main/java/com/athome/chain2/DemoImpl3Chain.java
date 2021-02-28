package com.athome.chain2;

public class DemoImpl3Chain extends DemoChain {

    public DemoImpl3Chain(String name) {
        super(name);
    }

    @Override
    public void request(Integer request) {
        if (request < 1000) {
            System.out.println("该任务被" + name + "执行");
        } else {
            nextDemoChain.request(request);
        }
    }
}
