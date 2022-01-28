package com.icbc.sh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ServiceA {

    @Autowired
    private ServiceB serviceB;

    public void process(){
        log.info("Service A works");
    }
    @Async
    public void processB(){
    }
}
