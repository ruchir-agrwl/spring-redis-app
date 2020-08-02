package com.learn.redis.controller;

import com.learn.redis.model.User;
import com.learn.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/redis")
public class MyRedisController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/add/{id}/{name}/{salary}")
    public User add(@PathVariable("id") String id, @PathVariable("name") String name, @PathVariable("salary") Long salary){
        User user = new User(id,name,salary);
       userRepository.save(user);
       return user;
    }

    @GetMapping("all")
    public Map<String,User> all(){
        return userRepository.findAll();
    }
}
