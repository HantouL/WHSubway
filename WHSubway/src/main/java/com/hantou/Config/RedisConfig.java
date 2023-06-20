package com.hantou.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//emmmm 好像没有用到redis
@Configuration
public class RedisConfig {
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.cluster.node}")
    private String url;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.lettuce.pool.max-idle}")
    private Integer idle;
    @Bean
    public JedisPool getRedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(idle);
        jedisPoolConfig.setMaxTotal(18);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,url,port,5000,password);
        return jedisPool;
    }
}
