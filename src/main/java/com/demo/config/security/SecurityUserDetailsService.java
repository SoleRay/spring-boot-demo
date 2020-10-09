package com.demo.config.security;

import com.demo.entity.user.User;
import com.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectByUserName(username);

        if (user == null) {
            return null;
        }

        return new SecurityUserDetail(user.getUsername(),user.getPassword(), Collections.singletonList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "xxxx";
            }
        }));
    }
}
