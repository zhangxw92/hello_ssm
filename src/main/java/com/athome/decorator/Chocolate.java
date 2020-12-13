package com.athome.decorator;

public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        setDescripe("调味品：巧克力");
        setPrice(2.0f);
    }
}
