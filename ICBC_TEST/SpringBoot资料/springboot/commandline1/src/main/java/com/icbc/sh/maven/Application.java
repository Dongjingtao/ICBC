package com.icbc.sh.maven;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        //目前的做法是在commandline内进行关闭
        SpringApplication.run(Application.class, args);
    }
}
