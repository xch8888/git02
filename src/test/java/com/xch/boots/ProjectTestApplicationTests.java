package com.xch.boots;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class ProjectTestApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        long lo=jdbcTemplate.queryForObject("select count(*) from smbms_user",long.class);
        log.info("---------------------->记录数为:"+lo);
    }

//    @Test
//    void redisTest(){
//        ValueOperations<String,String> opsForValue =redisTemplate.opsForValue();
//        opsForValue.set("WelCome","cheng");
//        String welCome=opsForValue.get("WelCome");
//        System.out.println("测试的结果为---------------->"+welCome);
//    }

}
