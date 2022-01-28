package com.icbc.sh.maven.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AController {
    @RequestMapping(value = {"/maven/test"})
    public String mavenTest() {
        System.out.println("this is a test!");
       return "ok";
    }
}
