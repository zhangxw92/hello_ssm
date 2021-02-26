package com.athome.composite2;

/**
 * @Author zhangxw03
 * @Dat 2021-02-26 16:23
 * @Describe
 */
public abstract class AbsComposite {
    private String name;
    private String des;

    public AbsComposite(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public void add(AbsComposite absComposite) {
        throw new UnsupportedOperationException("add由子类实现..");
    }

    public void remove(AbsComposite absComposite) {
        throw new UnsupportedOperationException("remove由子类实现..");
    }

    public abstract void print();

    @Override
    public String toString() {
        return "AbsComposite{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
