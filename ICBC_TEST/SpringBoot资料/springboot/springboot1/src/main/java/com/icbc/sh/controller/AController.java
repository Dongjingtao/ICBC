package com.icbc.sh.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AController {
    @RequestMapping(value = {"/a/test"})
    public String mavenTest() {
        System.out.println("this is a test a!");
        return "ok";
    }
}
