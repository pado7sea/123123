package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.GroupsDao;
import com.ragtag.X10.model.dto.GroupMember;
import com.ragtag.X10.model.dto.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsServiceImpl implements GroupsService{

    @Autowired
    GroupsDao groupsDao;

    @Override
    public int insertGroups(Groups groups) {
        return groupsDao.insertGroups(groups);
    }

    @Override
    public List<Groups> selectOne(int groupId) {
        return groupsDao.selectOne(groupId);
    }

    @Override
    public List<Groups> selectUserGroups(String userId) {
        return groupsDao.selectUserGroups(userId);
    }

    @Override
    public List<GroupMember> selectAllUsers(int groupId) {
        return groupsDao.selectAllUsers(groupId);
    }

    @Override
    public int updateGroups(Groups groups) {
        return groupsDao.updateGroups(groups);
    }

    @Override
    public int deleteGroups(int groupId) {
        return groupsDao.deleteGroups(groupId);
    }

    @Override
    public int inviteUser(int groupId, String userId) {
        return groupsDao.inviteUser(groupId, userId);
    }

    @Override
    public int quitGroup(int groupId, String userId) {
        return groupsDao.quitGroup(groupId, userId);
    }
}
