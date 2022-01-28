package com.icbc.sh.exception;

import com.icbc.sh.dto.SpringbootDemoDtoResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * CONTROLLER的异常统一处理
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public SpringbootDemoDtoResp xmlErrorHandler(Exception e) {

        if(e instanceof MyException) {
            MyException myException = (MyException) e;
            log.error("异常返回代码:{},返回信息:{}", myException.getErrCode(), myException.getErrMsg());
            return SpringbootDemoDtoResp.builder().
                    code(myException.getErrCode()).
                    data(myException.getErrMsg()).build();
        }else {
            return SpringbootDemoDtoResp.builder().
                    code("9999").
                    data(e.getMessage()).build();
        }
    }

}
