package com.erp.controller;

import com.erp.model.User;
import com.erp.service.sys.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shuai on 2016/4/10.
 */
@Controller
@RequestMapping("/login")
public class LoginCtrl {
    @Autowired
    private UserService userService;

    @RequestMapping("/init.do")
    public String preLogin(User user){
        System.out.println("login---------------------");
        return "sys/login";
    }

    @RequestMapping("/login.do")
    public String login(User user){
        System.out.println("login---------------------");
        if(user !=null && StringUtils.isEmpty(user.getUsername()) && StringUtils.isEmpty(user.getPassword())){
            return "sys/login";
        }
        if(userService.select(user)){
            return "sys/index";
        }
        return "sys/login";
    }

}
