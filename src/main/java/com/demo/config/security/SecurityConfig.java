package com.demo.config.security;

import com.demo.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //静态资源放行，建议在这里配，这里是第一层。

        //不需要登录就可以访问静态资源
        web.ignoring().antMatchers("/img/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //这种方式适合单机或者集群的，分布式不用这种方式
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")//登陆成功后的页面
                .failureForwardUrl("/login.html?error")//登陆失败后的页面
                .failureHandler(new AuthenticationFailureHandler() { //登陆失败的所有需求都可以在这里做
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

                        //记录失败次数

                        //根据失败原因跳转到不同的页面
                        if(e instanceof UsernameNotFoundException){

                        }else if(e instanceof BadCredentialsException){

                        }

                    }
                }).and().rememberMe();//实现记住我的功能

    }


    /**
     * 权限管理
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //用了自定义的UserDetailsService以后，就脱离了security自带的UserDetailsService
        auth.userDetailsService(getSecurityUserDetailsService())
        .and().authenticationProvider(new SecurityAuthenticationProvider());
    }

    @Bean
    protected SecurityUserDetailsService getSecurityUserDetailsService(){
        return new SecurityUserDetailsService();
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }

    /** 1.spring security提供的user只有用户名和密码，如果要增加age，gender之类的字段，该怎么做？
     *  答：继承User类，或者实现UserDetail接口。
     *
     *  2.如果要使用数据库，需要做什么？
     *  答：1.需要加spring-boot-start-jdbc这个包，并且配置文件配置好。
     *     2.在spring-security-core包的userdetails.jdbc目录下，有个users.ddl的sql文件，需要使用他来创建表
     *
     *  3.如果需要使用orm框架，并且使用自定义的用户表，该如何做?
     *  答：1的步骤要做到，然后在configure方法里，使用
     */

    @Bean
    protected UserDetailsService getUserDetailsService(DataSource dataSource){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//        manager.loadUserByUsername(username);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String username = "box";
//        String pwd = new BCryptPasswordEncoder().encode("123456");
//        User user = new User(username,pwd,true,true,true,true, Collections.singletonList(new SimpleGrantedAuthority("bbb"));
//        manager.createUser(user);
        manager.createUser(User.withUsername("Mike").password(encoder.encode("2222")).roles("aaa").build());


        return manager;
    }
}
