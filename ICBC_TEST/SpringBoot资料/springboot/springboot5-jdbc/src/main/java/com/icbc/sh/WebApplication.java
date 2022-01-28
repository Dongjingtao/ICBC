package com.icbc.sh;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 本示例用于新员工培训 springboot-web项目 jdbc连接的用法
 * 1.maven引用加入jdbc相关jar包
 * 2.application.yml 的相关数据库配置
 * 3.建立数据库相关表
 * 4.根据表生成entity、mapper、service
 * 5.在本类上加入mapper扫描注解
 */
@MapperScan("com.icbc.sh.mapper")
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);
    }
}
