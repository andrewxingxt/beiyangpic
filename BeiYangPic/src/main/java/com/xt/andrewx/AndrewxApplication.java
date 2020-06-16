package com.xt.andrewx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@MapperScan("com.xt.andrewx.mapper")
public class AndrewxApplication {

    public static void main(String[] args) {

        SpringApplication.run(AndrewxApplication.class, args);

    }

}
