package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.UserQuestionRecordDao;
import com.ragtag.X10.model.dto.UserQuestionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuestionRecordServiceImpl implements UserQuestionRecordService{

    private final UserQuestionRecordDao userQuestionRecordDao;

    @Autowired
    public UserQuestionRecordServiceImpl(UserQuestionRecordDao userQuestionRecordDao) {
        this.userQuestionRecordDao = userQuestionRecordDao;
    }

    // 유저 퀴즈 결과 입력
    @Override
    public int createUserQuestionRecord(UserQuestionRecord userQuestionRecord) {
        return userQuestionRecordDao.createUserQuestionRecord(userQuestionRecord);
    }

    // 유저 퀴즈 결과 조회
    @Override
    public List<UserQuestionRecord> readUserQuestionRecord(int questionId, String userId) {
        return userQuestionRecordDao.readUserQuestionRecord(questionId, userId);
    }

    // 유저 퀴즈 결과 수정
    @Override
    public int updateUserQuestionRecord(UserQuestionRecord userQuestionRecord) {
        return userQuestionRecordDao.updateUserQuestionRecord(userQuestionRecord);
    }
}
