package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.TodoList;
import com.ragtag.X10.model.dto.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);

    User checkUser(User user);

    int updateUser(User user);

    boolean checkLeader(String userId);

    List<User> selectByUserId(String userId);

    User selectUser(String userId);

    int deleteUser(String userId);
}
