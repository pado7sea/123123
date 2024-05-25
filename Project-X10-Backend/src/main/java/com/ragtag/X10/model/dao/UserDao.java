package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.TodoList;
import com.ragtag.X10.model.dto.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);

    User checkUser(String userId);

    int updateUser(User user);

    int updateUserImg(User user);

    boolean checkLeader(String userId);

    List<User> selectByUserId(String keyword);

    User selectUser(String userId);

    int deleteUser(String userId);

    int updateExp(User user);
}
