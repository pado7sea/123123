package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.SubjectDao;
import com.ragtag.X10.model.dto.Subject;
import com.ragtag.X10.model.dto.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDao subjectDao;

    @Autowired
    public SubjectServiceImpl(SubjectDao subjectDao) { this.subjectDao = subjectDao;
    }

    @Override
    public int createSubject(Subject subject) {
        return subjectDao.createSubject(subject);
    }

    @Override
    public List<Subject> readAll(int groupId) {
        return subjectDao.readAll(groupId);
    }

    @Override
    public int updateSubject(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    @Override
    public int deleteSubject(int subjectId) {
        return subjectDao.deleteSubject(subjectId);
    }
}
