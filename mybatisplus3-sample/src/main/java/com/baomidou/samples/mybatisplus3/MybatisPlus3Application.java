package com.baomidou.samples.mybatisplus3;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableTransactionManagement
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan("com.baomidou.samples.mybatisplus3.mapper")
public class MybatisPlus3Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus3Application.class, args);
        log.info("open http://localhost:8080/doc.html");
    }
}