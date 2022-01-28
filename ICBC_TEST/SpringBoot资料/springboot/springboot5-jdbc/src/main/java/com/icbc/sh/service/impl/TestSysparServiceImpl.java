package com.icbc.sh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icbc.sh.dto.DtoRequestTransactional;
import com.icbc.sh.entity.TestSyspar;
import com.icbc.sh.mapper.TestSysparMapper;
import com.icbc.sh.service.ITestSysparService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shfh-yangc02
 * @since 2021-09-01
 */
//@Scope("prototype")
@Service
public class TestSysparServiceImpl extends ServiceImpl<TestSysparMapper, TestSyspar> implements ITestSysparService {

    @Resource
    private TestSysparMapper testSysparMapper;

    @Override
    public String getSysdate() {
        return testSysparMapper.getSysdateWithDash();
    }

    @Transactional
    @Override
    public void batchInsert(DtoRequestTransactional dto) {
       TestSyspar insertEntity1 = new TestSyspar();
        insertEntity1.setParvalue(dto.getParValue1());
        insertEntity1.setParname(dto.getParName1());
        insertEntity1.setPardesc(dto.getParDesc1());


        TestSyspar insertEntity2 = new TestSyspar();
        insertEntity2.setParvalue(dto.getParValue2());
        insertEntity2.setParname(dto.getParName2());
        insertEntity2.setPardesc(dto.getParDesc2());

        save(insertEntity1);
        save(insertEntity2);

    }
}
