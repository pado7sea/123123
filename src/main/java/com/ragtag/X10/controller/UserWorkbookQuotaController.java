package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.UserWorkbookQuota;
import com.ragtag.X10.model.service.UserWorkbookQuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/workbookquota")
public class UserWorkbookQuotaController {

    @Autowired
    private UserWorkbookQuotaService userWorkbookQuotaService;

    // 문제집 할당량 조회
    @GetMapping("{workbookId}/read/{userId}")
    public ResponseEntity<?> readUserWorkbookQuota(@PathVariable("workbookId") int workbookId, @PathVariable("userId") String userId) {
        List<UserWorkbookQuota> userWorkbookQuotas = userWorkbookQuotaService.readUserWorkbookQuota(workbookId, userId);

        if (userWorkbookQuotas == null || userWorkbookQuotas.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userWorkbookQuotas, HttpStatus.OK);
    }

    // 문제집 할당량 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateUserWorkbookQuota(@RequestBody UserWorkbookQuota userWorkbookQuota) {
        int result = userWorkbookQuotaService.updateUserWorkbookQuota(userWorkbookQuota);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 문제집 할당량 삭제
    @DeleteMapping("{workbookId}/delete/{userId}")
    public ResponseEntity<?> deleteUserWorkbookQuota(@PathVariable("workbookId") int workbookId, @PathVariable("userId") String userId) {
        int result = userWorkbookQuotaService.deleteUserWorkbookQuota(workbookId, userId);

        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
