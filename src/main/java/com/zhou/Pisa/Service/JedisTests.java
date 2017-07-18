package com.zhou.Pisa.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Dennis_zhou on 2017/7/18.
 */
public class JedisTests {
    public static void main(String[] args) throws Exception {


        //连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxTotal(20);
        JedisPool pool = new JedisPool(config,"127.0.0.1",6379,2000);
        Jedis jedis = pool.getResource();

        jedis.set("SpringBoot","MySpringBootTest");
        System.out.println(jedis.get("SpringBoot"));

        jedis.close();
        pool.close();
    }
}
