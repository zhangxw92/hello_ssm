package com.athome.composite2;

/**
 * @Author zhangxw03
 * @Dat 2021-02-26 16:42
 * @Describe
 */
public class Zhuanye extends AbsComposite {

    public Zhuanye(String name, String des) {
        super(name, des);
    }

    @Override
    public void print() {
        System.out.println(super.toString());
    }
}
