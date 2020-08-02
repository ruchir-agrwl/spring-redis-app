package com.learn.redis.repository;

import com.learn.redis.model.User;

import java.util.Map;

public interface UserRepository {

    void save(User user);
    Map<String, User> findAll();
    void update(User user);
    void delete(String id);
    User findById(String id);
}
