package com.athome.decorator;

public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        setDescripe("调味品：牛奶");
        setPrice(2.0f);
    }
}
