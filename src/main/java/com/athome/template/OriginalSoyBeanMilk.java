package com.athome.template;

public class OriginalSoyBeanMilk extends SoyBeanMilk {
    @Override
    void add() {

    }


    //重写钩子方法

    @Override
    boolean isAdd() {
        return false;
    }
}
