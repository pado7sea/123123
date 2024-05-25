package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.UserWorkbookQuota;
import com.ragtag.X10.model.dto.Workbook;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WorkbookDao {

    int createWorkbook(Workbook workbook);

    // 문제집 할당량 생성
    int createUserWorkbookQuota(Map<String, Object> paramMap);

    Workbook readWorkbookById(int workbookId);

    List<Workbook> readAllWorkbooksBySubjectId(int subjectId);

    List<Workbook> getRecentCreatedWorkbooksByUserId(String userId);

    List<Workbook> getRecentSolvedWorkbooksByUserId(String userId);

    int updateWorkbook(Workbook workbook);

    int deleteWorkbook(int workbookId);

}
