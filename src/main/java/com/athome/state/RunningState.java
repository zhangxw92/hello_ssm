package com.athome.state;

public class RunningState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("运行状态");
        context.setState(this);

    }


    @Override
    public String toString() {
        return "运行状态";
    }
}
