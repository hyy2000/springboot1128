package com.atguigu.jedis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class Demo03 {

    public static void main(String[] args) {
        //指定Jedis连接池的配置信息
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(200);
        poolConfig.setMaxIdle(32);
        poolConfig.setMaxWaitMillis(100*1000);
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setTestOnBorrow(true);  // ping  PONG

        Jedis jedis;
        try (JedisPool jedisPool = new JedisPool(poolConfig, "192.168.6.99", 6379, 60000)) {
            jedis = jedisPool.getResource();
        }
        String ping = jedis.ping();
        System.out.println("ping = " + ping);

        jedis.zadd("database",90,"mysql");
        jedis.zadd("database",75,"sqlserver");
        jedis.zadd("database",60,"redis");
        jedis.zadd("database",70,"Oracle");
        Set<String> database = jedis.zrange("database", 0, -1);
        Set<String> database1 = jedis.zrevrange("database", 0, -1);
        Set<Tuple> database2 = jedis.zrangeWithScores("database", 0, -1);
        database.forEach(System.out::println);
        System.out.println("================");
        database1.forEach(System.out::println);
        System.out.println("================");
        for (Tuple tuple : database2) {
            System.out.println(tuple);
        }
//        Set<String> keys = jedis.keys("*");
//        System.out.println("keys = " + keys);
//        keys.forEach(System.out::println);


    }


}
