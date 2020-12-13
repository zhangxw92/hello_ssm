package com.athome.composite;

import java.util.ArrayList;
import java.util.List;

public class Profession extends Organization {

    public Profession(String name, String descripe) {
        super(name, descripe);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescripe() {
        return super.getDescripe();
    }

    @Override
    protected void print() {
        System.out.println("------" + getName() + "------------");

    }
}
