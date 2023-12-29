package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.QuizRoomDao;
import com.ragtag.X10.model.dto.QuizRoom;
import com.ragtag.X10.model.dto.User;
import com.ragtag.X10.model.dto.UserQuizRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizRoomServiceImpl implements QuizRoomService {

    private final QuizRoomDao quizRoomDao;

    @Autowired
    public QuizRoomServiceImpl(QuizRoomDao quizRoomDao) {
        this.quizRoomDao = quizRoomDao;
    }


    @Override
    public int createRoom(QuizRoom quizRoom) {
        int result = quizRoomDao.insertQuizRoom(quizRoom);

        if (result > 0) {
            UserQuizRoom userQuizRoom = new UserQuizRoom();
            userQuizRoom.setQuizRoomId(quizRoom.getQuizRoomId());
            userQuizRoom.setUserId(quizRoom.getQuizRoomCreator());
            result = quizRoomDao.insertUserQuizRoom(userQuizRoom);
        }

        return result;
    }

    @Override
    public List<QuizRoom> searchRoom(int groupId) {
        return quizRoomDao.selectAll(groupId);
    }

    @Override
    public QuizRoom detail(int quizRoomId) {
        return quizRoomDao.selectOne(quizRoomId);
    }

    @Override
    public int changeMode(QuizRoom quizRoom) {
        return quizRoomDao.updateMode(quizRoom);
    }

    @Override
    public int deleteQuizRoom(int quizRoomId) {
        return quizRoomDao.deleteQuizRoom(quizRoomId);
    }

    @Override
    public void changeCreator(QuizRoom quizRoom) {
        quizRoomDao.updateCreator(quizRoom);
    }

    @Override
    public void startQuiz(int quizRoomId) {
        quizRoomDao.updateStarted(quizRoomId);
    }

    @Override
    public int enterRoom(UserQuizRoom userQuizRoom) {
        return quizRoomDao.insertUserQuizRoom(userQuizRoom);
    }

    @Override
    public int setStartTime(int quizRoomId) {
        return quizRoomDao.updateStartTime(quizRoomId);
    }

    @Override
    public String getStartTime(String userId) {
        return quizRoomDao.selectStartTime(userId);
    }

    @Override
    public int userReady(String userId) {
        return quizRoomDao.updateIsReady(userId);
    }

    @Override
    public List<User> roomAllUser(int quizRoomId) {
        return quizRoomDao.selectAllUser(quizRoomId);
    }

    @Override
    public int exitRoom(String userId) {
        return quizRoomDao.deleteUserQuizRoom(userId);
    }
}
