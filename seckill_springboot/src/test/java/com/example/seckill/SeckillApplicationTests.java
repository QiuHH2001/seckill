package com.example.seckill;

import cn.hutool.core.date.LocalDateTimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeckillApplicationTests {

    @Test
    void localDateTime() {
        System.out.println(LocalDateTimeUtil.now());
    }

}
