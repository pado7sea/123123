package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.Subject;

import java.util.List;

public interface SubjectDao {
    int createSubject(Subject subject);

    List<Subject> readAll(int groupId);

    int updateSubject(Subject subject);

    int deleteSubject(int subjectId);
}
