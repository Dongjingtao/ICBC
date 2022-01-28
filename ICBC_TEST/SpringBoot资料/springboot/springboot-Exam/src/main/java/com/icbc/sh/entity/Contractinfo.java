package com.icbc.sh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("Contractinfo")
public class Contractinfo {//为什么没有黄色的table filed
  private String contraId;
  private String groupId;
  private String groupNamec;
  private String groupNamee;
  private String accNo;
  private String cisNo;
  private String orng;
  private String status;
  private String signDate;
  private String signtime;
  private String generationTime;
}
