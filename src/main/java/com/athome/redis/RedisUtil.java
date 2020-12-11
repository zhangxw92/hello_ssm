package com.athome.redis;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    static Jedis jedis = new Jedis("39.102.61.252");

    public static Jedis getInstance() {
        jedis.auth("ZXW123456");
        System.out.println(jedis.ping());
        return jedis;
    }


}
