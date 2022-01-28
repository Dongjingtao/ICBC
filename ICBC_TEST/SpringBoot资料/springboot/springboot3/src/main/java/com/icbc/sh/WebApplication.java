package com.icbc.sh;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 本示例用于新员工培训 springboot-web项目 对比xml/json的使用区别 以及springboot1.x和2.x的版本区别
 */
@SpringBootApplication
//@ServletComponentScan
public class WebApplication {
    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);
    }
}
