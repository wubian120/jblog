package com.brianwu.jblog.dao.basic;

import com.brianwu.jblog.api.domain.User;

import java.util.List;

public interface UserMapper {

    User getUserById(long id);

    int insertUser(User user);

    int updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

}
