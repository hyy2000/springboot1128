package com.atguigu.jedis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class Demo02 {

    public static void main(String[] args) {
        //指定Jedis连接池的配置信息
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(200);
        poolConfig.setMaxIdle(32);
        poolConfig.setMaxWaitMillis(100*1000);
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setTestOnBorrow(true);  // ping  PONG

        JedisPool jedisPool = new JedisPool(poolConfig, "192.168.6.99", 6379,60000 );
        Jedis jedis = jedisPool.getResource();
        String ping = jedis.ping();
        System.out.println("ping = " + ping);

        jedis.set("key1","v1");
        jedis.set("key2","v2");
        jedis.set("key3","v3");
        jedis.set("key4","v4");
        Set<String> keys = jedis.keys("*");
        System.out.println("keys = " + keys);
        keys.forEach(System.out::println);


    }


}
