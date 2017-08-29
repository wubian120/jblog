package com.brianwu.jblog.biz.basic;

import com.brianwu.jblog.api.basic.UserService;
import com.brianwu.jblog.api.domain.User;
import com.brianwu.jblog.dao.basic.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {

        return userMapper.getAllUsers();


    }

    @Override
    public User getUserById(long id) {

        return userMapper.getUserById(id);

    }



}
