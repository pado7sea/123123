package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.Notice;
import com.ragtag.X10.model.dto.TodoList;

import java.util.List;

public interface NoticeDao {
    int insertNotice(Notice notice);

    List<Notice> selectAllNotice(String userId);

    int updateNotice(int noticeId);

    int deleteNotice(int noticeId);

}
