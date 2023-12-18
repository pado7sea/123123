package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.UserDao;
import com.ragtag.X10.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int signUpUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User loginUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean isLeader(String userId) {
        return userDao.checkLeader(userId);
    }

    @Override
    public List<User> searchUser(String userId) {
        return userDao.selectByUserId(userId);
    }

    @Override
    public User userInfo(String userId) {
        return userDao.selectUser(userId);
    }

    @Override
    public int deleteUser(String userId) {
        return userDao.deleteUser(userId);
    }
}