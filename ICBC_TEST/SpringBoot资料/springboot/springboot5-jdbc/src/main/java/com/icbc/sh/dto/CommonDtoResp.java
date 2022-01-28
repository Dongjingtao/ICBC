package com.icbc.sh.dto;

import lombok.Data;

@Data
public class CommonDtoResp<T> {

    private String code;
    private String msg;

    private T data;

    public CommonDtoResp(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CommonDtoResp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
