package com.icbc.sh.service.impl;

import com.icbc.sh.test.WebTester;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class TestSysparServiceImplTest extends WebTester {

    @Autowired
    TestSysparServiceImpl testSysparService;

    @Test
    public void getSysdate() {
        log.info(testSysparService.getSysdate());
    }
}