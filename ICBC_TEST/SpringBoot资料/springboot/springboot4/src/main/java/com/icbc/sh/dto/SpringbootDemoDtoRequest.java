package com.icbc.sh.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class SpringbootDemoDtoRequest {
    @NotBlank(message = "用户id必输")
    @Length(min = 1,max = 10,message = "用户id长度不正确")
    private String userId;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp="(^1[3|4|5|6|7|8|9][0-9]{9})|(99999999999)$",message="请输入正确的手机号")
    private String phoneNo;



}
