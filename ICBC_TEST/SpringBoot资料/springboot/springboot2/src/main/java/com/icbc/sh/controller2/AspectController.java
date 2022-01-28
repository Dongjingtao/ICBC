package com.icbc.sh.controller2;

import com.icbc.sh.dto.SpringbootDemoDtoRequest;
import com.icbc.sh.dto.SpringbootDemoDtoResp;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AspectController {
    @RequestMapping(
            value = {"/springboot/test/aspect"},
            method = {org.springframework.web.bind.annotation.RequestMethod.POST},
            produces = "application/json", consumes = "application/json")
    public SpringbootDemoDtoResp mavenTest(@RequestBody @Validated SpringbootDemoDtoRequest requestDto, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            return SpringbootDemoDtoResp.builder().
                    code("9999").
                    data("校验失败"+bindResult.getFieldError().getDefaultMessage()).build();
        }
        //业务逻辑 start
        //TODO
        //业务逻辑 end
        return SpringbootDemoDtoResp.builder().
                code("0000").
                data("ok").build();
    }
}
