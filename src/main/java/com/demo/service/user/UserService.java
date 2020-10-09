package com.demo.service.user;

import com.demo.entity.user.User;
import com.demo.service.base.BaseService;

public interface UserService extends BaseService<User> {

    User selectByUserName(String username);
}
