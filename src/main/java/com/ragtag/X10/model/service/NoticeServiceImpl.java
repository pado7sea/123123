package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.NoticeDao;
import com.ragtag.X10.model.dao.SubjectDao;
import com.ragtag.X10.model.dto.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDao noticeDao;

    @Autowired
    public NoticeServiceImpl(NoticeDao noticeDao) { this.noticeDao = noticeDao;
    }

    @Override
    public int createOne(Notice notice) {
        return noticeDao.insertNotice(notice);
    }

    @Override
    public List<Notice> usersAllNotice(String userId) {
        return noticeDao.selectAllNotice(userId);
    }

    @Override
    public int checkNotice(int noticeId) {
        return noticeDao.updateNotice(noticeId);
    }

    @Override
    public int deleteNotice(int noticeId) {
        return noticeDao.deleteNotice(noticeId);
    }
}
