package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.GroupMember;
import com.ragtag.X10.model.dto.Groups;
import com.ragtag.X10.model.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GroupsService {
    int insertGroups(Groups groups); // 그룹 생성

    Groups selectOne(int groupId); // 그룹 상세정보 조회

    List<Groups> selectUserGroups(String userId); // 유저 가입 그룹 전체 조회

    List<GroupMember> selectAllUsers(int groupId); // 그룹 내 유저 전체 조회

    List<User> selectAllUsersInfo(int groupId);

    int updateGroups(Groups groups); // 그룹 수정

    int updateGroupsImg(Groups groups); // 그룹 이미지 수정

    int deleteGroups(int groupId); // 그룹 삭제

    int inviteUser(int groupId, String userId); // 그룹원 초대

    int quitGroup(int groupId, String userId); // 그룹원 탈퇴

}
