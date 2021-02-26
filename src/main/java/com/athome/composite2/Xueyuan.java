package com.athome.composite2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangxw03
 * @Dat 2021-02-26 16:37
 * @Describe
 */
public class Xueyuan extends AbsComposite {

    List<AbsComposite> list = new ArrayList<>();

    public Xueyuan(String name, String des) {
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
        for (AbsComposite absComposite : list) {
            System.out.println(absComposite.toString());
        }

    }
}
