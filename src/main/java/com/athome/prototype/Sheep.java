package com.athome.prototype;

/**
 * @Author zhangxw03
 * @Dat 2021-02-23 13:03
 * @Describe
 */
public class Sheep extends AbsBeanCanCloneAble<Sheep> {
    private String name;
    private Integer age;
    private String color;
    public Sheep friend;

//    @Override
//    public Sheep clone() {
//        Sheep sheep = null;
//        try {
//            sheep = (Sheep) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return sheep;
//    }

    public static void main(String[] args) {
        Sheep sheep = new Sheep("白羊", 23, "白色");
        sheep.friend = new Sheep("黑羊", 22, "黑色");

        Sheep sheep1 = sheep.clone();
        Sheep sheep2 = sheep.clone();
        Sheep sheep3 = sheep.clone();
        Sheep sheep4 = sheep.clone();
        Sheep sheep5 = sheep.clone();

        System.out.println("sheep:" + sheep.toString() + ",sheep.hashCode()" + sheep.hashCode());
        System.out.println("sheep1:" + sheep1.toString() + ",sheep1.hashCode()" + sheep1.hashCode());
        System.out.println("sheep2:" + sheep2.toString() + ",sheep2.hashCode()" + sheep2.hashCode());
        System.out.println("sheep3:" + sheep3.toString() + ",sheep3.hashCode()" + sheep3.hashCode());
        System.out.println("sheep4:" + sheep4.toString() + ",sheep4.hashCode()" + sheep4.hashCode());
        System.out.println("sheep5:" + sheep5.toString() + ",sheep5.hashCode()" + sheep5.hashCode());

    }

    public Sheep(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", friend=" + friend +
                '}';
    }
}
