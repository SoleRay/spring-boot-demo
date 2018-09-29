package com.demo.controller.demo;


import com.demo.anno.ValidateSign;
import com.demo.bean.result.Result;
import com.demo.dto.request.demo.DemoReqDTO;
import com.demo.dto.response.demo.DemoRespDTO;
import com.demo.entity.demo.Demo;
import com.demo.properties.demo.PropDemo;
import com.demo.service.demo.DemoService;
import com.demo.util.resp.ResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private static final Logger LOG = LogManager.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @Autowired
    private PropDemo propDemo;

    @ValidateSign
    @PostMapping(value="/get",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result get(@RequestBody DemoReqDTO param,@RequestHeader(value = "token", required = false) String token){

        Demo demo = demoService.selectByPrimaryKey(param.getId());

        DemoRespDTO dto = new DemoRespDTO();
        dto.setId(demo.getId());
        dto.setCreateDate(demo.getCreateDate());


        LOG.info(propDemo.getName());
        return ResponseUtil.setSuccessDataResponse(dto);
    }
}
