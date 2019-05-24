package com.sun.service.impl;

import com.sun.redis.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

import static org.junit.Assert.*;

public class RedisServiceImplTest {

    @Test
    public void redisflushAll() {
        Jedis jedis = JedisUtil.getJedis();
        jedis.flushAll();
    }

    @Test
    public void flushAll() {

    }

    @Test
    public void getAllKeys() {
        Jedis jedis = JedisUtil.getJedis();
        Set<String> set=jedis.keys("*");
        for (String s:set
             ) {
            System.out.println(s);
        }
    }

    @Test
    public void deleteKeys() {
        Jedis jedis=JedisUtil.getJedis();
        System.out.println(jedis.del("qqwe"));
    }
}