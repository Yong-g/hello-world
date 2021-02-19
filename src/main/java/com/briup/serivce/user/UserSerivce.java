package com.briup.serivce.user;

import com.briup.bean.user.User;

import java.util.List;

public interface UserSerivce {

    List<User> findAll();

    User findById(String mobile);

    User findOne(User user);

    String save(User user);
}
