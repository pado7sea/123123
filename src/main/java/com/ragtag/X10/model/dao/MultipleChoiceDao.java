package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.MultipleChoice;

import java.util.List;

public interface MultipleChoiceDao {

    int createMultipleChoice(MultipleChoice multipleChoice);

    List<MultipleChoice> readAllMultipleChoices(int questionId);

    int updateMultipleChoice(MultipleChoice multipleChoice);

    int deleteMultipleChoice(int multipleChoiceId);

}
