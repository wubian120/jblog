package com.brianwu.jblog.server.web;

import com.brianwu.jblog.api.basic.UserService;
import com.brianwu.jblog.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/u",method = RequestMethod.GET)
    public List<User> getAllUsers(){

        List<User> users = userService.getAllUsers();

        return users;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "hello jblog";
    }

}
