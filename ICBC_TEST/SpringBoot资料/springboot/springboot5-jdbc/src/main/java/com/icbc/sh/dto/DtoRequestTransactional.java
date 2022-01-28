package com.icbc.sh.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DtoRequestTransactional {
    @NotBlank(message = "参数名不能为空")
    private String parName1;

    private String parValue1;

    private String parDesc1;

    @NotBlank(message = "参数名不能为空")
    private String parName2;

    private String parValue2;

    private String parDesc2;

}
