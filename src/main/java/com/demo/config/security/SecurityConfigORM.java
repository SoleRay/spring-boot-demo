package com.demo.config.security;

import com.demo.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

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

        //这种方式适合单机或者集群的，分布式不用这种方式
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin()//浏览器中输入，http://localhost:8081/spring-boot-demo/login，默认登陆页
                //.loginPage("mylogin.html") //自定义登录页
                .loginProcessingUrl("/login")//登陆的post接口
                .defaultSuccessUrl("/")//登陆成功后的页面
                .failureUrl("/login.html?error")//登陆失败后，统一跳转的页面，如果需要根据失败原因跳转不同页面，配置failureHandler
                .failureHandler(new AuthenticationFailureHandler() { //登陆失败后的处理，可以根据不同的错误原因跳转不同的页面
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

                        //记录失败次数

                        //根据失败原因跳转到不同的页面
                        if(e instanceof UsernameNotFoundException){
                            request.getRequestDispatcher("/userNameError.html").forward(request,response);
                        }else if(e instanceof BadCredentialsException){

                        }

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
