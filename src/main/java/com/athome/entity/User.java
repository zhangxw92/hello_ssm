package com.athome.entity;

import lombok.Data;

/**
 * @Author zhangxw03
 * @Dat 2020-11-26 13:02
 * @Describe
 */
@Data
public class User {
    private String name;
    private String password;

    private Address address;
    //1-男 2-女 3-未知
    private Integer sex;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
