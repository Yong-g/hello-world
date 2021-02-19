package com.briup.controller;

import com.briup.bean.user.User;
import com.briup.common.respose.SimpleRespose;
import com.briup.serivce.user.UserSerivce;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;

    @PostMapping("create")
    @ResponseBody
    private Object add(@RequestBody User user){
        /**
         * 1.先做存在性校验
         * 2.做客户化校验
         * 3.存入数据库
         */

    /*if (StringUtils.isEmpty(user.getRegisterCode())){
        return new SimpleRespose(null,"邀请码为空","1");
    }
    if (!checkRegisterCode(user.getRegisterCode())){
        return new SimpleRespose(null,"邀请码不存在","1");
    }*/
    User byId = userSerivce.findById(user.getMobileNumber());
    if (null != byId){
        return new SimpleRespose(null, "该手机号已被注册", "1");
    }
    String save = userSerivce.save(user);
    if (StringUtils.isEmpty(save)) {
    return new SimpleRespose(null, "注册失败", "1");
    }
        return new SimpleRespose(null,"注册成功","0");
    }


    @GetMapping("checkMobileNumber")
    @ResponseBody
    private Object checkMobileNumber(@RequestParam String mobileNumber){
        User byId = userSerivce.findById(mobileNumber);
        if (null != byId){
            return new SimpleRespose(null, "该手机号已被注册", "1");
        }
        return new SimpleRespose(null,null,"0");
    }
    @PostMapping("search")
    @ResponseBody
    private Object search(@RequestBody User user){
        return userSerivce.findOne(user);
    }
    private boolean checkRegisterCode(String registerCode){
        User user = new User();
        user.setRegisterCode(registerCode);
        User one = userSerivce.findOne(user);
        return null == one ? true : false;
    }

}
