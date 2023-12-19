package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.Workbook;

import java.util.List;

public interface WorkbookDao {

    int createWorkbook(Workbook workbook);

    Workbook readWorkbookById(int workbookId);

    List<Workbook> readAllWorkbooksBySubjectId(int subjectId);

    List<Workbook> getRecentWorkbooksByUserId(String userId);

    int updateWorkbook(Workbook workbook);

    int deleteWorkbook(int workbookId);

}
