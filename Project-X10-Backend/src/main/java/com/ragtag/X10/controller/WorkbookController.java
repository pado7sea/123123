package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.Workbook;
import com.ragtag.X10.model.service.WorkbookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/workbook")
public class WorkbookController {

    private final WorkbookService workbookService;

    @Autowired
    public WorkbookController(WorkbookService workbookService) {
        this.workbookService = workbookService;
    }

    // 1. 문제집 생성
    @PostMapping("/create/{groupId}")
    public ResponseEntity<?> createWorkbook(@RequestBody Workbook workbook, @PathVariable("groupId") int groupId) {
        int result = workbookService.createWorkbook(workbook, groupId);
        if (result <= 1)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 2. 문제집 상세정보 조회
    @GetMapping("/read/{workbookId}")
    public ResponseEntity<?> readWorkbookById(@PathVariable("workbookId") int workbookId) {
        Workbook workbook = workbookService.readWorkbookById(workbookId);
        if (workbook == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(workbook, HttpStatus.OK);
    }

    // 3. 과목 내 문제집 조회
    @GetMapping("/readAll/{subjectId}")
    public ResponseEntity<?> readAllWorkbooksBySubjectId(@PathVariable("subjectId") int subjectId) {
        List<Workbook> workbook = workbookService.readAllWorkbooksBySubjectId(subjectId);
        if (workbook == null || workbook.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(workbook, HttpStatus.OK);
    }

    // 4-1. 최근에 만들어진 문제집
    @GetMapping("/recentCreated/{userId}")
    public ResponseEntity<?> getRecentCreatedWorkbooksByUserId(@PathVariable("userId") String userId) {
        List<Workbook> workbooks = workbookService.getRecentCreatedWorkbooksByUserId(userId);
        if (workbooks == null || workbooks.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(workbooks, HttpStatus.OK);
    }

    // 4-2. 최근에 푼 문제집
    @GetMapping("/recentSolved/{userId}")
    public ResponseEntity<?> getRecentSolvedWorkbooksByUserId(@PathVariable("userId") String userId) {
        List<Workbook> workbooks = workbookService.getRecentSolvedWorkbooksByUserId(userId);
        if (workbooks == null || workbooks.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(workbooks, HttpStatus.OK);
    }

    // 5. 문제집 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateWorkbook(@RequestBody Workbook workbook) {
        int result = workbookService.updateWorkbook(workbook);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 6. 문제집 삭제
    @DeleteMapping("/delete/{workbookId}")
    public ResponseEntity<?> deleteWorkbook(@PathVariable("workbookId") int workbookId) {
        int result = workbookService.deleteWorkbook(workbookId);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
