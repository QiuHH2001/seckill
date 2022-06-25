package com.example.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@MapperScan("com.example.seckill.mapper")
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }

}
