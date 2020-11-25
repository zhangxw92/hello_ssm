package com.athome.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhangxw03
 * @Dat 2020-11-25 17:34
 * @Describe
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        System.out.println("===========================");
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + ":" + m.getValue());
        }
        System.out.println("===========================");
        for (String m : map.keySet()) {
            System.out.println(m + ":" + map.get(m));
        }
        System.out.println("===========================");

        for (String s : map.values()) {
            System.out.println(s);
        }
        ;
    }
}
