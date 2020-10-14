package com.demo.config.security;

import com.alibaba.fastjson.JSON;
import com.demo.util.Constants;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfigORM extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityAuthenticationProvider securityAuthenticationProvider;

    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        //静态资源放行，建议在这里配，这里是第一层。

        //不需要登录就可以访问静态资源
        web.ignoring().antMatchers("/img/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/box/**").hasIpAddress("127.0.0.1");//来自127.0.0.1的请求，如果匹配到"/box",那就可以不登录,直接访问

        //这种方式适合单机或者集群的，分布式不用这种方式
        http.authorizeRequests()
                .anyRequest().authenticated()//所有请求都需要认证，这个和下面放行匹配是冲突的
                .and().formLogin()//浏览器中输入，http://localhost:8081/spring-boot-demo/login，默认登陆页
                //.loginPage("mylogin.html") //自定义登录页，使用自定义登陆界面以后，登出界面就要重新定义
                .loginProcessingUrl("/login")//登陆的post接口
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        //登陆成功处理，如果前后端分离，可以直接用于json返回

                        String json = "{\"code\": 0,\"message\": \"ok\"}";
                        response.setContentType("text/json; charset=utf-8");
                        response.getWriter().print(JSON.toJSON(json));

                        //存放到session中
                        SecurityUserDetail userDetail = (SecurityUserDetail) authentication.getPrincipal();
                        request.getSession().setAttribute(Constants.SESSION_USER,userDetail);

                    }
                })
//                .defaultSuccessUrl("/")//登陆成功后的页面
//                .failureUrl("/login.html?error")//登陆失败后，统一跳转的页面，如果需要根据失败原因跳转不同页面，配置failureHandler
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

                        /**
                         * 登陆失败后的处理，可以
                         *    1.根据不同的错误原因跳转不同的页面
                         *    2.打印失败信息
                         *    3.统计失败次数
                         */

                        String msg = "error";
                        //根据失败原因跳转到不同的页面
                        if(e instanceof UsernameNotFoundException){
                            msg = e.getMessage();
                        }else if(e instanceof BadCredentialsException){
                            msg = e.getMessage();
                        }
                        String json = "{\"code\": 1,\"message\": \""+msg+"\"}";
                        response.setContentType("text/json; charset=utf-8");
                        response.getWriter().print(JSON.toJSON(json));
                    }
                })
                .and().logout().addLogoutHandler(new LogoutHandler() {//可以加好几个handler
            @Override
            public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                //在登出处理中，可以进行一些资源清理。
            }
        })
                .and().csrf().disable();//巨坑：重写configure以后，默认开启了csrf，拦截所有的post请求。如不配置csrf，必须关闭。

    }



    /**
     * 权限管理
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //用了自定义的UserDetailsService以后，就脱离了security自带的UserDetailsService
        auth.userDetailsService(securityUserDetailsService)
        .and().authenticationProvider(securityAuthenticationProvider);
    }
}
