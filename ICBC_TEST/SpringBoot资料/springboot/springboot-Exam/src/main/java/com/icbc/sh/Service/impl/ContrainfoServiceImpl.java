package com.icbc.sh.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icbc.sh.Service.ContrainfoService;
import com.icbc.sh.entity.Contractinfo;
import com.icbc.sh.mapper.ContrainfoMapper;
import org.springframework.stereotype.Service;

@Service
public class ContrainfoServiceImpl extends ServiceImpl<ContrainfoMapper, Contractinfo> implements ContrainfoService {
    //与标准相比少了很多 随便写写算求了
}
