package com.ragtag.X10.service;

import com.ragtag.X10.model.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizDao quizDao;

}
