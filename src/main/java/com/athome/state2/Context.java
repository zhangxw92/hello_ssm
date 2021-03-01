package com.athome.state2;

public class Context {

    private PersonState state;

    public void changeState(PersonState state) {
        this.state = state;
    }

    public void doWork() {
        state.handler();
    }

    public static void main(String[] args) {
        Context lili = new Context();

        lili.changeState(new HappyPersonState());
        lili.doWork();

        lili.changeState(new SadPersonState());
        lili.doWork();

        lili.changeState(new CommonPersonState());
        lili.doWork();
    }
}
