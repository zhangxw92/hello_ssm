package com.athome.decorator2;

/**
 * @Author zhangxw03
 * @Dat 2021-02-25 16:28
 * @Describe
 */
public class ErDecorator extends Decorator {
    Man man;

    public ErDecorator(Man man) {
        this.man = man;
    }

    @Override
    protected void goOut() {
        man.goOut();
        System.out.println("带上首饰");
    }

    public static void main(String[] args) {
        Man man = new CloseDecorator(new WomanMan());
        man = new ErDecorator(man);
        man.goOut();
    }
}
