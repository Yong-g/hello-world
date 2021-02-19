package com.briup.controller;

import com.briup.bean.user.User;
import com.briup.dao.UsersDao;
import com.briup.serivce.user.UserSerivce;
import org.dom4j.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("login/")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);
    @Autowired
    private UserSerivce userSerivce;
    @Autowired
    private UsersDao usersDao;

    @PostMapping("loginIn")
    @ResponseBody
    private Object login(@RequestBody User user,HttpServletRequest request){
        User one = userSerivce.findOne(user);
        if (null != one ){
            request.getSession().setAttribute("isLogin","Y");
        }
        return one;
    }
}
