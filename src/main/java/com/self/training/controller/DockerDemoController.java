package com.self.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerDemoController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/demo")
    public String demo() {
        Long viewNum = redisTemplate.opsForValue().increment("views");
        return String.format("Hello, you are the %s visitor", viewNum);
    }

}
