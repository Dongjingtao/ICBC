package com.icbc.sh.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BController {
    @RequestMapping(value = {"/b/test"})
    public String mavenTest() {
        System.out.println("this is a test b!");
        return "ok";
    }
}
