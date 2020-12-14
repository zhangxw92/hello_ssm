package com.athome.composite;

public class Client {

    public static void main(String[] args) {

        University university = new University("北京大学", "一流的大学");

        College college = new College("计算机学院", "非常好");
        College college1 = new College("工学院", "比较好");

        college.add(new Profession("网络工程", "不错"));
        college.add(new Profession("通信工程", "很好"));

        college1.add(new Profession("水利", "不错"));
        college1.add(new Profession("水电", "很好"));


        university.add(college);
        university.add(college1);

        university.print();

    }
}
