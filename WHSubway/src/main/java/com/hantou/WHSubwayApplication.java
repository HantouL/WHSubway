package com.hantou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hantou.Mapper")
public class WHSubwayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WHSubwayApplication.class,args);
    }
}