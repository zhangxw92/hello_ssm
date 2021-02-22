package com.athome.single;

import com.athome.entity.Address;

/**
 * @Author zhangxw03
 * @Dat 2021-01-04 15:51
 * @Describe
 */
public enum Single6Enum {
    INSTANCE(1, "sessionFactory", "mybatis");

    private Integer id;
    private String name;
    private String Address;

    private Single6Enum(Integer id, String name, String Address) {
        this.id = id;
        this.name = name;
        this.Address = Address;
    }

    public void say() {
        System.out.println("ok！");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Single6Enum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Single6Enum instance = Single6Enum.INSTANCE;
        Single6Enum instance2 = Single6Enum.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println(instance.toString());
        instance.say();
    }
}
