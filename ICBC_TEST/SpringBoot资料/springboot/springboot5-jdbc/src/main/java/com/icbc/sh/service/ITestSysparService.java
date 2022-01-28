package com.icbc.sh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.icbc.sh.dto.DtoRequestTransactional;
import com.icbc.sh.entity.TestSyspar;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shfh-yangc02
 * @since 2021-09-01
 */
public interface ITestSysparService extends IService<TestSyspar> {

    String getSysdate();

    void batchInsert(DtoRequestTransactional dto);
}
