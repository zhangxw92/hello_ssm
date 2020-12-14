package com.athome.template;

public abstract class SoyBeanMilk {

    final void make() {

        select();
        if (isAdd()) {
            add();
        }
        brew();
        beat();
    }

    void select() {
        System.out.println("挑选材料");
    }

    //不同豆浆加入佐料不同
    abstract void add();

    void brew() {
        System.out.println("泡制");
    }

    void beat() {
        System.out.println("击碎");
    }

    //钩子方法
    boolean isAdd() {
        return true;
    }

}
