package com.x.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@MapperScan("com.x.demo.mapper")
@SpringBootApplication
@ImportResource({"classpath:xxl-job-executor.xml"})
public class BootDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(BootDemo01Application.class, args);
        System.out.println("==============启动成功================");
    }

}
