package com.demo.controller.demo;


import com.demo.anno.ValidateSign;
import com.demo.bean.result.Result;
import com.demo.dto.param.demo.DemoParamDTO;
import com.demo.dto.result.demo.DemoResultDTO;
import com.demo.service.demo.DemoService;
import com.demo.util.resp.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @ValidateSign
    @RequestMapping(value="/get",method= RequestMethod.POST)
    @ResponseBody
    public Result upload(DemoParamDTO param) throws Exception{

        return ResponseUtil.setSuccessDataResponse(new DemoResultDTO());
    }
}
