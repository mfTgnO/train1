package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ComponentScan("com.example.demo.config")
public class RedisConfig {

    /**
     * 关于JedisConnectionFactory的配置：
     * 1. 主机与端口号:在配置体系中由RedisStandaloneConfiguration负责设置,在JedisConnectionFactory中有个standaloneConfig字段默认设置了"localhost:6379"的地址
     * 2. 用户名与密码:在配置体系中由RedisSentinelConfiguration负责配置,但redis默认可以无需用户登录,所以要配置用户名与密码需要调用JedisConnectionFactory(RedisSentinelConfiguration sentinelConfig)的构造方法 * 3. 其他配置:redis的其他配置选项由三层架构构成,分别为:BaseObjectPoolConfig->GenericObjectPoolConfig->JedisPoolConfig
     * 实际上在JedisPoolConfig已经将所有配置设置完毕,如果用户需要自定义设置,可以创建JedisPoolConfig实例,也可以创建GenericObjectPoolConfig实例,区别在于JedisPoolConfig可以比GenericObjectPoolConfig多配置四个参数 * 在用户自定JedisPoolConfig之后可以调用new JedisConnectionFactory(JedisPoolConfig)获取工厂实例.
     * 而实际上,JedisConnectionFactory有一个内部类MutableJedisClientConfiguration,MutableJedisClientConfiguration中默认创建有JedisPoolConfig的实例
     * 如果用户未自定义JedisPoolConfig则JedisConnectionFactory直接使用MutableJedisClientConfiguration中的配置,
     * 如果用户自定义了JedisPoolConfig,则MutableJedisClientConfiguration会调用setPoolConfig(GenericObjectPoolConfig poolConfig)方法进行处理,可以注意到,这里的poolconfig实际上是一个GenericObjectPoolConfig * 4. 总结:
     * 要是不进行配置,直接调用JedisConnectionFactory的无参构造即可;
     * 如果要设置密码,实例化RedisSentinelConfiguration进行配置;
     * 如果要设置主机,实例化RedisStandaloneConfiguration进行配置
     * 如果要设置其他项目,实例化JedisPoolConfig进行配置
     *
     * @return
     */

    /*@Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("192.168.2.211");
        factory.setPort(6379);
//        factory.setUsePool(true);
        return factory;
    }*/

    private final RedisConnectionFactory redisConnectionFactory;

    public RedisConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 设置数据存入 redis 的序列化方式
     *
     * @param redisTemplate
     * @param factory
     */
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());

        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * 实例化 HashOperations 对象,可以使用 Hash 类型操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    /**
     * 实例化 ValueOperations 对象,可以使用 String 操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 实例化 ListOperations 对象,可以使用 List 操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * 实例化 SetOperations 对象,可以使用 Set 操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * 实例化 ZSetOperations 对象,可以使用 ZSet 操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }

    public enum redisKeyPrefix {
        /**
         * 省份
         */
        PROVINCE("province:"),
        /**
         * 城市
         */
        CITY("city:"),
        /**
         * 区、县
         */
        COUNTRY("country:"),
        /**
         * 镇、街道
         */
        TOWN("town:"),
        /**
         * 用户（测试数据）
         */
        USER("user:");

        private String prefix;

        redisKeyPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }
}
