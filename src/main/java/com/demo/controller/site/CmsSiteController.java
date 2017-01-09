package com.demo.controller.site;

import com.demo.bean.resp.Resp;
import com.demo.bean.result.Result;
import com.demo.entity.site.CmsSite;
import com.demo.exception.BusinessException;
import com.demo.service.site.CmsSiteService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Arthur on 2016/12/24 0024.
 */
@Controller
@RequestMapping("/site")
public class CmsSiteController {

    private static Logger logger = Logger.getLogger(CmsSiteController.class);

    @Resource
    private CmsSiteService cmsSiteService;

    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public Result list(){
        Result result = new Result();
        try {
            List<CmsSite> sites = cmsSiteService.selectAll();
            result.setInfo("hello");
            result.setData(sites);
            result.setCode(Resp.SUCCESS);
            result.setMsg("获取站点列表成功！");
        }catch (BusinessException be){
            result.setCode(Resp.FAIL);
            result.setMsg("获取站点列表失败："+be.getMessage());
        }catch (Exception e) {
            result.setCode(Resp.FAIL);
            result.setMsg(Resp.SYS_ERROR);
            e.printStackTrace();
        }

        return result;
    }
}
