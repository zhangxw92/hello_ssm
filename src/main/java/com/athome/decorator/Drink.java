package com.athome.decorator;

import lombok.Data;

/**
 * 需要实现的需求是，设计出可以下单多种咖啡并且每种咖啡都可以添加小料，最后计算出总价格
 */
@Data
public abstract class Drink {

    //单体饮料的描述
    private String descripe;

    //单体饮料的价格
    private float price;

    //计算价格
    public abstract float cost();
}
