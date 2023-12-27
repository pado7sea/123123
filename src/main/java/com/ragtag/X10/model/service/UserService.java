package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.User;

import java.util.List;

public interface UserService {
    int signUpUser(User user);

    User loginUser(String userId);

    int modifyUser(User user);

    int modifyUserImg(User user);

    boolean isLeader(String userId);

    List<User> searchUser(String keyword);

    User userInfo(String userId);

    int deleteUser(String userId);

    int updateExp(String userId, int exp);
}