package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.GroupsDao;
import com.ragtag.X10.model.dao.UserWorkbookQuotaDao;
import com.ragtag.X10.model.dto.UserWorkbookQuota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWorkbookQuotaServiceImpl implements UserWorkbookQuotaService{

    @Autowired
    UserWorkbookQuotaDao userWorkbookQuotaDao;

    // 조회
    @Override
    public List<UserWorkbookQuota> readUserWorkbookQuota(int workbookId, String userId) {
        return userWorkbookQuotaDao.readUserWorkbookQuota(workbookId, userId);
    }

    // 수정
    @Override
    public int updateUserWorkbookQuota(UserWorkbookQuota userWorkbookQuota) {
        return userWorkbookQuotaDao.updateUserWorkbookQuota(userWorkbookQuota);
    }

    // 삭제
    @Override
    public int deleteUserWorkbookQuota(int workbookId, String userId) {
        return userWorkbookQuotaDao.deleteUserWorkbookQuota(workbookId, userId);
    }
}
