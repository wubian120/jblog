package com.brianwu.jblog.api.basic;

import com.brianwu.jblog.api.domain.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();

    User getUserById(long id);

}
