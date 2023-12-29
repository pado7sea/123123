package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.UserQuestionRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserQuestionRecordDao {

    int createUserQuestionRecord(UserQuestionRecord userQuestionRecord);

    List<UserQuestionRecord> readUserQuestionRecord(@Param("questionId") int questionId, @Param("userId") String userId);

    int updateUserQuestionRecord(UserQuestionRecord userQuestionRecord);

}
