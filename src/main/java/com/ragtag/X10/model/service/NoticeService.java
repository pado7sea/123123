package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.Notice;
import com.ragtag.X10.model.dto.Subject;

import java.util.List;

public interface NoticeService {
    int createOne(Notice notice);

    List<Notice> usersAllNotice(String userId);

    int checkNotice(int noticeId);

    int deleteNotice(int noticeId);
}
