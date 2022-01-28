package com.icbc.sh.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class SpringbootDemoDtoResp {

    private String code;
    private String data;



}
