package com.athome.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

/**
 * @Author zhangxw03
 * @Dat 2020-12-11 10:39
 * @Describe
 */
public class DateUtil {

    private static String format = "yyyy-MM-dd hh:mm:ss";
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(format);
        }
    };

    @Test
    public void test() {
        for (int i = 0; i <= 1000; i++) {
            Executors.newFixedThreadPool(20).execute(() -> {
                SimpleDateFormat simpleDateFormat = threadLocal.get();
                try {
                    System.out.println(Thread.currentThread().getName() + "   " + simpleDateFormat.parse("2020-12-11 11:30:33"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        //这种方式多线程情况下会报错
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        for (int i = 0; i <= 1000; i++) {
            Executors.newFixedThreadPool(20).execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "   " + s.parse("2020-12-11 11:30:33"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
