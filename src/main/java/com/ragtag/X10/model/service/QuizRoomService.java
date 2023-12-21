package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.QuizRoom;
import com.ragtag.X10.model.dto.User;
import com.ragtag.X10.model.dto.UserQuizRoom;

import java.util.List;

public interface QuizRoomService {
    //QuizRoom 테이블 관련
    int createRoom(QuizRoom quizRoom);

    List<QuizRoom> searchRoom(int groupId);

    QuizRoom detail(int quizRoomId);

    int changeMode(QuizRoom quizRoom);

    int deleteQuizRoom(int quizRoomId);

    void changeCreator(QuizRoom quizRoom);

    void startQuiz(int quizRoomId);

    //UserQuizRoom 테이블 관련
    int enterRoom(UserQuizRoom userQuizRoom);

    int setStartTime(int quizRoomId);

    String getStartTime(String userId);

    int userReady(String userId);

    List<User> roomAllUser(int quizRoomId);

    int exitRoom(String userId);
}
