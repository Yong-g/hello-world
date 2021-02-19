package com.briup.serivce.user;

import com.briup.bean.user.User;
import com.briup.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSerivceImpl implements UserSerivce{

    @Autowired
    private UsersDao userDao;
    @Override
    public List<User> findAll() {
       return userDao.findAll();
    }

    @Override
    public User findById(String mobile) {
        Optional<User> user = userDao.findById(mobile);
        return user.isPresent() ? user.get(): null;
    }

    @Override
    public User findOne(User user) {
        Optional<User> one = userDao.findOne(Example.of(user));
        return one.isPresent() ? one.get(): null;
    }

    @Override
    public String save(User user) {
        User save = userDao.save(user);
        return save.getMobileNumber();
    }

}
