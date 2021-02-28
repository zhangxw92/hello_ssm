package com.athome.composite2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangxw03
 * @Dat 2021-02-26 16:25
 * @Describe
 */
public class College extends AbsComposite {

    List<AbsComposite> list = new ArrayList<>();

    public College(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(AbsComposite absComposite) {
        list.add(absComposite);
    }

    @Override
    public void remove(AbsComposite absComposite) {
        list.remove(absComposite);
    }

    @Override
    public void print() {
        System.out.println(super.toString());
        for (AbsComposite absComposite : list) {
            System.out.println(absComposite.toString());
            absComposite.print();
        }
    }
}
