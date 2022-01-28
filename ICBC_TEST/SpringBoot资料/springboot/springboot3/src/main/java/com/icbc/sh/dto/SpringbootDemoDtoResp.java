package com.icbc.sh.dto;

import lombok.Builder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Trade")
@Builder
public class SpringbootDemoDtoResp {
    @XmlElement(name = "Code")
    private String code;
    @XmlElement(name = "Data")
    private String data;

    public SpringbootDemoDtoResp( ) {

    }

    public SpringbootDemoDtoResp(String code, String data) {
        this.code = code;
        this.data = data;
    }

    @XmlTransient
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    @XmlTransient
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SpringbootDemoDtoResp{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
