package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.Question;

import java.util.List;

public interface QuestionDao {

    int createQuestion(Question question);

    Question readQuestionById(int questionId);

    Question readQuestionWithMultipleChoices(int questionId);

    List<Question> readAllQuestionsByWorkbookId(int workbookId);

    int updateQuestion(Question question);

    int deleteQuestion(int workbookId);

}
