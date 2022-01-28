package com.icbc.sh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ServiceB {
    @Autowired
    private ServiceA serviceA;


}
