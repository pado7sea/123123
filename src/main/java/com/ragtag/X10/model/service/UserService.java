package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.User;

import java.util.List;

public interface UserService {
    int signUpUser(User user);

    User loginUser(User user);

    int modifyUser(User user);

    boolean isLeader(String userId);

    List<User> searchUser(String keyword);

    User userInfo(String userId);

    int deleteUser(String userId);
}