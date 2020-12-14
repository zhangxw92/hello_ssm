package com.athome.composite;

import lombok.Data;

@Data
public abstract class Organization {

    private String name;
    private String descripe;

    public Organization(String name, String descripe) {
        this.name = name;
        this.descripe = descripe;
    }

    //因为在叶子节点不需要添加删除操作，只能在非叶子节点添加删除操作，由非叶子节点提供具体实现
    protected void add(Organization organization) {

        throw new UnsupportedOperationException();
    }

    protected void remove(Organization organization) {
        throw new UnsupportedOperationException();
    }

    protected abstract void print();
}
