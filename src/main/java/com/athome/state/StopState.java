package com.athome.state;

public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("停止状态");
        context.setState(this);
    }


    @Override
    public String toString() {
        return "停止状态";
    }
}
