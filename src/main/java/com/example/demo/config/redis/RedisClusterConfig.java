package com.example.demo.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @createDate: 2019-08-22 15:11
 * @description:
 */
@SpringBootConfiguration
public class RedisClusterConfig {
    @Autowired
    private ClusterRedisConfig clusterProperties;

    @Bean
    public RedisClusterConfiguration getClusterConfig() {
        RedisClusterConfiguration rcc = new RedisClusterConfiguration(clusterProperties.getNodes());
        rcc.setMaxRedirects(clusterProperties.getMaxRedirects());
        return rcc;
    }

    @Bean
    public JedisConnectionFactory getConnectionFactory(RedisClusterConfiguration cluster) {
        return new JedisConnectionFactory(cluster);
    }

    @Bean
    public RedisTemplate getRedisTemplate(JedisConnectionFactory factory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate getStringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringTemplate = new StringRedisTemplate();
        stringTemplate.setConnectionFactory(factory);
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        stringTemplate.setKeySerializer(redisSerializer);
        stringTemplate.setHashKeySerializer(redisSerializer);
        stringTemplate.setValueSerializer(redisSerializer);
        return stringTemplate;
    }
}
