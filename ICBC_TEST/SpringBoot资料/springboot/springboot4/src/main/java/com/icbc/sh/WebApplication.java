package com.icbc.sh;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 本示例用于新员工培训 springboot-web项目 循环引用启动失败
 */
@SpringBootApplication
@EnableAsync
public class WebApplication {
    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);
    }
}
