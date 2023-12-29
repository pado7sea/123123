package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.Question;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {

    int createQuestion(Question question);

    Question readQuestionById(int questionId);

    Question readQuestionWithMultipleChoices(int questionId);

    List<Question> readAllQuestionsByWorkbookId(int workbookId);

    int updateQuestion(Question question);

    int deleteQuestion(int workbookId);

}
