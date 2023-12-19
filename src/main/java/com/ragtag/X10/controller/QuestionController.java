package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.Question;
import com.ragtag.X10.model.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // 1. 퀴즈 생성
    @PostMapping("/create")
    public ResponseEntity<?> createQuestion(@RequestBody Question question) {
        int result = questionService.createQuestion(question);

        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 2. 퀴즈 상세정보 조회
    @GetMapping("/read/{questionId}")
    public ResponseEntity<?> readQuestion(@PathVariable("questionId") int questionId) {
        Question question = questionService.readQuestionById(questionId);
        if (question == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    // 3. 문제집 내 퀴즈 조회
    @GetMapping("/readAll/{workbookId}")
    public ResponseEntity<?> readAllQuestionsByWorkbookId(@PathVariable("workbookId") int workbookId) {
        List<Question> questions = questionService.readAllQuestionsByWorkbookId(workbookId);
        if (questions == null || questions.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // 4. 퀴즈 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        int result = questionService.updateQuestion(question);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 5. 퀴즈 삭제
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") int questionId) {
        int result = questionService.deleteQuestion(questionId);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
