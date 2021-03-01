package com.athome.state2;

public class CommonPersonState extends PersonState {
    @Override
    protected void handler() {
        System.out.println("正常的做事...");
    }
}
