package com.athome.composite2;

/**
 * @Author zhangxw03
 * @Dat 2021-02-26 16:31
 * @Describe
 */
public class Client {
    public static void main(String[] args) {
        AbsComposite absComposite = new College("中国农业大学", "好");

        AbsComposite absComposite2 = new Xueyuan("计算机学院", "hello");
        AbsComposite absComposite4 = new Zhuanye("科学通信", "科学通信");
        AbsComposite absComposite5 = new Zhuanye("科学网络", "科学网络");
        absComposite2.add(absComposite4);
        absComposite2.add(absComposite5);

        AbsComposite absComposite3 = new Xueyuan("土木学院", "word");
        AbsComposite absComposite6 = new Zhuanye("道路", "道路");
        AbsComposite absComposite7 = new Zhuanye("桥梁", "桥梁");
        absComposite3.add(absComposite6);
        absComposite3.add(absComposite7);

        absComposite.add(absComposite2);
        absComposite.add(absComposite3);

        absComposite.print();
    }


}
