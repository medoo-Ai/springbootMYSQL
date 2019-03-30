package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @auther SyntacticSugar
 * @data 2019/3/30 0030下午 1:04
 */

@EnableJpaRepositories(basePackages = "com.demo.spring.jpa")
@EntityScan(basePackages = "com.demo.spring.bean")
@SpringBootApplication(scanBasePackages = {"com.demo.spring"})
public class SpringAppMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringAppMain.class, args);
        System.out.println("服务已经启动");
    }
}
