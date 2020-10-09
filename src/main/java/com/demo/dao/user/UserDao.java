package com.demo.dao.user;

import com.demo.dao.base.BaseDao;
import com.demo.entity.user.User;

public interface UserDao extends BaseDao<User> {

    User selectByUserName(String username);
}