package com.icbc.sh.controller;


import com.icbc.sh.dto.SpringbootDemoDtoRequest;
import com.icbc.sh.dto.SpringbootDemoDtoResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PostOnlyController {

    @RequestMapping(
            value = {"/springboot/test/post"},
            method = {org.springframework.web.bind.annotation.RequestMethod.POST},
            produces = "application/json", consumes = "application/json")
    public SpringbootDemoDtoResp mavenTest(@RequestBody @Validated SpringbootDemoDtoRequest requestDto, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            return SpringbootDemoDtoResp.builder().
                    code("9999").
                    data("校验失败"+bindResult.getFieldError().getDefaultMessage()).build();
        }
        log.info("上送postBody:{}",requestDto.toString());
        return SpringbootDemoDtoResp.builder().
                code("0000").
                data("ok").build();
    }
}
