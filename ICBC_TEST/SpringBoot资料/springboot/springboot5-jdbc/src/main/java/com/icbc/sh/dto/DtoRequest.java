package com.icbc.sh.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class DtoRequest {
    @NotBlank(message = "参数名不能为空")
    private String parName;

    private String parValue;

    private String parDesc;

}
