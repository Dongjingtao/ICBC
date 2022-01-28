package com.icbc.sh.exception;

public enum MyExceptionEnum {

    OK("0","成功"),
    UNKNOW_ERROR("9999","未知错误(初始错误)"),
    DATA_CHECK_ERROR("1001","数据上送异常(初始)"),
    DB_OPER_ERROR("2000","数据库操作失败");

    private String code;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private String msg;

    MyExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
