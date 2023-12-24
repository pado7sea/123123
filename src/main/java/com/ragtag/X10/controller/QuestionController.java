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

    // 문제 생성
    @PostMapping("/create")
    public ResponseEntity<?> createQuestion(@RequestBody Question question) {
        int result = questionService.createQuestion(question);

        if (result == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            int createdQuestionId = question.getQuestionId();
            Question createdQuestion = questionService.readQuestionById(createdQuestionId);
            return new ResponseEntity<>(createdQuestion, HttpStatus.OK);
        }
    }

    // 문제 상세정보 조회
    @GetMapping("/read/{questionId}")
    public ResponseEntity<?> readQuestion(@PathVariable("questionId") int questionId) {
        Question question = questionService.readQuestionById(questionId);
        if (question == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    // 문제 상세정보 + MultipleChoice 조회
    @GetMapping("/readWithChoices/{questionId}")
    public ResponseEntity<?> readQuestionWithMultipleChoices(@PathVariable("questionId") int questionId) {
        Question question = questionService.readQuestionWithMultipleChoices(questionId);
        if (question == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }


    // 문제집 내 모든 문제 + 각 문제의 MultipleChoice 목록을 함께 조회
    @GetMapping("/readAll/{workbookId}")
    public ResponseEntity<?> readAllQuestionsByWorkbookId(@PathVariable("workbookId") int workbookId) {
        List<Question> questions = questionService.readAllQuestionsByWorkbookId(workbookId);
        if (questions == null || questions.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // 문제 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        int result = questionService.updateQuestion(question);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 문제 삭제
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") int questionId) {
        int result = questionService.deleteQuestion(questionId);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
