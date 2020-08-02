package com.learn.redis.config;

import com.learn.redis.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class MyRedisConfig {

    @Bean
    JedisConnectionFactory createJedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, User> redisTemplate(){
        RedisTemplate<String,User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(createJedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    HashOperations hashOperations(){
        return redisTemplate().opsForHash();
    }

}
