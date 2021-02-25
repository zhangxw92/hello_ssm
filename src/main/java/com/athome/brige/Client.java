package com.athome.brige;

/**
 * @Author zhangxw03
 * @Dat 2021-02-25 10:51
 * @Describe 传统采用接口、继承的方式实现电脑的品牌分类
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new LianTaiComputer();
        computer.info();
        Computer computer2 = new LianBiComputer();
        computer2.info();
        Computer computer3 = new HuaBiComputer();
        computer3.info();
        Computer computer4 = new HuaBiComputer();
        computer4.info();
    }
}
