package com.athome.lock;

import org.openjdk.jol.info.ClassLayout;

public class A {
    boolean a = false;

    public static void main(String[] args) {
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
