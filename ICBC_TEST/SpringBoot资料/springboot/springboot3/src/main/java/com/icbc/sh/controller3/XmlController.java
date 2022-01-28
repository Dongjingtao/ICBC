package com.icbc.sh.controller3;

import com.icbc.sh.dto.SpringbootDemoDtoRequest;
import com.icbc.sh.dto.SpringbootDemoDtoResp;
import com.icbc.sh.exception.MyException;
import com.icbc.sh.exception.MyExceptionEnum;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlController {
    @RequestMapping(
            value = {"/springboot/test/xml"},
            method = {org.springframework.web.bind.annotation.RequestMethod.POST},
            produces = "application/xml", consumes = "application/xml")
    public SpringbootDemoDtoResp testMaven(@RequestBody @Validated SpringbootDemoDtoRequest requestDto, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            throw new MyException(MyExceptionEnum.DATA_CHECK_ERROR.getCode(),bindResult.getFieldError().getDefaultMessage());
        }
        //业务逻辑
        return SpringbootDemoDtoResp.builder().
                code("0000").
                data("ok").build();
    }
}
