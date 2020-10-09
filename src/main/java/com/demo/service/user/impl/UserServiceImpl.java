package com.demo.service.user.impl;

import com.demo.dao.user.UserDao;
import com.demo.entity.user.User;
import com.demo.service.base.impl.BaseServiceImpl;
import com.demo.service.user.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

    @Override
    public User selectByUserName(String username) {
        return baseDao.selectByUserName(username);
    }
}
