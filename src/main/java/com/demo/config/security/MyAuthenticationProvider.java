package com.demo.config.security;

import com.demo.entity.user.User;
import com.demo.service.user.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyAuthenticationProvider implements AuthenticationProvider {

    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();

        /** 问题：这个密码是明文还是密文？
         *  应该是密文，是没有进行过摘要算法的密文
         *  这个密文就是防程序员的
         */
        String rawPassword = authentication.getCredentials().toString();

        User user = userService.selectByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(rawPassword,user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username,user.getPassword(),user.getAuthorities());
        }else {
            throw new BadCredentialsException("密码错误！！");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
