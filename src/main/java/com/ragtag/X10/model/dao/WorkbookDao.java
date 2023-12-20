package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.Workbook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkbookDao {

    int createWorkbook(Workbook workbook);

    Workbook readWorkbookById(int workbookId);

    List<Workbook> readAllWorkbooksBySubjectId(int subjectId);

    List<Workbook> getRecentCreatedWorkbooksByUserId(String userId);

    List<Workbook> getRecentSolvedWorkbooksByUserId(String userId);

    int updateWorkbook(Workbook workbook);

    int deleteWorkbook(int workbookId);

}
