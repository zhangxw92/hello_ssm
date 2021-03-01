package com.athome.state2;

public class HappyPersonState extends PersonState {
    @Override
    protected void handler() {
        System.out.println("开行的做事...");
    }
}
