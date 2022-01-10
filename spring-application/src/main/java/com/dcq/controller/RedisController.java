package com.dcq.controller;

import com.dcq.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("stringGet")
    public String stringGet(){
//        redisUtils.set("name","1111");
        Object name = redisUtils.get("name");
        return name.toString();

    }

}
