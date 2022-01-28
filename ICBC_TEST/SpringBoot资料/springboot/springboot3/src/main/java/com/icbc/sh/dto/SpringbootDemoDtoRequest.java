package com.icbc.sh.dto;


import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Trade")
public class SpringbootDemoDtoRequest {
    @Length(min = 1,max = 10,message = "用户id长度错误")
    @XmlElement(name = "UserId")
    private String userId;

    @Pattern(regexp="(^1[3|4|5|6|7|8|9][0-9]{9})|(99999999999)$",message="请输入正确的手机号")
    @XmlElement(name = "PhoneNo")
    private String phoneNo;

    @XmlTransient
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlTransient
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
