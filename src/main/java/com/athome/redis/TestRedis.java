package com.athome.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;


public class TestRedis {

    @Test
    public void test4() {
        Jedis instance = RedisUtil.getInstance();
        instance.sadd("user", "zhangsan");
        instance.sadd("user", "lisi");
        instance.sadd("user", "wangwu");

        //随机抽一个不删除
        String user1 = instance.srandmember("user");
        System.out.println(user1);
        System.out.println("-------------------------");
        //随机抽一个删除
        String user2 = instance.spop("user");
        System.out.println(user2);
        System.out.println("-------------------------");
        Set<String> user = instance.smembers("user");
        for (String s : user) {
            System.out.println(s);
        }


    }

    @Test
    public void test3() throws InterruptedException {
        Jedis instance = RedisUtil.getInstance();
        instance.set("g", "分布式锁", "nx", "ex", 10);
        System.out.println(instance.get("g"));

        Thread.sleep(9000);

        instance.set("g", "分布式锁2", "nx", "ex", 10);
        System.out.println(instance.get("g"));
    }

    @Test
    public void test2() {
        Jedis instance = RedisUtil.getInstance();
        //当key不存在的时候，给key关联一个value值，否则什么也不做
        instance.setnx("a", "vvvvvvv");
        System.out.println(instance.get("a"));
    }

    @Test
    public void test1() {
        Jedis instance = RedisUtil.getInstance();
        //给key关联一个value并且设置过期时间
        //instance.setex("user", 10, "xxxxxxxxxx");
        System.out.println(instance.get("user"));
        System.out.println(instance.ttl("user"));
    }

    @Test
    public void test() {
        Jedis jedis = RedisUtil.getInstance();

        jedis.set("name", "张晓");
        System.out.println(jedis.get("name"));

        jedis.rpush("city", "北京");
        jedis.rpush("city", "上海");
        jedis.rpush("city", "庆阳");

        List<String> city = jedis.lrange("city", 0, -1);
        city.forEach(c -> {
            System.out.println(c);
        });

    }
}
