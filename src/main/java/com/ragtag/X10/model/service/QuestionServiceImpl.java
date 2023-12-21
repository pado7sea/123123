package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.QuestionDao;
import com.ragtag.X10.model.dto.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao){
        this.questionDao = questionDao;
    }

    @Override
    public int createQuestion(Question question) {

        return questionDao.createQuestion(question);
    }

    @Override
    public Question readQuestionById(int questionId) {

        return questionDao.readQuestionById(questionId);
    }

    @Override
    public Question readQuestionWithMultipleChoices(int questionId) {
        return questionDao.readQuestionWithMultipleChoices(questionId);
    }

    @Override
    public List<Question> readAllQuestionsByWorkbookId(int workbookId) {
        return questionDao.readAllQuestionsByWorkbookId(workbookId);
    }

    @Override
    public int updateQuestion(Question question) {
        return questionDao.updateQuestion(question);
    }

    @Override
    public int deleteQuestion(int workbookId) {
        return questionDao.deleteQuestion(workbookId);
    }
}
