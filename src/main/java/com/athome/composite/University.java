package com.athome.composite;

import java.util.ArrayList;
import java.util.List;

public class University extends Organization {

    private List<Organization> list = new ArrayList<>();

    public University(String name, String descripe) {
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
    protected void add(Organization organization) {
        list.add(organization);
    }

    @Override
    protected void remove(Organization organization) {
        list.remove(organization);
    }

    @Override
    protected void print() {
        System.out.println("------" + getName() + "------------");
        for (Organization organization : list) {
            organization.print();
        }

    }
}
