package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.QuizRoom;
import com.ragtag.X10.model.dto.User;
import com.ragtag.X10.model.dto.UserQuizRoom;

import java.util.List;

public interface QuizRoomDao {
    //QuizRoom 테이블 관련
    int insertQuizRoom(QuizRoom quizRoom);

    List<QuizRoom> selectAll(int groupId);

    QuizRoom selectOne(int quizRoomId);

    int updateMode(QuizRoom quizRoom);

    int deleteQuizRoom(int quizRoomId);

    void updateCreator(QuizRoom quizRoom);

    void updateStarted(int quizRoomId);

    //UserQuizRoom 테이블 관련
    int insertUserQuizRoom(UserQuizRoom userQuizRoom);

    int updateStartTime(int quizRoomId);

    String selectStartTime(String userId);

    int updateIsReady(String userId);

    List<User> selectAllUser(int quizRoomId);

    int deleteUserQuizRoom(String userId);
}
