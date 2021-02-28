package com.athome.state;

public class StartState implements State {

    @Override
    public void doAction(Context context) {

        System.out.println("开始状态");

        context.setState(this);

    }

    @Override
    public String toString() {
        return "开始状态";
    }
}
