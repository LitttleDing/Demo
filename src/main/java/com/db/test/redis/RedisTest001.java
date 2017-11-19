package com.db.test.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisTest001 {

    public static void main(String[] args) {
        lpush();

        System.out.println("data already list -------------- ");

        lrange();
    }

    private static void redisStr(){
        Jedis jedis = new Jedis("localhost");

        jedis.set("testStr","i am really happy !");

        System.out.println("this is the str :"+jedis.get("testStr"));
    }

    private static void lpush(){
        Jedis jedis = new Jedis("localhost");

        jedis.lpush("list","str1");
        jedis.lpush("list","str2");
        jedis.lpush("list","str3");
        jedis.lpush("list","str4");
        jedis.lpush("list","str5");
        jedis.lpush("list","str6");
    }

    private static void lrange(){
        Jedis jedis = new Jedis("localhost");

        List<String> list = jedis.lrange("list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }
}
