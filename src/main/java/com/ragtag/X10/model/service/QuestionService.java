package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.Question;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {

    int createQuestion(Question question);

    Question readQuestionById(int questionId);

    List<Question> readAllQuestionsByWorkbookId(int workbookId);

    int updateQuestion(Question workbook);

    int deleteQuestion(int workbookId);

}
