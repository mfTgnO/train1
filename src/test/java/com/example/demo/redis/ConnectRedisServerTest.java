package com.example.demo.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class ConnectRedisServerTest {
    @Test
    public void connect() {
        //Connecting to Redis server on localhost
//        Jedis jedis = new Jedis("192.168.2.211", 6379);
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("Connection to server sucessfully");

        //check whether server is running or not
        System.out.println("Server is running: " + jedis.ping());
    }
}
