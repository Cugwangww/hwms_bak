package com.learning.es.api.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author wwwang7
 * @Date 2019/7/25 10:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class RedisTestController {

    @Autowired
    private StringRedisTemplate template;

    @Test
    public void savereids() {
        template.opsForValue().set("sss","rrrr");
    }

    @Test
    public void saveHashReids(){

    }

}
