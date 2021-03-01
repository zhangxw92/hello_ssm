package com.athome.state2;

public class SadPersonState extends PersonState {
    @Override
    protected void handler() {
        System.out.println("悲伤的做事...");
    }
}
