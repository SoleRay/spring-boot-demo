package com.demo.controller.box;

import com.demo.bean.session.SessionUser;
import com.demo.util.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/hi")
public class HiController {


    @GetMapping
    public String sayHi(HttpSession session){
        SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_USER);
        System.out.println(sessionUser.getUsername());
        return "hi";
    }
}
