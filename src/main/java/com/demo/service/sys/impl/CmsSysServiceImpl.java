package com.demo.service.sys.impl;

import com.demo.exception.BusinessException;
import com.demo.service.sys.CmsSysService;
import com.demo.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Arthur on 2016/12/24 0024.
 */
@Service
public class CmsSysServiceImpl implements CmsSysService {

    @Override
    public void login(String loginName, String password) {
        if(StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)){
            throw new BusinessException("用户名或密码不能为空");
        }
        if(!Constants.USER_NAME.equals(loginName.trim())){
            throw new BusinessException("用户名不存在！");
        }
        if(!Constants.USER_PASSWORD.equals(password.trim())){
            throw new BusinessException("密码不正确！");
        }
    }
}
