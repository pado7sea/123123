package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.MultipleChoiceDao;
import com.ragtag.X10.model.dto.MultipleChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultipleChoiceServiceImpl implements MultipleChoiceService {

    private final MultipleChoiceDao multipleChoiceDao;

    @Autowired
    public MultipleChoiceServiceImpl(MultipleChoiceDao multipleChoiceDao){
        this.multipleChoiceDao = multipleChoiceDao;
    }

    @Override
    public int createMultipleChoice(MultipleChoice multipleChoice) {
        return multipleChoiceDao.createMultipleChoice(multipleChoice);
    }

    @Override
    public List<MultipleChoice> readAllMultipleChoices(int questionId) {
        return multipleChoiceDao.readAllMultipleChoices(questionId);
    }

    @Override
    public int updateMultipleChoice(MultipleChoice multipleChoice) {
        return multipleChoiceDao.updateMultipleChoice(multipleChoice);
    }

    @Override
    public int deleteMultipleChoice(int multipleChoiceId) {
        return multipleChoiceDao.deleteMultipleChoice(multipleChoiceId);
    }
}
