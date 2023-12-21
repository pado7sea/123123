package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.MultipleChoice;

import java.util.List;

public interface MultipleChoiceService {

    int createMultipleChoice(MultipleChoice multipleChoice);

    List<MultipleChoice> readAllMultipleChoices(int questionId);

    int updateMultipleChoice(MultipleChoice multipleChoice);

    int deleteMultipleChoice(int multipleChoiceId);

}
