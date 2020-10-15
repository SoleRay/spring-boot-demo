package com.demo.config.security;

import com.alibaba.fastjson.JSON;
import com.demo.bean.session.SessionUser;
import com.demo.util.Constants;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
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
//    private SecurityAuthenticationProvider securityAuthenticationProvider;

//    @Autowired
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
                .antMatchers("/box/**").hasIpAddress("127.0.0.1")//来自127.0.0.1的请求，如果匹配到"/box",那就可以不登录,直接访问
                .and().authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()//浏览器中输入，http://localhost:8081/spring-boot-demo/login，默认登陆页
                //.loginPage("mylogin.html") //自定义登录页，使用自定义登陆界面以后，登出界面就要重新定义
                .loginProcessingUrl("/login")//登陆的post接口
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        //登陆成功处理，如果前后端分离，可以直接用于json返回

                        /**
                         * 1.自定义userDetailsService时，Principal = UserDetails
                         * 2.自定义AuthenticationProvider，Principal 由用户自定义。
                         */
                        request.getSession().setAttribute(Constants.SESSION_USER,authentication.getPrincipal());

                        String json = "{\"code\": 0,\"message\": \"ok\"}";
                        response.setContentType("text/json; charset=utf-8");
                        response.getWriter().print(JSON.toJSON(json));
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
     * 自定义userDetailsService时，需要配置
     */
    @Bean
    protected PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(11);
    }


    /**
     *  想要使用数据库来进行验证。有以下几种方式：
     *  1.自定义userDetailsService，实现loadUserByUsername()方法，Spring Security默认使用DaoAuthenticationProvider
     *  2.自定义AuthenticationProvider，实现authenticate()方法。
     *
     *  需要注意的是：DaoAuthenticationProvider默认返回的是UsernamePasswordAuthenticationToken，
     *  它的principal，默认是自定义userDetailsService返回的对象，默认为UserDetails接口的子类
     *
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //1.自定义userDetailsService，只控制从数据库获取用户的流程，默认流程走DaoAuthenticationProvider
        auth.userDetailsService(securityUserDetailsService);

        //2.自定义AuthenticationProvider，控制整个认证流程
//        auth.authenticationProvider(securityAuthenticationProvider);
    }
}
