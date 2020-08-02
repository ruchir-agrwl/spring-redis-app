package com.learn.redis.repository;

import com.learn.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    RedisTemplate<String,User> redisTemplate;

    HashOperations hashOperations;

    @Autowired
    public UserRepositoryImpl(RedisTemplate<String,User> redisTemplate,HashOperations hashOperations) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getUserId(),user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public void update(User user) {
        hashOperations.put("USER", user.getUserId(),user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("USER",id);
    }

    @Override
    public User findById(String id) {
        return (User)hashOperations.get("USER",id);
    }
}
