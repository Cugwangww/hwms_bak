package com.learning.api.redis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wwwang7
 * @Date 2019/7/24 20:18
 */
@RestController("/redis")
@Api("Redis测试")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test01")
    @ApiOperation(value = "String类型",notes = "String类型")
    public void Test01(){
        redisTemplate.opsForValue().set("111","dddd");
        String value = (String) redisTemplate.opsForValue().get("111");
        System.out.println(value);
    }
}
