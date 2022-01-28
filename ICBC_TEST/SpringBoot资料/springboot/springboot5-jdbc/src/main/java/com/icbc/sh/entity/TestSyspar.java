package com.icbc.sh.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shfh-yangc02
 * @since 2021-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("TEST_SYSPAR")
public class TestSyspar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("PARNAME")
    private String parname;

    @TableField("PARVALUE")
    private String parvalue;

    @TableField("PARDESC")
    private String pardesc;


}
