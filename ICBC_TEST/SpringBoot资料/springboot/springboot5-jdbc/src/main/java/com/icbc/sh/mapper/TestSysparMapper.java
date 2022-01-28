package com.icbc.sh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icbc.sh.entity.TestSyspar;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shfh-yangc02
 * @since 2021-09-01
 */
public interface TestSysparMapper extends BaseMapper<TestSyspar> {

    @Select("select to_char(sysdate,'yyyy-mm-dd') from dual")
    String getSysdateWithDash();
}
