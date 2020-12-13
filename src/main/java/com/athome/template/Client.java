package com.athome.template;

public class Client {

    public static void main(String[] args) {

        SoyBeanMilk readSoyBeamMilk = new ReadSoyBeamMilk();
        readSoyBeamMilk.make();

        SoyBeanMilk jujubeSoyBeanMilk = new JujubeSoyBeanMilk();
        jujubeSoyBeanMilk.make();

        SoyBeanMilk soyBeanMilk = new OriginalSoyBeanMilk();
        soyBeanMilk.make();
    }
}
