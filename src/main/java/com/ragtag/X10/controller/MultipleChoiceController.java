package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.MultipleChoice;
import com.ragtag.X10.model.service.MultipleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/multiplechoice")
public class MultipleChoiceController {

    private final MultipleChoiceService multipleChoiceService;

    @Autowired
    public MultipleChoiceController(MultipleChoiceService multipleChoiceService) {
        this.multipleChoiceService = multipleChoiceService;
    }

    // 1. 객관식 선지 생성
    @PostMapping("/create")
    public ResponseEntity<Void> createMultipleChoice(@RequestBody MultipleChoice multipleChoice) {
        int result = multipleChoiceService.createMultipleChoice(multipleChoice);
        if (result == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // 2. 객관식 선지 조회
    @GetMapping("/readAll/{questionId}")
    public ResponseEntity<List<MultipleChoice>> readAllMultipleChoices(@PathVariable("questionId") int questionId) {
        List<MultipleChoice> multipleChoices = multipleChoiceService.readAllMultipleChoices(questionId);
        if (multipleChoices == null || multipleChoices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(multipleChoices, HttpStatus.OK);
        }
    }

    // 3. 객관식 선지 수정
    @PutMapping("/update/{multipleChoiceId}")
    public ResponseEntity<Void> updateMultipleChoice(@RequestBody MultipleChoice multipleChoice) {
        int result = multipleChoiceService.updateMultipleChoice(multipleChoice);
        if (result == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // 4. 객관식 선지 삭제
    @DeleteMapping("/delete/{multipleChoiceId}")
    public ResponseEntity<Void> deleteMultipleChoice(@PathVariable("multipleChoiceId") int multipleChoiceId) {
        int result = multipleChoiceService.deleteMultipleChoice(multipleChoiceId);
        if (result == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
