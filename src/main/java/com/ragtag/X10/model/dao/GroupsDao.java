package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.GroupMember;
import com.ragtag.X10.model.dto.Groups;
import com.ragtag.X10.model.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupsDao {

    int insertGroups(Groups groups); // 그룹 생성

    String selectGroupLeader(int groupId); // 그룹 리더 아이디 조회

    void insertGroupMember(@Param("groupId") int groupId, @Param("groupLeaderId") String groupLeaderId); // 그룹 멤버 추가

    Groups selectOne(int groupId); // 그룹 상세정보 조회

    List<Groups> selectUserGroups(String userId); // 유저 가입 그룹 전체 조회

    List<GroupMember> selectAllUsers(int groupId); // 그룹 내 유저 전체 조회

    List<User> selectAllUsersInfo(int groupId); // 그룹 내 유저 전체 조회

    int updateGroups(Groups groups); // 그룹 수정
    
    int updateGroupsImg(Groups groups); // 그룹 이미지 수정

    int deleteGroups(int groupId); // 그룹 삭제

    int inviteUser(@Param("groupId") int groupId, @Param("userId") String userId); // 그룹원 초대

    int quitGroup(@Param("groupId") int groupId, @Param("userId") String userId); // 그룹원 탈퇴
}
