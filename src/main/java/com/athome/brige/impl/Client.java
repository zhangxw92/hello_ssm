package com.athome.brige.impl;

/**
 * @Author zhangxw03
 * @Dat 2021-02-25 11:20
 * @Describe
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new TaiComputer(new LianBrand());
        computer.open();

        Computer computer2 = new BiComputer(new LianBrand());
        computer2.open();
    }

}
