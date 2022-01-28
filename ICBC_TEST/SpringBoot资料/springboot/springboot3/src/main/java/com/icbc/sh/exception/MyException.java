package com.icbc.sh.exception;

/**
 * 项目名称：fpalntln-web 类名称：LntiCommonException 类描述：
 *
 * @author kfzx-wangz1
 * @date 2017年11月10日 下午5:34:35
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 2769973279901633808L;
    private String errCode;
    private String errMsg;

    public MyException(String errCode, String msg) {
        this.errCode = errCode;
        this.errMsg = msg;
    }

    public MyException(MyExceptionEnum exceptionEnum) {
        this.errCode = exceptionEnum.getCode();
        this.errMsg = exceptionEnum.getMsg();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    @Override
    public String toString() {
        return "KcqException{" +
                "errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
