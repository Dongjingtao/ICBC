package com.icbc.sh.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 本示例用于新员工培训maven模块 理解maven中dependency-scope属性的区别
 */
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);
    }
}
