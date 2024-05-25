package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.Subject;
import com.ragtag.X10.model.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){  this.subjectService = subjectService; }

    // 1. 과목 생성
    @PostMapping("/create")
    public ResponseEntity<?> createSubject(@RequestBody Subject subject) {
        int result = subjectService.createSubject(subject);

        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 2. 그룹 내 과목 조회
    @GetMapping("/readAll/{groupId}")
    public ResponseEntity<?> readAll(@PathVariable(name = "groupId") int groupId) {
        List<Subject> subject = subjectService.readAll(groupId);
        if (subject == null || subject.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    // 3. 과목 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateSubject(@RequestBody Subject subject) {
        int result = subjectService.updateSubject(subject);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 4. 과목 삭제
    @DeleteMapping("/delete/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable(name = "subjectId") int subjectId) {
        int result = subjectService.deleteSubject(subjectId);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
