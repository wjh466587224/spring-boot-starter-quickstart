package com.spring.boot.starter.quickstart.springbootstarterquickstart;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/say")
    public String say(){
        RBucket bucket=redissonClient.getBucket("name");
        if(bucket.get()==null){
            bucket.set("wjh666");
        }
        return bucket.get().toString();
    }
}
