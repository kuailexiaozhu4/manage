package com.zhu.manage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void Test() {
//        redisTemplate.opsForSet().add("name", "zhuwulong");
//        redisTemplate.expire("name", 5000, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            System.out.println("异常");
//        }
        System.out.println(redisTemplate.getExpire("name"));
        System.out.println(redisTemplate.opsForSet().members("name"));
    }
}
