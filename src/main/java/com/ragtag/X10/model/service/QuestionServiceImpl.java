package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.MultipleChoiceDao;
import com.ragtag.X10.model.dao.QuestionDao;
import com.ragtag.X10.model.dto.MultipleChoice;
import com.ragtag.X10.model.dto.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;
    private final MultipleChoiceDao multipleChoiceDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao, MultipleChoiceDao multipleChoiceDao) {
        this.questionDao = questionDao;
        this.multipleChoiceDao = multipleChoiceDao;
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
        // questionId에 맞는 문제정보 조회해서 문제 가져오고
        Question question = questionDao.readQuestionWithMultipleChoices(questionId);
        // 만약에 문제가 객관식이라면 객관식 선지 가져오기
        if (question.getQuestionType() == 1) {
            List<MultipleChoice> multipleChoices = multipleChoiceDao.readAllMultipleChoices(questionId);
            question.setMultipleChoices(multipleChoices);
        }
        return question;
    }

    @Override
    public List<Question> readAllQuestionsByWorkbookId(int workbookId) {
        List<Question> questions = questionDao.readAllQuestionsByWorkbookId(workbookId);

        for (Question question : questions) {
            // 각 문제가 객관식인 경우에만 객관식 선지를 가져오기
            if (question.getQuestionType() == 1) {
                List<MultipleChoice> multipleChoices = multipleChoiceDao.readAllMultipleChoices(question.getQuestionId());
                question.setMultipleChoices(multipleChoices);
            }
        }

        return questions;
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
