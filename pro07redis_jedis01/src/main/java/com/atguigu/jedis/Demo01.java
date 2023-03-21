package com.atguigu.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class Demo01 {
    public static void main(String[] args) {
        //指定Jedis连接池的配置信息
         Jedis jedis = new Jedis("192.168.6.99",6379);
        String ping = jedis.ping();
        System.out.println("ping = " + ping);
        jedis.close();
    }
}
