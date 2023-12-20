package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.Question;
import com.ragtag.X10.model.dto.UserQuestionRecord;
import com.ragtag.X10.model.service.UserQuestionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/userquestionrecord")
public class UserQuestionRecordController {

    private final UserQuestionRecordService userQuestionRecordService;
    @Autowired
    public UserQuestionRecordController(UserQuestionRecordService userQuestionRecordService){
        this.userQuestionRecordService = userQuestionRecordService;
    }

    // 유저 퀴즈 결과 입력
    @PostMapping("/create")
    public ResponseEntity<?> createUserQuestionRecord(@RequestBody UserQuestionRecord userQuestionRecord) {
        int result = userQuestionRecordService.createUserQuestionRecord(userQuestionRecord);

        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 유저 퀴즈 결과 조회
    @GetMapping("/read/{questionId}/user/{userId}")
    public ResponseEntity<?> readUserQuestionRecord(@PathVariable("questionId") int questionId, @PathVariable("userId") String userId) {
        List<UserQuestionRecord> userQuestionRecord = userQuestionRecordService.readUserQuestionRecord(questionId, userId);
        if (userQuestionRecord == null || userQuestionRecord.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userQuestionRecord, HttpStatus.OK);
    }

    // 유저 퀴즈 결과 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateUserQuestionRecord(@RequestBody UserQuestionRecord userQuestionRecord) {
        int result = userQuestionRecordService.updateUserQuestionRecord(userQuestionRecord);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
