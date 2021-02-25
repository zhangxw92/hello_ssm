package com.athome.brige.impl;

/**
 * @Author zhangxw03
 * @Dat 2021-02-25 11:11
 * @Describe
 */
public class BiComputer extends Computer {

    public BiComputer(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        //品牌
        this.brand.info();
        //
        System.out.println("笔记本电脑--");
    }
}
