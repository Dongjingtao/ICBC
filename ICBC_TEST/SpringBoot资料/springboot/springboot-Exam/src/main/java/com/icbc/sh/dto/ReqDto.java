package com.icbc.sh.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReqDto {
  @NotBlank(message = "参数名不能为空")
  private String contraid;

}
