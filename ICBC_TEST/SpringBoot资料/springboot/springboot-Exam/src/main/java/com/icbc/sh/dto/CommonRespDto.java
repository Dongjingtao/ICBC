package com.icbc.sh.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommonRespDto {
  @NotBlank(message = "参数名不能为空")
  private String retCode;
  @NotBlank(message = "参数名不能为空")//为什么有notblank
  private String retMsg;

  private String time;

  public CommonRespDto(String retCode, String retMsg) {
    this.retCode = retCode;
    this.retMsg = retMsg;
  }

  public CommonRespDto(String retCode, String retMsg, String time) {
    this.retCode = retCode;
    this.retMsg = retMsg;
    this.time = time;
  }
}
