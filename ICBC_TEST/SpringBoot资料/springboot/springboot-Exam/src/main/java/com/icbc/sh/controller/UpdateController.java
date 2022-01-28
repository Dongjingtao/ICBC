package com.icbc.sh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icbc.sh.Service.impl.ContrainfoServiceImpl;
import com.icbc.sh.dto.CommonRespDto;
import com.icbc.sh.dto.ReqDto;
import com.icbc.sh.entity.Contractinfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class UpdateController {
  @Autowired
  private ContrainfoServiceImpl contrainfoService;

  @RequestMapping(value = {"/update"},method = RequestMethod.POST)
  public CommonRespDto update(@RequestBody @Valid ReqDto reqDto) {
    QueryWrapper<Contractinfo> wrapper = new QueryWrapper<Contractinfo>();
    wrapper = wrapper.eq("CONTRAID",reqDto.getContraid());// getcontraid 这个方法没有定义？？？
    Contractinfo contractinfo = new Contractinfo();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    if(contrainfoService.list(wrapper).size()==0) {//.list是什么方法？？？
      BufferedReader bf = null;
      try {
        bf = new BufferedReader(new FileReader("contractinfo.csv"));
        String temp1;
        while ((temp1=bf.readLine()) != null){
          String[] temp = temp1.split(",");
          if(temp[2].equals(reqDto.getContraid())){
            contractinfo.setContraId(temp[2]);//set方法哪里来的？？？
            contractinfo.setGroupId(temp[3]);
            contractinfo.setGroupNamec(temp[4]);
            contractinfo.setGroupNamee(temp[5]);
            contractinfo.setAccNo(temp[6]);
            contractinfo.setCisNo(temp[7]);
            contractinfo.setOrng(temp[8]);
            contractinfo.setStatus(temp[9]);
            contractinfo.setSignDate(temp[10]);
            contractinfo.setSigntime(temp[11]);
            contractinfo.setGenerationTime(df.format(new Date()));
            contrainfoService.save(contractinfo);
            return new CommonRespDto("200", "插入成功");//200什么意思？？？
          }
        }
      } catch (FileNotFoundException e) {
        System.err.println("FileNotFoundException");
      } catch (IOException e) {
        System.err.println("IOException");
      } finally {
        try {
          assert bf != null;
          bf.close();
        } catch (IOException e) {
          System.err.println("IOException");
        }
      }
      return new CommonRespDto("300", "该contractId不存在!");//是不是少了else
    }else{
      return new CommonRespDto("302","已存在,插入时间:",contrainfoService.getOne(wrapper).getSigntime());
    }
  }
}
