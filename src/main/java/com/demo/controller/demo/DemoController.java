package com.demo.controller.demo;


import com.demo.anno.ValidateSign;
import com.demo.bean.result.Result;
import com.demo.dto.param.demo.DemoParamDTO;
import com.demo.dto.result.demo.DemoResultDTO;
import com.demo.entity.demo.Demo;
import com.demo.properties.demo.PropDemo;
import com.demo.service.demo.DemoService;
import com.demo.util.resp.ResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/demo")
public class DemoController {

    private static final Logger logger = LogManager.getLogger(DemoController.class);

    @Resource
    private DemoService demoService;

    @Resource
    private PropDemo propDemo;

    @ValidateSign
    @RequestMapping(value="/get",method= RequestMethod.POST)
    @ResponseBody
    public Result upload(DemoParamDTO param) throws Exception{

        Demo demo = demoService.selectByPrimaryKey(param.getId());

        DemoResultDTO dto = new DemoResultDTO();
        dto.setId(demo.getId());
        dto.setCreateDate(demo.getCreateDate());


        logger.info(propDemo.getName());
        return ResponseUtil.setSuccessDataResponse(dto);
    }
}
