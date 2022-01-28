package com.icbc.sh.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.icbc.sh.dto.CommonDtoResp;
import com.icbc.sh.dto.DtoRequest;
import com.icbc.sh.dto.DtoRequestTransactional;
import com.icbc.sh.entity.TestSyspar;
import com.icbc.sh.service.impl.TestSysparServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
public class AController {

    @Autowired
    TestSysparServiceImpl testSysparService;

    @RequestMapping(value = {"/a/get"},method = RequestMethod.GET)
    public CommonDtoResp get(@RequestParam(value = "parValueRequest") String parName) {
        List<TestSyspar> testSysparList = testSysparService.list(new LambdaQueryWrapper<TestSyspar>().eq(TestSyspar::getParname,parName));
        log.info(testSysparList.toString());

        return new CommonDtoResp<>("0000","成功",testSysparList);
    }
    @RequestMapping(value = {"/a/getdate"},method = RequestMethod.GET)
    public CommonDtoResp getDate() {
        String date  = testSysparService.getSysdate();
        log.info("date:{}",date);

        return new CommonDtoResp<>("0000","成功",date);
    }
    @RequestMapping(value = {"/a/post"},method = RequestMethod.POST)
    public CommonDtoResp post(@RequestBody @Valid DtoRequest request) {
        TestSyspar testSyspar = new TestSyspar();
        testSyspar.setPardesc(request.getParDesc());
        testSyspar.setParname(request.getParName());
        testSyspar.setParvalue(request.getParValue());

        testSysparService.save(testSyspar);
        return new CommonDtoResp<>("0000","成功");
    }
    @RequestMapping(value = {"/a/delete"},method = RequestMethod.POST)
    public CommonDtoResp delete(@RequestBody @Valid DtoRequest request) {
        testSysparService.remove(new LambdaQueryWrapper<TestSyspar>().eq(TestSyspar::getParname,request.getParName()));
        return new CommonDtoResp<>("0000","成功");
    }
    @RequestMapping(value = {"/a/update"},method = RequestMethod.POST)
    public CommonDtoResp update(@RequestBody @Valid DtoRequest request) {
        testSysparService.update(new LambdaUpdateWrapper<TestSyspar>().
                eq(TestSyspar::getParname,request.getParName()).
                set(TestSyspar::getPardesc,request.getParDesc()).
                set(TestSyspar::getParvalue,request.getParValue()));

        return new CommonDtoResp<>("0000","成功");
    }

    @RequestMapping(value = {"/a/transactional"},method = RequestMethod.POST)
    public CommonDtoResp update(@RequestBody @Valid DtoRequestTransactional request) {
        testSysparService.batchInsert(request);
        return new CommonDtoResp<>("0000","成功");
    }
}
