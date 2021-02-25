package com.athome.decorator2;

/**
 * @Author zhangxw03
 * @Dat 2021-02-25 16:28
 * @Describe
 */
public class CloseDecorator extends Decorator {
    Man man;

    public CloseDecorator(Man man) {
        this.man = man;
    }

    @Override
    protected void goOut() {
        man.goOut();
        System.out.println("穿上新衣");
    }

    public static void main(String[] args) {
        Man man = new CloseDecorator(new WomanMan());
        man.goOut();
    }
}
