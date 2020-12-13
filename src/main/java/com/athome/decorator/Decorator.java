package com.athome.decorator;

public class Decorator extends Drink {

    private Drink drink;

    //通过构造方法将每种咖啡加入到装饰器中
    public Decorator(Drink drink) {
        this.drink = drink;
    }

    /**
     * 价格= 小料的价格+每种咖啡的价格
     *
     * @return
     */
    @Override
    public float cost() {

        return super.getPrice() + drink.cost();
    }

    public String getDescripe() {

        return super.getDescripe() + "  " + drink.getDescripe();
    }
}
