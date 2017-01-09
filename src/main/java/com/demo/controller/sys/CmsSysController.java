package com.demo.controller.sys;

import com.demo.bean.resp.Resp;
import com.demo.bean.result.Result;
import com.demo.exception.BusinessException;
import com.demo.service.sys.CmsSysService;
import com.demo.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Arthur on 2016/12/24 0024.
 */
@Controller
@RequestMapping("/sys")
public class CmsSysController {

    private static Logger logger = Logger.getLogger(CmsSysController.class);

    @Resource
    private CmsSysService cmsSysServie;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Result login(String loginName, String password, ServletRequest request){
        Result result = new Result();
        try {
            cmsSysServie.login(loginName,password);
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
            session.setAttribute(Constants.SESSION_KEY,Constants.SESSION_VALUE);
            result.setCode(Resp.SUCCESS);
            result.setMsg("登陆成功！");
        }catch (BusinessException be){
            result.setCode(Resp.FAIL);
            result.setMsg("登陆失败："+be.getMessage());
        }catch (Exception e) {
            result.setCode(Resp.FAIL);
            result.setMsg(Resp.SYS_ERROR);
            e.printStackTrace();
        }

        return result;
    }
}
