package com.demo.controller.demo;


import com.demo.anno.ValidateSign;
import com.demo.bean.result.Result;
import com.demo.dto.request.demo.DemoListReqDTO;
import com.demo.dto.response.page.PageListRespDTO;
import com.demo.properties.demo.PropDemo;
import com.demo.service.demo.DemoService;
import com.demo.util.resp.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private PropDemo propDemo;

    @ValidateSign
    @PostMapping(value="/getAllDemos",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result getAllDemos(@RequestBody DemoListReqDTO param, @RequestHeader(value = "userId", required = false) long userId){
        PageListRespDTO pageList = demoService.getAllDemos(userId,param.getPageNum(), param.getPageSize());
        return ResponseUtil.setSuccessDataResponse(pageList);
    }

    @ValidateSign
    @PostMapping(value="/getDemoList",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result getDemoList(@RequestBody DemoListReqDTO param, @RequestHeader(value = "token", required = false) long userId){

        PageListRespDTO pageList = demoService.getDemoList(userId,param.getPageNum(), param.getPageSize());
        return ResponseUtil.setSuccessDataResponse(pageList);
    }
}
