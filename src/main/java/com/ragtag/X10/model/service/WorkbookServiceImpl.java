package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.WorkbookDao;
import com.ragtag.X10.model.dto.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkbookServiceImpl implements WorkbookService{
    private final WorkbookDao workbookDao;

    @Autowired
    public WorkbookServiceImpl(WorkbookDao workbookDao) {
        this.workbookDao = workbookDao;
    }

    public int createWorkbook(Workbook workbook) {
        return workbookDao.createWorkbook(workbook);
    }

    public Workbook readWorkbookById(int workbookId) {
        return workbookDao.readWorkbookById(workbookId);
    }

    public List<Workbook> readAllWorkbooksBySubjectId(int subjectId) {
        return workbookDao.readAllWorkbooksBySubjectId(subjectId);
    }

    public List<Workbook> getRecentWorkbooksByUserId(String userId) {
        return workbookDao.getRecentWorkbooksByUserId(userId);
    }

    public int updateWorkbook(Workbook workbook) {
        return workbookDao.updateWorkbook(workbook);
    }

    public int deleteWorkbook(int workbookId) {
        return workbookDao.deleteWorkbook(workbookId);
    }
}
